package com.xy.test;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.SystemClock;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int checkMood;
    ProgressBar mprebar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mprebar = (ProgressBar) findViewById(R.id.prebar);
    }

    public void onClickRadio(View view) {
        final String[] items = {"开心", "真开心", "开心炸了"};

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("今天你开心吗")
                .setSingleChoiceItems(items, 1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        checkMood = i;
                    }
                })
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, items[checkMood], Toast.LENGTH_SHORT).show();
                    }
                })
                .create().show();
    }

    public void onClickProgress(View view) {
        new Thread(){
            @Override
            public void run() {
                super.run();
                for (int i = 0; i <= 100; i++){
                    mprebar.setProgress(i);
                    SystemClock.sleep(100);
                }
            }
        }.start();
    }
}
