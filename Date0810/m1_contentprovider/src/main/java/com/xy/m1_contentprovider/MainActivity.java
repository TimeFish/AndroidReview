package com.xy.m1_contentprovider;

import android.content.ContentResolver;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int id;
    String name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ContentResolver cr = getContentResolver();
        Cursor c = cr.query(ContactsContract.Contacts.CONTENT_URI, new String[]{ContactsContract.Contacts._ID, ContactsContract.Contacts.DISPLAY_NAME}, null, null, null);
        if (c != null) {
            while (c.moveToNext()) {
                id = c.getInt(c.getColumnIndex(ContactsContract.Contacts._ID));
                name = c.getString(c.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
                Toast.makeText(MainActivity.this, "id:"+id+",name:"+name, Toast.LENGTH_SHORT).show();
                Cursor c1 = cr.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, new String[]{ContactsContract.CommonDataKinds.Phone.NUMBER, ContactsContract.CommonDataKinds.Phone.TYPE}, ContactsContract.CommonDataKinds.Phone.CONTACT_ID+"="+id,null,null);
                if (c1 != null) {
                    while (c1.moveToNext()) {
                        int type = c1.getInt(c1.getColumnIndex(ContactsContract.CommonDataKinds.Phone.TYPE));

                    }
                    c1.close();
                }
            }
            c.close();
        }

    }
}
