package com.abdullah996.fullstacktodoapp.todo

import com.abdullah996.fullstacktodoapp.todo.repository.TodoRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController


@RestController
class TodoJpaController constructor(private val todoRepository: TodoRepository) {

    @GetMapping("/users/{username}/todos")
    fun retrieveTodos(@PathVariable username:String):List<Todo>{
       return todoRepository.findByUsername(username)
    }

    @GetMapping("/users/{username}/todos/{id}")
    fun retrieveTodoById(@PathVariable username:String,@PathVariable id:Int):Todo{
        return todoRepository.findById(id).get()
    }

    @DeleteMapping("/users/{username}/todos/{id}")
    fun deleteTodoById(@PathVariable username:String,@PathVariable id:Int):ResponseEntity<Unit>{
         todoRepository.deleteById(id)
        return ResponseEntity.noContent().build()
    }

    @PutMapping("/users/{username}/todos/{id}")
    fun updateTodo(@PathVariable username:String,@PathVariable id:Int,@RequestBody todo: Todo):Todo{
        todoRepository.save(todo)
        return todo
    }

    @PostMapping("/users/{username}/todos")
    fun addTodo(@PathVariable username:String,@RequestBody todo: Todo):Todo{

        val newTodo=Todo(username = username, description =todo.description, targetDate = todo.targetDate, isDone = todo.isDone)
       return todoRepository.save(newTodo)
    }
}