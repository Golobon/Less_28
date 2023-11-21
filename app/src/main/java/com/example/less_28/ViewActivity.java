package com.example.less_28;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ViewActivity extends AppCompatActivity implements View.OnClickListener {
    EditText eT;
    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        eT = findViewById(R.id.editText);
        b = findViewById(R.id.button2);
        b.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        intent.putExtra("name", eT.getText().toString());
        setResult(RESULT_OK, intent);
        finish();
    }
}