package com.aceideira.serveracaideira.controllers

import com.aceideira.serveracaideira.model.User
import com.aceideira.serveracaideira.repositories.UserRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/users")
class UserController(
    private val userRepository: UserRepository
) {

    @PostMapping
    fun new(@RequestBody newUser: User): ResponseEntity<User>{
        userRepository.save(newUser)
        return ResponseEntity.ok().body(newUser)
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id:Int): ResponseEntity<Optional<User>>{
        val user = userRepository.findById(id)
        return if (user.isPresent){
            ResponseEntity.ok().body(user)
        }else{
            ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }

    @GetMapping
    fun getAll() = ResponseEntity.ok().body(userRepository.findAll())

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun deleteOne(@PathVariable id: Int){
        userRepository.deleteById(id)
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: Int, @RequestBody newUser: User): ResponseEntity<User>{
        return userRepository.findById(id)
            .map{ user ->
                val novaVersaoDoUser =  newUser.copy(id = user.id, pedido = user.pedido)
                userRepository.save(novaVersaoDoUser)
                ResponseEntity.ok().body(novaVersaoDoUser)
            }.orElse(ResponseEntity(HttpStatus.NOT_FOUND))
    }
}