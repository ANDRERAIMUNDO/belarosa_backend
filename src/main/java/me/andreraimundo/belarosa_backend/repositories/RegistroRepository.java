package me.andreraimundo.belarosa_backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import me.andreraimundo.belarosa_backend.domain.Registro;

@Repository
public interface RegistroRepository  extends JpaRepository <Registro, Integer>{
    
    @Transactional(readOnly=true)
	Registro findByEmail(String email);

    @Query("select u from Registro u where u.email = ?1")
    Registro findByEmailAddress (String email);
}
