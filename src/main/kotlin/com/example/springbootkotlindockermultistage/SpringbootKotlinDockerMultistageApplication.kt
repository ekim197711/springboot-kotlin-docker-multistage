package com.example.springbootkotlindockermultistage

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
open class SpringbootKotlinDockerMultistageApplication

fun main(args: Array<String>) {
    runApplication<SpringbootKotlinDockerMultistageApplication>(*args)
}

@RestController
@RequestMapping("/api")
class SpaceShipRestController{

    @GetMapping("/destination")
    fun destination(): String{
        return "First the moon then Mars"
    }
}
