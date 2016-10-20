package com.markoarsenovic.animations;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    public void fade(View view){

        //BART fading into HOMER
       /*
        ImageView bart = (ImageView) findViewById(R.id.bart);
        //alpha generates the visibility rate -? 0 invisible, 1 completely visible
        bart.animate().alpha(0f).setDuration(2000); //it will fade out in 2s

        ImageView homer = (ImageView) findViewById(R.id.homer);
        homer.animate().alpha(1f).setDuration(2000);
        */

        //BART translates on the bottom of the screen
        /*
        ImageView  bart = (ImageView) findViewById(R.id.bart);
        //translation by the Y axis
        bart.animate().translationYBy(1000f).setDuration(2000);
        */

        //BART translates on the left of the screen
        /*
        ImageView  bart = (ImageView) findViewById(R.id.bart);
        //translation by the X  axis
        bart.animate().translationXBy(-1000f).setDuration(2000);
        */

        /*
        ImageView  bart = (ImageView) findViewById(R.id.bart);
        //translation by the X axis
        bart.animate().translationXBy(1000f).setDuration(2000);
        */
        //ROTATION
        /*
        ImageView  bart = (ImageView) findViewById(R.id.bart);
        //rotation by the N angle
        bart.animate().rotation(180f).setDuration(2000);
        */
        //SHRINKING
        /*
        ImageView bart = (ImageView) findViewById(R.id.bart);
        //rotation by the N angle
        bart.animate().scaleX(0.5f).scaleY(0.5f).setDuration(2000);
        */
        ImageView bart = (ImageView) findViewById(R.id.bart);
        bart.animate()
                .translationXBy(1000f)
                .translationYBy(1000f)
                .rotationBy(3600)
                .setDuration(2000);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //translates the BART Image

       ImageView bart = (ImageView) findViewById(R.id.bart);
       bart.setTranslationX(-1000f);
        bart.setTranslationY(-1000f);

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
