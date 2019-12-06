package com.dreamteamk4240.smtu.ui.contacts;

import android.os.Bundle;

import androidx.fragment.app.FragmentActivity;

import com.dreamteamk4240.smtu.R;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapFragment extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_map);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        LatLng smtuCoord = new LatLng(59.9188905, 30.2760117);
        mMap.addMarker(new MarkerOptions().position(smtuCoord).title("СМТУ"));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(smtuCoord, 16f));
    }
}
