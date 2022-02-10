package me.andreraimundo.belarosa_backend.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import me.andreraimundo.belarosa_backend.domain.Cliente;

@Repository
public interface ClienteRepository  extends JpaRepository <Cliente, Integer>{
    @Transactional(readOnly= true)
    Cliente findByName (String name);

    Cliente findBycpf(String cpf);

    Cliente findByDateNasc (String dateNasc);

    @Query("SELECT DISTINCT obj FROM Cliente obj WHERE obj.name LIKE %:name%")
    Page<Cliente> findByFirstNameIgnoreCase ( @Param("name") String name,Pageable pageRequest);
}