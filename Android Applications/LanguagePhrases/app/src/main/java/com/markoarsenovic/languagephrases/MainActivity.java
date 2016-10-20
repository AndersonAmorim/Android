package com.markoarsenovic.languagephrases;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {


    public void  buttonTapped(View view){

        int id = view.getId();
        String ourId = "";

        ourId = view.getResources().getResourceEntryName(id);

        Log.i("button tapped", Integer.toString(view.getId()));
        Log.i("button tapped", ourId);
        System.out.println(getPackageName());
        int resourceId = getResources().getIdentifier(ourId, "raw", "com.markoarsenovic.languagephrases");
        MediaPlayer mediaPlayer = MediaPlayer.create(this, resourceId); //we cannot hardcode it, ex. R.raw.doyouspeakenglish
        mediaPlayer.start();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
