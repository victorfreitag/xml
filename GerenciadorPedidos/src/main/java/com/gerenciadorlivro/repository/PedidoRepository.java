package com.gerenciadorlivro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gerenciadorlivro.entities.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long>{

}
