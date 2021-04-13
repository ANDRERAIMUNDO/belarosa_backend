package me.andreraimundo.belarosa_backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import me.andreraimundo.belarosa_backend.domain.Cliente;

@Repository
public interface ClienteRepository  extends JpaRepository <Cliente, Integer>{
    @Transactional(readOnly= true)
    Cliente findByName (String name);
    
}
