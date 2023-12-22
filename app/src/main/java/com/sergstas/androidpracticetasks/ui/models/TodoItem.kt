package com.sergstas.androidpracticetasks.ui.models

sealed class TodoItem(
    open val onClick: (TodoItem) -> Unit,
) {
    data class AddButton(override val onClick: (TodoItem) -> Unit): TodoItem(onClick)

    data class Content(
        val title: String,
        override val onClick: (TodoItem) -> Unit,
    ): TodoItem(onClick)
}