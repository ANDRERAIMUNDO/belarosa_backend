package me.andreraimundo.belarosa_backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import me.andreraimundo.belarosa_backend.domain.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository <Pedido, Integer> {
    
}
