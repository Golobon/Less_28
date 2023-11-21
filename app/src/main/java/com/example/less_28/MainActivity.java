package com.example.less_28;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView tV;
    Button b;
    ActivityResultLauncher<Intent> aRL;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        aRL = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult activityResult) {
                        int result = activityResult.getResultCode();
                        Intent data = activityResult.getData();
                        if (result == RESULT_OK) {
                            String res = data.getStringExtra("name");
                            tV.setText("Ты ввел имя: " + res);
                        } else tV.setText("Ты нихрена не ввел");
                    }
                });

        tV = findViewById(R.id.textView);
        b = findViewById(R.id.button);
        b.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, ViewActivity.class);
        aRL.launch(intent);
//        startActivityForResult(intent, 1);
    }
//
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if (data == null) return;
//        String res = data.getStringExtra("name");
//        tV.setText("Ты ввел имя: " + res);
//    }
}