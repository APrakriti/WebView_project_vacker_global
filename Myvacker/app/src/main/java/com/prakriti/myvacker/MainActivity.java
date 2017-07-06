package com.prakriti.myvacker;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;

import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    ListView listView;
    ArrayAdapter<String> adapter;
    EditText editText;
    CarouselView carouselview;
    int[] images = {R.drawable.wifi_temperature_monitoring, R.drawable.measuring_instrument,R.drawable.datalogger, R.drawable.motion_sensors, R.drawable.dehumidifiers,R.drawable.humidifier,R.drawable.datalogger};


    String[] website_names = {"www.vackerglobal.com", "www.dehumidifier-uae.ae", "www.vackergroup.ae",
            "www.sensorsuae.com", "www.temperaturemonitoringuae.com"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setLogo(R.drawable.picvg);
        setSupportActionBar(toolbar);

        editText = (EditText) findViewById(R.id.inputSearch);
        // editText.setHintTextColor(getResources().getColor(R.color.secondary_text));






        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                MainActivity.this.adapter.getFilter().filter(s);

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        listView = (ListView) findViewById(R.id.websitelist);

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, website_names);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                switch (position){

                    case 0:
                        Intent gs = new Intent(MainActivity.this,Website.class);

                        //ADD THIS LINE
                        gs.putExtra("URL", "https://www.vackerglobal.com/");

                        startActivity(gs);
                        break;
                    case 1:
                        Intent gs1 = new Intent(MainActivity.this,Website.class);

                        gs1.putExtra("URL", "https://www.dehumidifier-uae.ae/");

                        startActivity(gs1);
                        break;

                    case 2:
                        Intent gs2 = new Intent(MainActivity.this,Website.class);


                        gs2.putExtra("URL", "https://www.vackergroup.ae/en/");

                        startActivity(gs2);
                        break;
                    case 3:
                        Intent gs3 = new Intent(MainActivity.this,Website.class);


                        gs3.putExtra("URL", "https://www.sensorsuae.com/");

                        startActivity(gs3);
                        break;
                    case 4:
                        Intent gs4 = new Intent(MainActivity.this,Website.class);


                        gs4.putExtra("URL", "https://www.temperaturemonitoringuae.com/");

                        startActivity(gs4);
                        break;
                    case 5:
                        System.exit(0);
                        break;
                }


            }
        });
        carouselview = (CarouselView) findViewById(R.id.carouselview);
        carouselview.setPageCount(images.length);
        carouselview.setImageListener(imagelistener);






        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    ImageListener imagelistener = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {
            imageView.setImageResource(images[position]);
        }
    };

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
     //   if (id == R.id.action_settings) {
            return true;
        }

       // return super.onOptionsItemSelected(item);


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_call) {
            Intent callIntent = new Intent(Intent.ACTION_CALL);
            callIntent.setData(Uri.parse("tel:+97142661144"));
            if (ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                return true;
            }
            startActivity(callIntent);


        } else if (id == R.id.nav_email) {

            Intent intent = new Intent(Intent.ACTION_SENDTO); // it's not ACTION_SEND
            intent.setType("text/plain");
            intent.putExtra(Intent.EXTRA_SUBJECT, "Subject of email");
            intent.putExtra(Intent.EXTRA_TEXT, "Body of email");
            intent.setData(Uri.parse("mailto:sales.uae@gmail.com")); // or just "mailto:" for blank
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK); // this will make such that when user returns to your app, your app is displayed, instead of the email app.
            startActivity(intent);

        } else if (id == R.id.nav_fb) {
            Intent i = new Intent(MainActivity.this, Facebook.class);
            startActivity(i);
        } else if (id == R.id.nav_about_us) {
            Intent i = new Intent(MainActivity.this, AboutUs.class);
            startActivity(i);




        } else if (id == R.id.nav_linkedin) {
            Intent i = new Intent(MainActivity.this, Linkedin.class);
            startActivity(i);
        }
        else if (id == R.id.nav_locateus) {
            Intent i = new Intent(MainActivity.this, MapsActivity.class);
            startActivity(i);


        }
        else if (id == R.id.nav_twit) {
        Intent i = new Intent(MainActivity.this, Twitter.class);
        startActivity(i);
     }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
