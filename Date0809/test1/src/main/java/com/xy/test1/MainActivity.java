package com.xy.test1;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    Button mbtnSavaInfo,mbtnShowInfo;
    TextView mtvShowInfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }



    private void initView() {
        mbtnSavaInfo = (Button) findViewById(R.id.btn_saveInfo);
        mbtnShowInfo = (Button) findViewById(R.id.btn_showInfo);
        mtvShowInfo = (TextView) findViewById(R.id.tv_show);
    }

    public void savaJsonInfo(View view) {
        AppBean app = new AppBean("鱼塘", 2, "聊天");
        Gson gson = new Gson();
        String appInfo = gson.toJson(app);
        FileOutputStream fos = null;
        try {
            fos = openFileOutput("app.json",MODE_PRIVATE);
            fos.write(appInfo.getBytes());
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showJsonInfo(View view) {

        String str = null;
        try {
            FileInputStream fis = openFileInput("app.json");
            byte[] buffer = new byte[1024];
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            int len = 0;
            while ((len = fis.read(buffer))!=-1){
                baos.write(buffer,0,len);
            }
            str = baos.toString();
            mtvShowInfo.setText(str);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
