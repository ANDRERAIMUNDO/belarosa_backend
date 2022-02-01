package me.andreraimundo.belarosa_backend.repositories.mercadopago;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import me.andreraimundo.belarosa_backend.domain.Registro;
import me.andreraimundo.belarosa_backend.dto.mercadopago.StatusPayment;

@Repository
public interface StatusPaymentRepository extends JpaRepository < StatusPayment, Integer> {
    @Transactional(readOnly = true)
	Page<StatusPayment> findByRegistro(Registro registro, Pageable pageRequest);

    @Query("SELECT DISTINCT obj FROM StatusPayment obj WHERE obj.id_process LIKE %:id_process%")
    Page<StatusPayment> findByFirstNameIgnoreCase ( @Param("id_process") String id_process,Pageable pageRequest);
}
