package com.example.less_28;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ColorActivity extends AppCompatActivity implements View.OnClickListener {
    Button bR;
    Button bG;
    Button bB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color);
        bR = findViewById(R.id.button2);
        bR.setOnClickListener(this);
        bG = findViewById(R.id.button4);
        bG.setOnClickListener(this);
        bB = findViewById(R.id.button5);
        bB.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        if(v.equals(bR)) intent.putExtra("color", Color.RED);
        if(v.equals(bG)) intent.putExtra("color", Color.GREEN);
        if(v.equals(bB)) intent.putExtra("color", Color.BLUE);
        setResult(RESULT_OK, intent);
        finish();
    }
}