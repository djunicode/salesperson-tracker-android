package io.github.djunicode.salespersontracker;


import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


/**
 * A simple {@link Fragment} subclass.
 */
public class LocationFragment extends Fragment  {
    MapView m;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_location, container, false);

        m = (MapView) v.findViewById(R.id.mapView);

        m.onCreate(savedInstanceState);
        m.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {
                googleMap.addMarker(new MarkerOptions()
                        .position(new LatLng(0,0)).title("place_name")
                        .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN))
                        .draggable(false).visible(true));
                googleMap.addMarker(new MarkerOptions()
                        .position(new LatLng(10,11)).title("place_name")
                        .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN))
                        .draggable(false).visible(true));
                googleMap.addMarker(new MarkerOptions()
                        .position(new LatLng(20,30)).title("place_name")
                        .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN))
                        .draggable(false).visible(true));
            }
        });

        return v;

    }

    public void onResume() {

        super.onResume();

        m.onResume();

    }


    @Override

    public void onPause() {

        super.onPause();

        m.onPause();

    }

    @Override

    public void onDestroy() {

        super.onDestroy();

        m.onDestroy();

    }

    @Override

    public void onLowMemory() {

        super.onLowMemory();

        m.onLowMemory();

    }
}
