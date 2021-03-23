package me.andreraimundo.belarosa_backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import me.andreraimundo.belarosa_backend.domain.Endereco;

@Repository
public interface EnderecoRepository  extends JpaRepository <Endereco, Integer>{
    
}
