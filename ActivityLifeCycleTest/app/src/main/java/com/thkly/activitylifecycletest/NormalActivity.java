package com.thkly.activitylifecycletest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class NormalActivity extends AppCompatActivity {
    private static final String TAG = "NormalActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal);
        Log.d(TAG, "onCreate: taskId is " + getTaskId());

        Button btnStartMain = (Button) findViewById(R.id.btn_normal_start_main);
        btnStartMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentStartMain = new Intent(NormalActivity.this, MainActivity.class);
                startActivity(intentStartMain);
            }
        });
    }
}
