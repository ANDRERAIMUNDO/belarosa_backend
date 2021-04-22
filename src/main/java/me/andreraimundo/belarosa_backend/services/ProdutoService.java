package me.andreraimundo.belarosa_backend.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import me.andreraimundo.belarosa_backend.domain.Categoria;
import me.andreraimundo.belarosa_backend.domain.Produto;
import me.andreraimundo.belarosa_backend.dto.NewProdutoDTO;
import me.andreraimundo.belarosa_backend.dto.ProdutoDTO;
import me.andreraimundo.belarosa_backend.repositories.CategoriaRepository;
import me.andreraimundo.belarosa_backend.repositories.ProdutoRepository;
import me.andreraimundo.belarosa_backend.services.exception.ObjectNotFoundException;

@Service
public class ProdutoService {

    @Autowired  
    private ProdutoRepository produtoRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    CategoriaService categoriaService;
    
    public Produto find (Integer id){
        Optional <Produto> obj = produtoRepository.findById(id);
        return obj.orElseThrow(()-> new 
        ObjectNotFoundException("Objeto não encontrado Id: "+ id + " Tipo: "
         + Produto.class.getName()));
    }

    public Produto insert (Produto obj) {
        obj.setId(null);
      return produtoRepository.save(obj);
    }

    public Produto update (Produto obj) {
        Produto newObj = find(obj.getId());
        updateData(newObj, obj);
        return produtoRepository.save(newObj);
    }

    public void delete (Integer id){
        find(id);
        try {
            produtoRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException("Não é possivel excluir produto associado a pedido");
        }
    }

    public List <Produto> findAll () {
        return produtoRepository.findAll();
    }

	//public Page<Produto> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
	//	PageRequest pageRequest = PageRequest.of(page, linesPerPage,Direction.valueOf(direction), orderBy);
	//	return produtoRepository.findAll(pageRequest);
	//}

    public Page<Produto> search(String name, List<Integer> ids, Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage,Direction.valueOf(direction), orderBy);
        List<Categoria> categorias = categoriaRepository.findAllById(ids);
		return produtoRepository.findDistinctByNameContainingAndCategoriasIn(name, categorias, pageRequest);
	}

    public Produto fromDTO (ProdutoDTO objDto ) {
        return new Produto(null, objDto.getName(), objDto.getPrice());
    }

    public Produto fromDTO ( NewProdutoDTO objDto) {
        List <Categoria> categorias = new ArrayList<>(objDto.getCategorias());
        Produto prod = new Produto(null,objDto.getName(),objDto.getPrice());
        prod.getCategorias().addAll(categorias);
        return prod;
    }

    private void updateData (Produto newObj, Produto obj) {
        newObj.setName(obj.getName());
        newObj.setPrice(obj.getPrice());
    }
}

