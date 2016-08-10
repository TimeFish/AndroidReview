package com.xy.date0809;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    private String TABLEMAME = "tb";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SQLiteDatabase db = openOrCreateDatabase("person.db",MODE_PRIVATE,null);
        db.execSQL("create table if not exists tb(_id integer primary key autoincrement,name text not null,age integer not null)");
        ContentValues contentValues = new ContentValues();
        contentValues.put("name","你好");
        contentValues.put("age",15);
        long rowId = db.insert(TABLEMAME, null, contentValues);
        contentValues.clear();
        contentValues.put("name","你好啊");
        contentValues.put("age",18);
        db.insert(TABLEMAME, null, contentValues);
        contentValues.clear();
        contentValues.put("name","好好");
        contentValues.put("age",28);
        db.insert(TABLEMAME, null, contentValues);
        contentValues.clear();
        contentValues.put("name","嘿嘿嘿");
        contentValues.put("age",37);
        db.insert(TABLEMAME, null, contentValues);
        contentValues.put("age",19);
        db.update(TABLEMAME, contentValues, "_id>?", new String[]{"1"});//将全部id>1的年龄变为19
        db.delete(TABLEMAME, "name like?", new String[]{"%啊%"});
        Cursor c = db.query(TABLEMAME, null, "_id>?", new String[]{"0"}, null, null, "name");
        if (c != null) {
            String[] columns = c.getColumnNames();//查询所有字段
            while (c.moveToNext()) {
                for (String columnName : columns) {
                    Log.i("info", c.getString(c.getColumnIndex(columnName)));
                }
            }
            c.close();
        }
        db.close();
    }
}
