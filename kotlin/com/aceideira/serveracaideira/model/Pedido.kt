package com.aceideira.serveracaideira.model

import com.fasterxml.jackson.annotation.JsonBackReference
import javax.persistence.*

@Entity

data class Pedido (
    @Id
    @GeneratedValue
    val id: Int? = null,
    val nameClient: String? = null,
    val address: String? = null,
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    @JsonBackReference
    val user: User = User()
)


