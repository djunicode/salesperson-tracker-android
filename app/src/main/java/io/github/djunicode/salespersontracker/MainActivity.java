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
<<<<<<< HEAD
import android.view.MenuItem;
import android.widget.Toast;
||||||| 04aa887
=======
import android.view.MenuItem;
import android.view.animation.AnimationUtils;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.material.bottomnavigation.BottomNavigationView;
>>>>>>> 34ad03e00ea5587c5ca20884f9643d718fabb493

<<<<<<< HEAD
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;
||||||| 04aa887
import androidx.appcompat.app.AppCompatActivity;
=======
>>>>>>> 34ad03e00ea5587c5ca20884f9643d718fabb493

<<<<<<< HEAD
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
||||||| 04aa887
public class MainActivity extends AppCompatActivity {
=======
>>>>>>> 34ad03e00ea5587c5ca20884f9643d718fabb493

public class MainActivity extends AppCompatActivity  {


    BottomNavigationView mBottomNavigationView;//Fragment active;

String s1[]={"Dummy title 1","Dummy title 2","Dummy title 3","Dummy title 4","Dummy title 5" };
    String s2[]={"Dummy content 1","Dummy content 2","Dummy content 3","Dummy content 4","Dummy content 5" };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
<<<<<<< HEAD

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

   /*
    void loadFragment(Fragment fragment) {
        //switching fragment
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frame_layout_main, fragment)
                    .commit();

        }
      else {
            Toast.makeText(this,"NULL FRAG",Toast.LENGTH_LONG).toString();
        }
    }
*/
}// main activity ends
||||||| 04aa887
    }
}
=======
       

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
>>>>>>> 34ad03e00ea5587c5ca20884f9643d718fabb493
