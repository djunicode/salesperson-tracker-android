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
import android.view.animation.AnimationUtils;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.material.bottomnavigation.BottomNavigationView;



public class MainActivity extends AppCompatActivity  {


    BottomNavigationView mBottomNavigationView;//Fragment active;

String s1[]={"Dummy title 1","Dummy title 2","Dummy title 3","Dummy title 4","Dummy title 5" };
    String s2[]={"Dummy content 1","Dummy content 2","Dummy content 3","Dummy content 4","Dummy content 5" };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       

        mBottomNavigationView=findViewById(R.id.bottom_navigation);

        mBottomNavigationView.setOnNavigationItemReselectedListener(
                new BottomNavigationView.OnNavigationItemReselectedListener() {
                    @Override
                    public void onNavigationItemReselected(@NonNull MenuItem item) {
                      //  Fragment fragment;
                        switch (item.getItemId()) {
                            case R.id.Location:
                                Fragment location = new LocationFragment();
                                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                                transaction.replace(R.id.frame_layout_main, location);
                                transaction.addToBackStack(null);
                                transaction.commit();
                            case R.id.Checkpoints:
                                Fragment check = new CheckpointsFragment();
                                FragmentTransaction transaction1 = getSupportFragmentManager().beginTransaction();
                                transaction1.replace(R.id.frame_layout_main, check);
                                transaction1.addToBackStack(null);
                                transaction1.commit();
                            case R.id.UpdateTargets:
                                Fragment update = new CheckpointsFragment();
                                FragmentTransaction transaction2 = getSupportFragmentManager().beginTransaction();
                                transaction2.replace(R.id.frame_layout_main, update);
                                transaction2.addToBackStack(null);
                                transaction2.commit();
                        }
                    }
                });



       




}//mainactivity ends here
