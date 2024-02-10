package com.abdullah996.fullstacktodoapp.todo.repository

import com.abdullah996.fullstacktodoapp.todo.Todo
import org.springframework.data.jpa.repository.JpaRepository

interface TodoRepository:JpaRepository<Todo,Int> {

    fun findByUsername(username:String):List<Todo>
}