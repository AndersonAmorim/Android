package com.markoarsenovic.listviewdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import static java.util.Arrays.asList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //listview
        ListView listView = (ListView) findViewById(R.id.listView);

      /*
        final ArrayList<String> myFamily = new ArrayList<String>();
        myFamily.add("Pera");
        myFamily.add("Marica");
        myFamily.add("Milan");
        myFamily.add("Ljilja");
        myFamily.add("Milos");
    */
        final ArrayList<String> myFamily = new ArrayList<String>(asList("Pera","Marica","Milan","Ljilja","Milos"));


        //ArrayAdapter, converting ArrayList in style to be adopted to the ListView
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1  ,myFamily);

        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                // parent reerence to listView in this example, ex. parent.setVisibility(View.GONE);
                //view is a raw cliked in listview
                //position is a position of a raw

                Log.i("Person tapped", myFamily.get(position));
                Toast.makeText(getApplicationContext(), "Hello " + myFamily.get(position).toString(),Toast.LENGTH_LONG).show();
            }
        });
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
