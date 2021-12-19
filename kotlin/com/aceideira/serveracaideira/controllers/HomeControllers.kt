package com.aceideira.serveracaideira.controllers

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/")
class HomeControllers {

    @GetMapping
    fun hello():String{
        return "Nossa acaideira"
    }
}