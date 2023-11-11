package com.sergstas.androidpracticetasks.util

import android.content.Context
import android.widget.Toast
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.RecyclerView

fun Context.colorFromId(id: Int) =
    ResourcesCompat.getColor(resources, id, null)

val RecyclerView.ViewHolder.context: Context
    get() = itemView.context

fun Context.toast(msg: String) =
    Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()