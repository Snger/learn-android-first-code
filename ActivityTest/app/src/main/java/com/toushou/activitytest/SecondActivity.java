package com.toushou.activitytest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by toushou on 04/12/2017.
 */

public class SecondActivity extends Activity {
    private static final String TAG = "SecondActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.secound_layout);
        Log.d(TAG, "Second Activity start.");
        Intent intent = getIntent();
        String data = intent.getStringExtra("string_extra");
        Log.d(TAG, data);

        Button button2 = findViewById(R.id.button_2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(SecondActivity.this, "Click Button 2",
                        Toast.LENGTH_SHORT).show();
                Intent intent1 = new Intent(SecondActivity.this, ThirdActivity.class);
                intent1.putExtra("from_second", "Hello, this msg from second activity.");
                startActivityForResult(intent1, 1);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode){
            case 1:
                if(resultCode == RESULT_OK){
                    String resultData = data.getStringExtra("from_third");
                    Log.d(TAG, "onActivityResult: data is - " + resultData);
                }
                break;
            default:
        }
    }

}
