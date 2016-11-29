package com.sds.study.project4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements ViewTreeObserver.OnScrollChangedListener{
    ScrollView piano_scroll,grid_scroll_ver;
    HorizontalScrollView time_scroll,grid_scroll_hor;
    ImageView grid_inner,piano_inner,time_inner;

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        time_scroll=(HorizontalScrollView)findViewById(R.id.time_scroll);
        grid_scroll_hor=(HorizontalScrollView)findViewById(R.id.grid_scroll_hor);
        piano_scroll=(ScrollView)findViewById(R.id.piano_scroll);
        grid_scroll_ver=(ScrollView)findViewById(R.id.grid_scroll_ver);

         grid_inner= (ImageView)findViewById(R.id.grid_inner);
         piano_inner= (ImageView)findViewById(R.id.piano_inner);
         time_inner= (ImageView)findViewById(R.id.time_inner);

        piano_inner.getLayoutParams().height=grid_inner.getHeight();
        time_inner.getLayoutParams().width=grid_inner.getWidth();

        piano_inner.requestLayout();
        time_inner.requestLayout();

        time_scroll.getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() {
            public void onScrollChanged() {
                /*int grid_width=grid_scroll_ver.getWidth();
                int width=grid_inner.getWidth();
                int percent=width/grid_width;*/

                int scrollX = time_scroll.getScrollX(); // For HorizontalScrollView
                grid_scroll_hor.setScrollX(scrollX);
            }
        });

        piano_scroll.getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() {
            public void onScrollChanged() {
                /*int grid_height=grid_scroll_hor.getHeight();
                int height=grid_inner.getHeight();
                int percent=height/grid_height;*/

                int scrollY = piano_scroll.getScrollY(); // For ScrollView
                grid_scroll_ver.setScrollY(scrollY);
            }
        });
    }

    public void onScrollChanged() {

    }
}
