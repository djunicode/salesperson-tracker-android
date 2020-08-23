package io.github.djunicode.salespersontracker;


import android.Manifest;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView mBottomNavigationView;
    LocationFragment mLocationFragment;
    CheckpointsFragment mCheckpointsFragment;
    UpdateTargetFragment mUpdateTargetFragment;
    String TAG_FIRST = "first";
    String TAG_SECOND = "second";
    String TAG_THIRD = "third";

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.Location:
                    showLocationFragment();
                    break;
                case R.id.Checkpoints:
                    showCheckpointsFragment();
                    break;
                case R.id.UpdateTargets:
                    showUpdateTargetFragment();
                    break;
            }
            return true;
        }

    };


    // BottomNavigationView mBottomNavigationView;//Fragment active;

    String s1[] = {"Dummy title 1", "Dummy title 2", "Dummy title 3", "Dummy title 4", "Dummy title 5"};
    String s2[] = {"Dummy content 1", "Dummy content 2", "Dummy content 3", "Dummy content 4", "Dummy content 5"};

    static MainActivity instance;
    LocationRequest locationRequest;
    FusedLocationProviderClient fusedLocationProviderClient;

    public static MainActivity getInstance() {
        return instance;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mBottomNavigationView = findViewById(R.id.bottom_navigation);
        mLocationFragment = new LocationFragment();
        mUpdateTargetFragment = new UpdateTargetFragment();
        mCheckpointsFragment = new CheckpointsFragment();
        mBottomNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);


        showLocationFragment();
        instance = this;
        Dexter.withActivity(this).withPermission(Manifest.permission.ACCESS_FINE_LOCATION).withListener(new PermissionListener() {
            @Override
            public void onPermissionGranted(PermissionGrantedResponse response) {
                updateLocation();
            }

            @Override
            public void onPermissionDenied(PermissionDeniedResponse response) {

            }

            @Override
            public void onPermissionRationaleShouldBeShown(PermissionRequest permission, PermissionToken token) {

            }
        }).check();

        // showLocationFragment();
        /*
        //loadFragment(new LocationFragment());

        mBottomNavigationView.setOnNavigationItemReselectedListener(
                new BottomNavigationView.OnNavigationItemReselectedListener() {
                    @Override
                    public void onNavigationItemReselected(@NonNull MenuItem item) {
                        Fragment fragment=null;
                        switch (item.getItemId())
                        {
                            case R.id.Location:
                                fragment=new LocationFragment();
                                loadFragment(fragment);
                                break;
                            case R.id.Checkpoints:
                                fragment=new CheckpointsFragment();
                                loadFragment(fragment);
                                break;
                            case R.id.UpdateTargets:
                                fragment=new UpdateTargetFragment();
                                loadFragment(fragment);
                                break;


                        }
                    }
                });

         */

    }//on create ends


    public void showLocationFragment() {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        if (mLocationFragment.isAdded()) {
            ft.show(mLocationFragment);
        } else {

            ft.add(R.id.frame_layout_main, mLocationFragment, TAG_FIRST);
        }
        if (mCheckpointsFragment.isAdded()) {
            ft.hide(mCheckpointsFragment);
        }
        if (mUpdateTargetFragment.isAdded()) {
            ft.hide(mUpdateTargetFragment);
        }
        ft.commit();
    }

    public void showCheckpointsFragment() {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        if (mCheckpointsFragment.isAdded()) {
            ft.show(mCheckpointsFragment);
        } else {
            ft.add(R.id.frame_layout_main, mCheckpointsFragment, TAG_SECOND);
        }
        if (mLocationFragment.isAdded()) {
            ft.hide(mLocationFragment);
        }
        if (mUpdateTargetFragment.isAdded()) {
            ft.hide(mUpdateTargetFragment);
        }
        ft.commit();


    }

    private void updateLocation() {
        buildLocationRequest();

        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        fusedLocationProviderClient.requestLocationUpdates(locationRequest, getPendingIntent());
    }

    private void buildLocationRequest() {
        locationRequest=new LocationRequest();
        locationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        locationRequest.setInterval(1800*1000);
        locationRequest.setFastestInterval(1500*1000);
        locationRequest.setSmallestDisplacement(10f);

    }




    private PendingIntent getPendingIntent()
    {
        Intent intent =new Intent(this,LocationService.class);
        intent.setAction(LocationService.ACTION_PROCESS_UPDATE);
        return PendingIntent.getBroadcast(this,0,intent,PendingIntent.FLAG_UPDATE_CURRENT);

    }

    public void showUpdateTargetFragment() {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        if (mUpdateTargetFragment.isAdded()) {
            ft.show(mUpdateTargetFragment);
        } else {
            ft.add(R.id.frame_layout_main, mUpdateTargetFragment, TAG_THIRD);
        }
        if (mCheckpointsFragment.isAdded()) {
            ft.hide(mCheckpointsFragment);
        }
        if (mLocationFragment.isAdded()) {
            ft.hide(mLocationFragment);
        }
        ft.commit();
    }


}// main activity ends
