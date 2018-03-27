package com.backend.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.api.models.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer>{

}
