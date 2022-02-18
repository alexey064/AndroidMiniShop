package com.example.myapplication.Other;

import android.graphics.Rect;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

public class VerticalSpacesItemDecoration extends RecyclerView.ItemDecoration {

    private final int VerticalSpaceHeight;

    public VerticalSpacesItemDecoration(int SpaceLenght) {
        this.VerticalSpaceHeight = SpaceLenght;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent,
                               RecyclerView.State state) {
        outRect.top = VerticalSpaceHeight;
    }
}
