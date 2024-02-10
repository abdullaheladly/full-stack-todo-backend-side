package com.abdullah996.fullstacktodoapp.todo

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController


//@RestController
class TodoController constructor(private val todoService: TodoService) {

    @GetMapping("/users/{username}/todos")
    fun retrieveTodos(@PathVariable username:String):List<Todo>{
       return todoService.findByUsername(username)
    }

    @GetMapping("/users/{username}/todos/{id}")
    fun retrieveTodoById(@PathVariable username:String,@PathVariable id:Int):Todo{
        return todoService.findById(id)
    }

    @DeleteMapping("/users/{username}/todos/{id}")
    fun deleteTodoById(@PathVariable username:String,@PathVariable id:Int):ResponseEntity<Unit>{
         todoService.deleteById(id)
        return ResponseEntity.noContent().build()
    }

    @PutMapping("/users/{username}/todos/{id}")
    fun updateTodo(@PathVariable username:String,@PathVariable id:Int,@RequestBody todo: Todo):Todo{
        todoService.updateTodo(todo)
        return todo
    }

    @PostMapping("/users/{username}/todos")
    fun addTodo(@PathVariable username:String,@RequestBody todo: Todo):Todo{
       return todoService.addTodo(username,todo.description,todo.targetDate.toString(),todo.isDone)
    }
}