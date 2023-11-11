package com.sergstas.androidpracticetasks.nestedrecycler.vh

import androidx.recyclerview.widget.RecyclerView
import com.sergstas.androidpracticetasks.databinding.ItemUserBinding
import com.sergstas.androidpracticetasks.nestedrecycler.models.items.PetItem
import com.sergstas.androidpracticetasks.nestedrecycler.models.items.UserItem

class UserViewHolder(
    private val binding: ItemUserBinding,
): RecyclerView.ViewHolder(binding.root) {
    fun bind(item: UserItem) {
        binding.run {
            tvName.text = "User: ${item.user.name}"
            tvPet.text = TODO()
            root.setOnClickListener {
                TODO()
            }
            setSubList(item)
        }
    }

    private fun setSubList(item: UserItem) {
        val petItems = item.user.pets.map { PetItem(it) }
        // TODO
    }
}