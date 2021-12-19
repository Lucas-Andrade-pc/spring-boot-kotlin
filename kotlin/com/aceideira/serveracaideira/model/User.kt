package com.aceideira.serveracaideira.model

import javax.persistence.*

@Entity
data class User (
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Int? = null,
        val firstName: String? = null,
        val secondName: String? = null,
        val email: String? = null,
        val password: String? = null,
        @OneToMany(mappedBy = "user")
        val pedido: List<Pedido> = emptyList()
)