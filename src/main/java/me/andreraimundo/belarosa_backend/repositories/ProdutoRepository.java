package me.andreraimundo.belarosa_backend.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import me.andreraimundo.belarosa_backend.domain.Categoria;
import me.andreraimundo.belarosa_backend.domain.Produto;

@Repository
//@Transactional(readOnly=true)
public interface ProdutoRepository  extends JpaRepository <Produto, Integer> {

	@Transactional(readOnly = true)
	@Query("SELECT DISTINCT obj FROM Produto obj INNER JOIN obj.categorias cat WHERE obj.name LIKE %:name% AND cat IN :categorias")
	Page <Produto>search(@Param("name") String name,@Param("categorias") List<Categoria> categorias,Pageable pageRequest);

    @Query("SELECT DISTINCT obj FROM Produto obj WHERE obj.name LIKE %:name%")
    Page<Produto> findByFirstNameIgnoreCase ( @Param("name") String name,Pageable pageRequest);

	@Query("SELECT DISTINCT obj FROM Produto obj INNER JOIN obj.categorias cat WHERE obj.name LIKE %:name% AND cat IN :categorias")
	Page<Produto> findDistinctByNomeContainingAndCategoriasIn(
	@Param("name") String name,
	@Param("categorias") List<Categoria> categorias,
	Pageable pageRequest);
}


////findDistinctByModeloMarcaNomeIgnoreCaseAndOpcionaisNomeIn
