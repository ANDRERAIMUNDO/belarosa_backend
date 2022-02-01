package me.andreraimundo.belarosa_backend.repositories.mercadopago;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import me.andreraimundo.belarosa_backend.dto.mercadopago.PixPayment;

@Repository
public interface PixPaymentRepository extends JpaRepository <PixPayment, Integer> {
    
}
