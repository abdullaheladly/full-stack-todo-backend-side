package com.abdullah996.fullstacktodoapp.helloWord

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController


@RestController
class HelloWorldController {

    @GetMapping(path = ["/basicauth"])
    fun basicAuthCheck(): String {
        return "Hello World"
    }
    @GetMapping(path = ["/hello-world"])
    fun helloWorld(): String {
        return "Hello World"
    }

    @GetMapping(path = ["/hello-world-bean"])
    fun helloWorldBean(): HelloWorldBean {
        return HelloWorldBean("Hello World")
    }

    @GetMapping(path = ["/hello-world/path-variable/{name}"])
    fun helloWorldPathVariable(@PathVariable name: String?): HelloWorldBean {
        return HelloWorldBean(String.format("Hello World, %s", name))
    }
}