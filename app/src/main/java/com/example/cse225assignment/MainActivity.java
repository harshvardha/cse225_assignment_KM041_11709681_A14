package com.example.cse225assignment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_menu);

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigationView);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()){
                    case R.id.nav_call:
                        item.setChecked(true);
                        displayMessage("call option selected");
                        drawerLayout.closeDrawers();
                        return true;

                    case R.id.nav_camera:
                        item.setChecked(true);
                        displayMessage("camera option selected");
                        drawerLayout.closeDrawers();
                        return true;

                    case R.id.nav_email:
                        item.setChecked(true);
                        displayMessage("email option selected");
                        drawerLayout.closeDrawers();
                        return true;

                    case R.id.nav_message:
                        item.setChecked(true);
                        displayMessage("message option selected");
                        drawerLayout.closeDrawers();
                        return true;

                    case R.id.nav_viewPagerActivity:
                        Intent intent = new Intent(MainActivity.this,viewPagerActivity.class);
                        drawerLayout.closeDrawers();
                        startActivity(intent);
                }
                return false;
            }
        });
    }

    private void displayMessage(String message){
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==android.R.id.home){
            drawerLayout.openDrawer(GravityCompat.START);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
