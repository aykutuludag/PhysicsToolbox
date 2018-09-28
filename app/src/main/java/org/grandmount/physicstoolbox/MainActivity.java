package org.grandmount.physicstoolbox;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.Window;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    Window window;
    Toolbar toolbar;
    BottomNavigationView navigation;
    boolean doubleBackToExitPressedOnce;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Window
        window = this.getWindow();

        // Initializing Toolbar and setting it as the actionbar
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowTitleEnabled(false);
            getSupportActionBar().setLogo(R.drawable.brand_logo);
        }

        navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.navigation_speed:
                Fragment fragment = new FragmentSpeed();
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, fragment, "Speed").commit();
                return true;
            case R.id.navigation_light:
                Fragment fragment2 = new FragmentLight();
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, fragment2, "Light").commit();
                return true;
            case R.id.navigation_gravity:
                Fragment fragment3 = new FragmentGravity();
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, fragment3, "Gravity").commit();
                return true;
            case R.id.navigation_magnetic:
                Fragment fragment4 = new FragmentMagnetic();
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, fragment4, "Magnetic").commit();
                return true;
            case R.id.navigation_pressure:
                Fragment fragment5 = new FragmentPressure();
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, fragment5, "Pressure").commit();
                return true;
        }
        return false;
    }

    @Override
    public void onBackPressed() {
        // Fragments
        FragmentSpeed fragment0 = (FragmentSpeed) getSupportFragmentManager().findFragmentByTag("Speed");
        FragmentLight fragment1 = (FragmentLight) getSupportFragmentManager().findFragmentByTag("Light");
        FragmentGravity fragment2 = (FragmentGravity) getSupportFragmentManager().findFragmentByTag("Gravity");
        FragmentMagnetic fragment3 = (FragmentMagnetic) getSupportFragmentManager().findFragmentByTag("Magnetic");
        FragmentPressure fragment4 = (FragmentPressure) getSupportFragmentManager().findFragmentByTag("Pressure");

        // FragmentSpeed OnBackPressed
        if (fragment0 != null) {
            if (fragment0.isVisible()) {
                if (doubleBackToExitPressedOnce) {
                    super.onBackPressed();
                    return;
                }

                this.doubleBackToExitPressedOnce = true;
                Toast.makeText(this, getString(R.string.exit), Toast.LENGTH_SHORT).show();

                new Handler().postDelayed(new Runnable() {

                    @Override
                    public void run() {
                        doubleBackToExitPressedOnce = false;
                    }
                }, 2000);
            }
        }

        // FragmentLight OnBackPressed
        if (fragment1 != null) {
            if (fragment1.isVisible()) {
                goBack();
            }
        }

        // FragmentGravity OnBackPressed
        if (fragment2 != null) {
            if (fragment2.isVisible()) {
                goBack();
            }
        }

        // FragmentMagnetic OnBackPressed
        if (fragment3 != null) {
            if (fragment3.isVisible()) {
                goBack();
            }
        }

        // FragmentPressure OnBackPressed
        if (fragment4 != null) {
            if (fragment4.isVisible()) {
                goBack();
            }
        }

    }

    private void goBack() {
        Fragment fragment = new FragmentSpeed();
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, fragment, "Speed").commit();
        navigation.setSelectedItemId(R.id.navigation_speed);

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, getString(R.string.exit), Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce = false;
            }
        }, 2000);
    }
}