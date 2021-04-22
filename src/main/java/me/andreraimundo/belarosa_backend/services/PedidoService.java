package me.andreraimundo.belarosa_backend.services;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import me.andreraimundo.belarosa_backend.domain.Cliente;
import me.andreraimundo.belarosa_backend.domain.ItemPedido;
import me.andreraimundo.belarosa_backend.domain.PagamentoBoleto;
import me.andreraimundo.belarosa_backend.domain.PagamentoDinheiro;
import me.andreraimundo.belarosa_backend.domain.Pedido;
import me.andreraimundo.belarosa_backend.domain.enums.SituacaoPedido;
import me.andreraimundo.belarosa_backend.repositories.ItemPedidoRepository;
import me.andreraimundo.belarosa_backend.repositories.PagamentoRepository;
import me.andreraimundo.belarosa_backend.repositories.PedidoRepository;
import me.andreraimundo.belarosa_backend.services.exception.ObjectNotFoundException;

@Service
public class PedidoService {
    
    @Autowired
    PedidoRepository pedidoRepository;

    @Autowired
    BoletoService boletoService;

    @Autowired
    ClienteService clienteService;

    @Autowired
    RegistroService registroService;

    @Autowired
    ProdutoService produtoService;

    @Autowired
    ItemPedidoRepository itemPedidoRepository;

    @Autowired
    PagamentoRepository pagamentoRepository;

    @Autowired
    DinheiroService dinheiroService;

    public Pedido find (Integer id) {
        Optional <Pedido> obj = pedidoRepository.findById(id);
        return obj.orElseThrow(()-> new 
        ObjectNotFoundException("Objeto não encontrado Id: "+ id + " Tipo: "
         + Pedido.class.getName()));
    }

    @Transactional
    public Pedido insert (Pedido obj) {
        obj.setId(null);
        obj.setInstante(new Date());
        obj.setRegistro(registroService.find(obj.getRegistro().getId()));
        obj.setCliente(clienteService.find(obj.getCliente().getId()));
        obj.getPagamento().setSituacaoPedido(SituacaoPedido.PENDENTE);
        obj.getPagamento().setPedido(obj);

        if (obj.getPagamento() instanceof PagamentoBoleto) {
            PagamentoBoleto pagamentoBoleto = (PagamentoBoleto) obj.getPagamento();
            boletoService.preencherPegamentoComBoleto(pagamentoBoleto, obj.getInstante());
        }
        if (obj.getPagamento() instanceof PagamentoDinheiro) {
            PagamentoDinheiro pagamentoDinheiro = (PagamentoDinheiro) obj.getPagamento();
            dinheiroService.pagamentoAvista(pagamentoDinheiro, obj.getInstante());
            obj.getPagamento().setSituacaoPedido(SituacaoPedido.QUITADO);
        }
        obj = pedidoRepository.save(obj);
        pagamentoRepository.save(obj.getPagamento());
        for (ItemPedido itemPedido : obj.getItens()) {
            itemPedido.setDesconto(0.0);
            itemPedido.setProduto(produtoService.find(itemPedido.getProduto().getId()));
            itemPedido.setPrice(itemPedido.getProduto().getPrice());
            itemPedido.setPedido(obj);
        } 
        itemPedidoRepository.saveAll(obj.getItens());
        System.out.println(obj);
        
        return obj;
    }

    public Page<Pedido> findPage(String name, Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		Cliente cliente =  clienteService.findByName(name);
		return pedidoRepository.findByCliente(cliente, pageRequest);
	}

}
