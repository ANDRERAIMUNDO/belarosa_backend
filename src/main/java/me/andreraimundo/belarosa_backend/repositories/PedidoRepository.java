package me.andreraimundo.belarosa_backend.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import me.andreraimundo.belarosa_backend.domain.Pedido;
import me.andreraimundo.belarosa_backend.domain.Registro;

@Repository
public interface PedidoRepository extends JpaRepository <Pedido, Integer> {
    @Transactional(readOnly = true)
	Page<Pedido> findByRegistro(Registro registro, Pageable pageRequest);
}
