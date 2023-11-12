package com.sergstas.androidpracticetasks.models

data class UserStatus(
    val username: String,
    val status: Status,
) {
    enum class Status {
        Online, Offline;
    }
}
