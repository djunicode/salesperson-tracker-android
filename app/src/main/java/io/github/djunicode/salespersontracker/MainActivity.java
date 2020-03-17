package io.github.djunicode.salespersontracker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
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
