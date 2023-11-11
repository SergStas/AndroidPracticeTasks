package com.sergstas.androidpracticetasks.util

import android.content.Context
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.RecyclerView

fun Context.colorFromId(id: Int) =
    ResourcesCompat.getColor(resources, id, null)

val RecyclerView.ViewHolder.context: Context
    get() = itemView.context