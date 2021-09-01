package me.andreraimundo.belarosa_backend.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import me.andreraimundo.belarosa_backend.domain.Registro;

@Repository
public interface RegistroRepository  extends JpaRepository <Registro, Integer>{
    
    @Transactional(readOnly=true)
	Registro findByEmail(String email);

    @Query("SELECT DISTINCT obj FROM Registro obj WHERE obj.email LIKE %:email%")
	Page <Registro>search(@Param("email") String email,Pageable pageRequest);
}
