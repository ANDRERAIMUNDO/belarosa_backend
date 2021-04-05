package me.andreraimundo.belarosa_backend.services;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import me.andreraimundo.belarosa_backend.domain.ItemPedido;
import me.andreraimundo.belarosa_backend.domain.PagamentoBoleto;
import me.andreraimundo.belarosa_backend.domain.Pedido;
import me.andreraimundo.belarosa_backend.domain.enums.SituacaoPedido;
import me.andreraimundo.belarosa_backend.repositories.ItemPedidoRepository;
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
    ProdutoService produtoService;

    @Autowired
    ItemPedidoRepository itemPedidoRepository;

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
        obj.setCliente(clienteService.find(obj.getCliente().getId()));
        obj.getPagamento().setSituacaoPedido(SituacaoPedido.PENDENTE);
        obj.getPagamento().setPedido(obj);

        if (obj.getPagamento() instanceof PagamentoBoleto) {
            PagamentoBoleto pagamentoBoleto = (PagamentoBoleto) obj.getPagamento();
            boletoService.preencherPegamentoComBoleto(pagamentoBoleto, obj.getInstante());
        }
        obj = pedidoRepository.save(obj);
        
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

}
