package com.markoarsenovic.audiodemo;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.SeekBar;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    //defining the global media player
    MediaPlayer mplayer;

    AudioManager audioManager;

    public void playAudio(View view){

        //play audio
        mplayer.start();
    }


    public void pauseAudio(View view){

        //pause audio
        mplayer.pause();  // .stop() for stoping the audio
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //creating the media player on create
        mplayer = MediaPlayer.create(this, R.raw.audio);
        audioManager = (AudioManager)getSystemService(Context.AUDIO_SERVICE); //using it for getting the information about device's volume
        int maxVolume = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC); //max volume of the system
        int currentVolume = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC); //current volume of the system

        SeekBar volumeControl = (SeekBar)findViewById(R.id.seekBar);
        volumeControl.setMax(maxVolume);
        volumeControl.setProgress(currentVolume);

        volumeControl.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                //Log.i("SeekBar value", Integer.toString(progress));
                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, progress, 0);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });



        final SeekBar scrubber = (SeekBar)findViewById(R.id.scrubber);
        scrubber.setMax(mplayer.getDuration()); //length of the audio file

        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                //run this code immediately and run it every second
                scrubber.setProgress(mplayer.getCurrentPosition()); //show current position of audio file, on every second
            }
        },0,1000);

        scrubber.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                Log.i("Scrubber value", Integer.toString(progress));
                //update the current position of the audio file
                mplayer.seekTo(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

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
