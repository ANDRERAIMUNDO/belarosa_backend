package me.andreraimundo.belarosa_backend.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import me.andreraimundo.belarosa_backend.domain.Categoria;
import me.andreraimundo.belarosa_backend.dto.CategoriaDTO;
import me.andreraimundo.belarosa_backend.repositories.CategoriaRepository;
import me.andreraimundo.belarosa_backend.services.exception.ObjectNotFoundException;

@Service
public class CategoriaService {

    @Autowired  
    private CategoriaRepository categoriaRepository;
    
    public Categoria find (Integer id){
        Optional <Categoria> obj = categoriaRepository.findById(id);
        return obj.orElseThrow(()-> new ObjectNotFoundException("Objeto não encontrado ! Id; " + id +"Tipo: "+ Categoria.class.getName()));
    }

    public Categoria insert (Categoria obj) {
        obj.setId(null);
        return categoriaRepository.save(obj);
    }

    public Categoria update (Categoria obj) {
        Categoria newObj = find(obj.getId());
        updateData(newObj, obj);
        return categoriaRepository.save(newObj);
    }

    public void delete (Integer id){
        find(id);
        try {
            categoriaRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException("Não é possivel excluir categoria associada a um produto");
        }
    }

    public List <Categoria> findAll () {
        return categoriaRepository.findAll();
    }

	public Page<Categoria> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage,Direction.valueOf(direction), orderBy);
		return categoriaRepository.findAll(pageRequest);
	}
    public Categoria fromDTO (CategoriaDTO objDto) {
        return new Categoria(objDto.getId(), objDto.getName());
    }
    private void updateData (Categoria newObj, Categoria obj) {
        newObj.setName(obj.getName());
    }
}
