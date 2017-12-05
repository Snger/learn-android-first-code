package com.toushou.activitytest;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by toushou on 04/12/2017.
 */

public class FirstActivity extends BaseActivity {
    private final String TAG = "FirstActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_ACTION_BAR);
        setContentView(R.layout.first_layout);
        Log.d(TAG, "onCreate: end");
        ShowAllActivity();

        Button button1 = (Button) findViewById(R.id.button_1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(FirstActivity.this, "You clicked Button 1, and will finish",
//                        Toast.LENGTH_SHORT).show();
//                finish();
                // 显示 Intent
                Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
                String data = "Hello, this data from first activity.";
                intent.putExtra("string_extra", data);
                startActivity(intent);
                // 隐式 Intent
//                Intent intent2 = new Intent();
//                intent2.setAction("com.toushou.activitytest.SIM");
//                intent2.addCategory("com.toushou.activitytest.SIM");
//                startActivity(intent2);
                // 打开浏览器网页
//                Intent intent3 = new Intent(Intent.ACTION_VIEW);
//                intent3.setData(Uri.parse("http://z.cn"));
//                startActivity(intent3);
                // 打开电话
//                Intent intent4 = new Intent(Intent.ACTION_VIEW);
//                intent4.setData(Uri.parse("tel:10086"));
//                startActivity(intent4);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.add_item:
                Toast.makeText(this, "You click Add", Toast.LENGTH_SHORT).show();
                break;
            case R.id.remove_item:
                Toast.makeText(this, "You click Remove", Toast.LENGTH_LONG).show();
                break;
            default:
        }
        return true;
    }
}
