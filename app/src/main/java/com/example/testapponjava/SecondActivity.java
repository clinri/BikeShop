package com.example.testapponjava;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }

    public void changeTvHello(View view) {
        TextView textView = findViewById(R.id.tvHello);
        textView.setText("Hello Java!");
        textView.setBackgroundColor(Color.YELLOW);
        textView.setTextSize(30);

    }
}