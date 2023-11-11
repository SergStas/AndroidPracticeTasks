package com.sergstas.androidpracticetasks.nestedrecycler.vh

import androidx.recyclerview.widget.RecyclerView
import com.sergstas.androidpracticetasks.R
import com.sergstas.androidpracticetasks.databinding.ItemPetBinding
import com.sergstas.androidpracticetasks.nestedrecycler.models.items.PetItem
import com.sergstas.androidpracticetasks.util.colorFromId
import com.sergstas.androidpracticetasks.util.context

class PetViewHolder(
    private val binding: ItemPetBinding,
): RecyclerView.ViewHolder(binding.root) {
    fun bind(item: PetItem) {
        binding.run {
            tvName.text = item.pet.name
            setItemSelection(isSelected = TODO())
            root.setOnClickListener {
                TODO()
            }
        }
    }

    private fun setItemSelection(isSelected: Boolean) =
        binding.flBorders.setBackgroundColor(
            context.colorFromId(
                if (isSelected) R.color.color_selected_green
                else R.color.black,
            ),
        )
}