package com.example.lab1;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;

import java.util.Objects;

public class ColoredActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colored);
        Intent intent = getIntent();
        View view = this.getWindow().getDecorView();
        String color = intent.getStringExtra("color");
        if (Objects.equals(color, "red") || Objects.equals(color, "Red")) {
            view.setBackgroundColor(Color.RED);
        } else if (Objects.equals(color, "green") || Objects.equals(color, "Green")) {
            view.setBackgroundColor(Color.GREEN);
        } else {
            view.setBackgroundColor(Color.BLUE);
        }
    }
}
