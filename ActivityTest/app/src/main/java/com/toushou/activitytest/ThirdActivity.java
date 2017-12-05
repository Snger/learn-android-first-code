package com.toushou.activitytest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by toushou on 04/12/2017.
 */

public class ThirdActivity extends Activity {

    private static final String TAG = "ThirdActivity";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third_layout);
        Intent intent = getIntent();
        String data = intent.getStringExtra("from_second");
        Log.d(TAG, "onCreate: data = " + data);

        Button button3 = findViewById(R.id.button_3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ThirdActivity.this, "Clicked Button 3",
                        Toast.LENGTH_SHORT).show();
                returnResult();
            }
        });
    }

    public void returnResult(){
        Intent returnResultIntent = new Intent();
        returnResultIntent.putExtra("from_third", "Hello, this msg from third activity.");
        setResult(RESULT_OK, returnResultIntent);
        finish();
    }

    @Override
    public void onBackPressed() {
        returnResult();
    }
}
