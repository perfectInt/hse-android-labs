package com.example.lab1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Objects;

public class MainActivity extends Activity {

    ArrayList<String> availableColors = new ArrayList<>();

    private void init() {
        availableColors.add("red");
        availableColors.add("green");
        availableColors.add("blue");
    }

    Button button;
    EditText editText;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        button = findViewById(R.id.button);
        editText = findViewById(R.id.editText);
        button.setOnClickListener(view -> {
            String color = String.valueOf(editText.getText()).toLowerCase();
            Log.d("Getting color", color);
            if (availableColors.stream().noneMatch(e -> Objects.equals(e, color))) {
                Toast.makeText(MainActivity.this, "Can't get your color", Toast.LENGTH_LONG).show();
            } else {
                Intent intent = new Intent(MainActivity.this, ColoredActivity.class);
                intent.putExtra("color", color);
                startActivity(intent);
            }
        });
    }
}
