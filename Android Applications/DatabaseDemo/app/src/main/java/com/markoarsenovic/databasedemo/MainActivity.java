package com.markoarsenovic.databasedemo;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try{

            SQLiteDatabase demoDatabase = this.openOrCreateDatabase("tblUsers", MODE_PRIVATE, null);

            demoDatabase.execSQL("CREATE TABLE IF NOT EXISTS tblUsers (name VARCHAR, age INTEGER(3), id INTEGER PRIMARY KEY)"); //auto increment primary key

            demoDatabase.execSQL("INSERT INTO tblUsers (name, age) VALUES ('Petar', 34)");

            demoDatabase.execSQL("INSERT INTO tblUsers (name, age) VALUES ('Marica', 27)");

            demoDatabase.execSQL("INSERT INTO tblUsers (name, age) VALUES ('Milan', 17)");

            demoDatabase.execSQL("INSERT INTO tblUsers (name, age) VALUES ('Milos', 12)");

            demoDatabase.execSQL("UPDATE tblUsers SET age = '20' WHERE name = 'Milan'");

            demoDatabase.execSQL("DELETE FROM tblUsers WHERE name = 'Milan'");



            Cursor c = demoDatabase.rawQuery("SELECT * FROM tblUsers WHERE age < 30",null);

            int nameIndex = c.getColumnIndex("name");
            int ageIndex = c.getColumnIndex("age");

            int idIndex = c.getColumnIndex("id");

            c.moveToFirst();

            while(c!=null){

                Log.i("NAME", c.getString(nameIndex));
                Log.i("AGE", Integer.toString(c.getInt(ageIndex)));
                Log.i("PK", Integer.toString(c.getInt(idIndex)));

                c.moveToNext();
            }


        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
