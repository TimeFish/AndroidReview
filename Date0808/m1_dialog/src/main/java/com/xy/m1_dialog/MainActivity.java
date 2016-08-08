package com.xy.m1_dialog;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.Toast;

import java.io.DataInput;
import java.util.Calendar;
import java.util.Date;
import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {
    CheckBox mcbA,mcbB,mcbC;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }


    public void onAlertDialog(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("标准对话框")
                .setMessage("This is a message,标准对话框最多有三个按钮")
                .setNeutralButton("忽略",null)
                .setPositiveButton("确定",null)
                .setNegativeButton("取消",null);
        AlertDialog dialog = builder.create();
        dialog.setCancelable(true);
        dialog.setCanceledOnTouchOutside(true);
        dialog.show();
    }

    public void onListDialog(View view) {
        final String[] items = {"a","b","c"};
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("列表对话框")
                .setItems(items,null)
                .setPositiveButton("Ok",null)
                .create().show();
    }

    public void onCustomDialog(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("列表对话框")
                .setView(R.layout.custom_dialog)
                .setPositiveButton("Ok",null)
                .create().show();
    }

    public void onProgressDialog(View view) {
        //进度条对话框不能使用builder模式
        ProgressDialog dialog = new ProgressDialog(this);
        dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        dialog.setMax(150);
        dialog.show();
        //进度值在dialog show之后才会显示
        dialog.setProgress(20);
    }

    public void onProgressDialog2(View view) {
        //ProgressDialog.show 可以初始化设置
        ProgressDialog dialog =  ProgressDialog.show(this, "title", "message");
        dialog.setCancelable(true);
        dialog.setCanceledOnTouchOutside(true);
    }

    public void onDateDialog(View view) {
        Calendar calendar = Calendar.getInstance();
        DatePickerDialog dialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {

            }
        }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
        dialog.show();
    }

    public void onRadioDialog(View view) {
        final String[] items = {"上海", "北京", "纽约"};
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("选择你喜欢的城市")
                .setSingleChoiceItems(items, 1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, items[i], Toast.LENGTH_SHORT).show();
                    }
                })
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                }).create().show();
    }

    public void onCheckboxDialog(View view) {
        final String[] items = {"上海", "北京", "纽约"};
        boolean[] initChecked = {true, false, false};
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("选择你喜欢的城市")
                .setMultiChoiceItems(items, initChecked, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i, boolean b) {

                    }
                })
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                }).create().show();
    }
}
