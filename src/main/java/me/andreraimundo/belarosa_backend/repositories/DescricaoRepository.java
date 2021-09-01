package me.andreraimundo.belarosa_backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import me.andreraimundo.belarosa_backend.domain.Descricao;

@Repository
public interface DescricaoRepository extends JpaRepository <Descricao, Integer>{
    
}
