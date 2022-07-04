package com.example.myapplication.Other

import android.graphics.Rect
import android.view.View
import com.google.gson.JsonDeserializer
import kotlin.Throws
import com.google.gson.JsonParseException
import com.google.gson.JsonElement
import com.google.gson.JsonDeserializationContext
import androidx.recyclerview.widget.RecyclerView.ItemDecoration
import androidx.recyclerview.widget.RecyclerView

class VerticalSpacesItemDecoration(private val VerticalSpaceHeight: Int) : ItemDecoration() {
    override fun getItemOffsets(
        outRect: Rect, view: View, parent: RecyclerView,
        state: RecyclerView.State
    ) {
        outRect.top = VerticalSpaceHeight
    }
}