package com.markoarsenovic.locationdemo;

import android.app.Activity;
import android.content.Context;
import android.location.Address;
import android.location.Criteria;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class MainActivity extends Activity implements LocationListener {

    LocationManager locationManager;
    String provider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        provider = locationManager.getBestProvider(new Criteria(), false); //if set to true -> returns only the available providers, you can set custom criteria for choosing the provider


        Location location = locationManager.getLastKnownLocation(provider); //YOU MUST ADD PERMISSION FOR FINE OR COURSE (less accurate) LOCATION

        if(location !=null){
            Log.i("LOCATION INFO", location.getLatitude() + "," + location.getLongitude());
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


    @Override
    protected void onResume() {
        super.onResume();

        //onResume happens when the app was put in the background and it is reactivated again
        locationManager.requestLocationUpdates(provider, 400, 1, this);
    }

    @Override
    protected void onPause() {
        super.onPause();

        locationManager.removeUpdates(this);
    }

    //LOCATION LISTENERS METHODS
    @Override
    public void onLocationChanged(Location location) {

        Double lat = location.getLatitude();
        Double lng = location.getLongitude();
        Log.i("Latitude", lat.toString());
        Log.i("Longitude", lng.toString());
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }


    public void getLocation(View view) throws IOException {
        Location location = locationManager.getLastKnownLocation(provider);
        Double lat = location.getLatitude();
        Double lng = location.getLongitude();

        Geocoder geocoder = new Geocoder(getApplicationContext(), Locale.getDefault());

        try {
            List<Address> listAddresses = geocoder.getFromLocation(lat,lng,1);
            if (listAddresses != null){
                Log.i("PlaceInfo", listAddresses.get(0).toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        Toast.makeText(getApplicationContext(), "LATITUDE: "+ lat.toString()+ "\n"+ "LONGITUDE: "+ lng.toString(),Toast.LENGTH_LONG).show();

    }
}
