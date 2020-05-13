package io.github.djunicode.salespersontracker;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;

import android.Manifest;
import android.app.PendingIntent;
import android.content.Intent;

import android.os.Bundle;


import android.view.MenuItem;
import android.widget.Toast;

import android.view.MenuItem;
import android.view.animation.AnimationUtils;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;


import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;


import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView mBottomNavigationView;
    LocationFragment mLocationFragment;
    CheckpointsFragment mCheckpointsFragment;
    UpdateTargetFragment mUpdateTargetFragment;
    String TAG_FIRST="first";
    String TAG_SECOND="second";
    String TAG_THIRD="third";

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

String s1[]={"Dummy title 1","Dummy title 2","Dummy title 3","Dummy title 4","Dummy title 5" };
    String s2[]={"Dummy content 1","Dummy content 2","Dummy content 3","Dummy content 4","Dummy content 5" };

    static MainActivity instance;
    LocationRequest locationRequest;
    FusedLocationProviderClient fusedLocationProviderClient;
    public static MainActivity getInstance()
    {
        return instance;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        mBottomNavigationView=findViewById(R.id.bottom_navigation);
        mLocationFragment=new LocationFragment();
        mUpdateTargetFragment=new UpdateTargetFragment();
        mCheckpointsFragment=new CheckpointsFragment();
        mBottomNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);


        showLocationFragment();


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

        instance=this;
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
    }

    private void updateLocation() {
        buildLocationRequest();

        fusedLocationProviderClient= LocationServices.getFusedLocationProviderClient(this);
        fusedLocationProviderClient.requestLocationUpdates(locationRequest,getPendingIntent());
    }

    private void buildLocationRequest() {
        locationRequest=new LocationRequest();
        locationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        locationRequest.setInterval(5000);
        locationRequest.setFastestInterval(3000);
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
