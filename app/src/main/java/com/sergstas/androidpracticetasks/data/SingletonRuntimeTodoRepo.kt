package com.sergstas.androidpracticetasks.data

import com.sergstas.androidpracticetasks.domain.models.Todo
import kotlinx.coroutines.delay

object SingletonRuntimeTodoRepo {
    private val content = mutableListOf<Todo>()

    suspend fun getAll(): List<Todo> {
        delay(1000L)
        return content.toList()
    }

    suspend fun add(item: Todo) =
        content.add(item)

    suspend fun delete(item: Todo) =
        content.remove(item)

    suspend fun rename(item: Todo, newName: String) = content.run {
        val index = indexOf(item).takeIf { it in 0 until size } ?: return@run false
        removeAt(index)
        add(index, item.copy(name = newName))
    }
}