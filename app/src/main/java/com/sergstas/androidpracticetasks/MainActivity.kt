package com.sergstas.androidpracticetasks

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sergstas.androidpracticetasks.databinding.ActivityMainBinding
import com.sergstas.androidpracticetasks.nestedrecycler.models.domain.Pet
import com.sergstas.androidpracticetasks.nestedrecycler.models.domain.User
import com.sergstas.androidpracticetasks.nestedrecycler.models.items.UserItem

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setList(binding)
    }

    private fun setList(binding: ActivityMainBinding) {
        val users = getUsers()
        val items = users.map { mapToItem(it) }
        TODO("Not yet implemented")
    }

    private fun mapToItem(user: User) =
        UserItem(
            user = user,
        )

    private fun getUsers() =
        listOf(
            User(
                name = "Pena",
                pets = listOf(
                    Pet("Krolik"),
                    Pet("Bogdan"),
                    Pet("Pojilaya Chinchilopa"),
                ),
            ),
            User(
                name = "Dedushka",
                pets = listOf(
                    Pet("Zyabl"),
                    Pet("Zyabl"),
                    Pet("Zyabl"),
                    Pet("Zyabl"),
                    Pet("Zyabl"),
                    Pet("Zyabl"),
                ),
            ),
            User(
                name = "Upal Namochenyy",
                pets = listOf(),
            ),
        )
}