package com.aceideira.serveracaideira.repositories

import com.aceideira.serveracaideira.model.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository: JpaRepository<User, Int>