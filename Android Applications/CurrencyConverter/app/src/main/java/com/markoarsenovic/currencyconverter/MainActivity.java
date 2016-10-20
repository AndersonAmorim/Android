package com.markoarsenovic.currencyconverter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    public void Convert(View view){

        EditText dollarField = (EditText) findViewById(R.id.dollarField);

        Log.i("DOLLAR VALUE", dollarField.getText().toString());

        Double dollarAmount = Double.parseDouble(dollarField.getText().toString());

        Double euroAmount = dollarAmount*0.89;  //we will download this value from internet during the course

        Log.i("EURO VALUE" , euroAmount.toString());

        Toast.makeText(getApplicationContext(), euroAmount.toString() + " e", Toast.LENGTH_LONG).show();



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
