package com.abdullah996.fullstacktodoapp.todo

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import java.time.LocalDate

@Entity
data class Todo(
    @Id
    @GeneratedValue
    var id: Int = 0,

    var username: String? = null,

    var description: String? = null,
    var targetDate: String? = null,
    var isDone: Boolean = false
){
    override fun toString(): String {
        return ("Todo [id=" + id + ", username=" + username + ", description=" + description + ", targetDate="
                + targetDate + ", done=" + isDone).toString() + "]"
    }
}