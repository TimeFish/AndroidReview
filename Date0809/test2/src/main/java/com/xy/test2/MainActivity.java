package com.xy.test2;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView mtv;
    private Handler mHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mtv = (TextView) findViewById(R.id.percent);
        mHandler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                mtv.setText(msg.arg1+"%");
            }
        };
    }

    public void onClick(View view) {
        new Thread(){
            @Override
            public void run() {
                super.run();
                for (int i = 0;i <= 100; i++) {
                    Message message = new Message();
                    message.arg1 = i;
                    mHandler.sendMessage(message);
                    SystemClock.sleep(100);
                }
            }
        }.start();

    }
}
