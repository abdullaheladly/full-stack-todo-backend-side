package com.abdullah996.fullstacktodoapp.todo

import org.springframework.stereotype.Service
import java.time.LocalDate
import java.util.function.Predicate


@Service
class TodoService {
    fun findByUsername(username: String?): List<Todo> {
        val predicate: Predicate<in Todo> =
            Predicate { todo: Todo ->
                todo.username.equals(
                    username,
                    ignoreCase = true
                )
            }
        return todos.stream().filter(predicate).toList()
    }

    fun addTodo(username: String?, description: String?, targetDate: String?, done: Boolean): Todo {
        val todo = Todo(++todosCount, username, description, targetDate.toString(), done)
        todos.add(todo)
        return todo
    }

    fun deleteById(id: Int) {
        val predicate: Predicate<in Todo> =
            Predicate { todo: Todo -> todo.id == id }
        todos.removeIf(predicate)
    }

    fun findById(id: Int): Todo {
        val predicate: Predicate<in Todo> =
            Predicate { todo: Todo -> todo.id == id }
        val todo = todos.stream().filter(predicate).findFirst().get()
        return todo
    }

    fun updateTodo(todo: Todo) {
        deleteById(todo.id)
        todos.add(todo)
    }

    companion object {
        private val todos: MutableList<Todo> = ArrayList()

        private var todosCount = 0

        init {
            todos.add(
                Todo(
                    ++todosCount, "abdullah", "Get AWS Certified",
                    LocalDate.now().plusYears(10).toString(), false
                )
            )
            todos.add(
                Todo(
                    ++todosCount, "abdullah", "Learn DevOps",
                    LocalDate.now().plusYears(11).toString(), false
                )
            )
            todos.add(
                Todo(
                    ++todosCount, "abdullah", "Learn Full Stack Development",
                    LocalDate.now().plusYears(12).toString(), false
                )
            )
        }
    }
}