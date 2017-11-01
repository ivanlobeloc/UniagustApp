package com.tecnologias.uniagustapp.fragmentos;


import android.os.Bundle;
import android.support.annotation.Nullable;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.tecnologias.uniagustapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_Rutas extends Fragment implements OnMapReadyCallback {

    public Fragment_Rutas() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_rutas, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        SupportMapFragment mapFragment = (SupportMapFragment) getActivity().getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        //SupportMapFragment mapFragment2 = (SupportMapFragment) getActivity().getSupportFragmentManager().findFragmentById(R.id.map);
        //mapFragment2.getMapAsync((OnMapReadyCallback) getActivity());

        //MapFragment fragment = (MapFragment)getChildFragmentManager().findFragmentById(R.id.map);
        //fragment.getMapAsync(this);
    }

    @Override//acercamiento
    public void onMapReady(GoogleMap googleMap) {
        LatLng bogota = new LatLng(4.653421, -74.145150);
        googleMap.addMarker(new MarkerOptions().position(bogota)
                .title("Uniagustiniana"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(bogota, 16.1f));
    }
}
