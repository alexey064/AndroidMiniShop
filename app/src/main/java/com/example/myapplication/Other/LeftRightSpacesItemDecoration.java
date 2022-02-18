package com.example.myapplication.Other;
import android.graphics.Rect;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;
public class LeftRightSpacesItemDecoration extends RecyclerView.ItemDecoration {
    private final int HorizontalSpaceHeight;
    public LeftRightSpacesItemDecoration(int SpaceLenght) {
        this.HorizontalSpaceHeight = SpaceLenght;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent,
                               RecyclerView.State state) {
        outRect.left = HorizontalSpaceHeight;
    }
}