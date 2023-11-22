package com.example.less_28;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView tV;
    Button bC;
    Button bR;
    ActivityResultLauncher<Intent> aRLColAlig;
    final static int COLOR = 111;
    final static int ALIGMENT = 222;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        aRLColAlig = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult activityResult) {
                        int result = activityResult.getResultCode();
                        Intent data = activityResult.getData();
                        System.out.println(activityResult);
                        if (result == COLOR) {
                            int color = data.getIntExtra("color", 0);
                            tV.setTextColor(color);
                        } else if (result == ALIGMENT) {
                            int gravity = data.getIntExtra("aligment", 0);
                            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(tV.getLayoutParams());
                            layoutParams.gravity = gravity;
                            tV.setLayoutParams(layoutParams);
                            tV.setGravity(gravity);
                        } else tV.setText("Ты нихрена не ввел");
                    }
                });

        tV = findViewById(R.id.textView);
        bC = findViewById(R.id.button);
        bC.setOnClickListener(this);
        bR = findViewById(R.id.button3);
        bR.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        if (v.equals(bC)) {
            intent = new Intent(this, ColorActivity.class);
            aRLColAlig.launch(intent);
        } else if (v.equals(bR)) {
            intent = new Intent(this, AligmentActivity.class);
            aRLColAlig.launch(intent);
        }
    }
}