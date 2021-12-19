package com.aceideira.serveracaideira.repositories

import com.aceideira.serveracaideira.model.Pedido
import org.springframework.data.jpa.repository.JpaRepository

interface PedidoRepository:JpaRepository<Pedido, Int>