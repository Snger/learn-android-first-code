package com.thkly.uiwidgetest;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Process;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnClick;
    private EditText inputText;
    private ImageView imageView;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnClick = (Button)findViewById(R.id.btn_main_click);
        btnClick.setOnClickListener(this);

        inputText = (EditText) findViewById(R.id.edit_text_main);
        imageView = (ImageView) findViewById(R.id.img_main);
        progressBar = (ProgressBar) findViewById(R.id.progress_bar_main);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_main_click:
                // show input string
                ShowInputText();
                // change img source
                ChangeImgSource();
                // change progressBar visible
                ChangeProgressBarVisible();
                // change progressBar progress
                ChangeProgress();
                // dialog
//                ShowDialog();
                // Progress Dialog
                ShowProgressDialog();
                break;
            default:
        }
    }

    private void ShowInputText(){
        String inputString = inputText.getText().toString();
        Toast.makeText(MainActivity.this, "You had type: " + inputString,
                Toast.LENGTH_SHORT).show();
    }

    private void ChangeImgSource(){
//        if (imageView.getResources().equals(R.mipmap.ic_launcher)){
            imageView.setImageResource(R.mipmap.ic_launcher_round);
//        } else {
//            imageView.setImageResource(R.mipmap.ic_launcher);
//        }
    }

    private void ChangeProgressBarVisible(){
        if(progressBar.getVisibility() == View.VISIBLE) {
            progressBar.setVisibility(View.GONE);
        } else {
            progressBar.setVisibility(View.VISIBLE);
        }
    }

    private void ChangeProgress(){
        int progress = progressBar.getProgress();
        progress += 10;
        progressBar.setProgress(progress);
    }

    private void ShowDialog(){
        AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
        dialog.setTitle("This is dialog title.");
        dialog.setMessage("This is message.");
        dialog.setCancelable(false);
        dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "OK",
                        Toast.LENGTH_SHORT).show();
            }
        }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "Cancel",
                        Toast.LENGTH_SHORT).show();
            }
        }).show();
    }

    private void ShowProgressDialog(){
        ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setTitle("Title");
        progressDialog.setMessage("Message.");
        progressDialog.setCancelable(true);
        progressDialog.show();
    }
}
