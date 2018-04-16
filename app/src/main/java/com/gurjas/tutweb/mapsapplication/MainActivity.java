package com.gurjas.tutweb.mapsapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {

    static final CameraPosition NEW_YORK = CameraPosition.builder()
            .target(new LatLng(40.784, -73.9857))
            .zoom(14)
            .bearing(0)
            .tilt(45)
            .build();
    static final CameraPosition SEATTLE = CameraPosition.builder()
            .target(new LatLng(47.6204, -122.3491))
            .zoom(14)
            .bearing(0)
            .tilt(45)
            .build();
    static final CameraPosition DUBLIN = CameraPosition.builder()
            .target(new LatLng(53.3478, -6.2597))
            .zoom(14)
            .bearing(0)
            .tilt(45)
            .build();
    boolean mapReady = false;
    GoogleMap googleMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_map_layout);

        Button mapBtn = (Button) findViewById(R.id.map_btn);
        Button satelliteBtn = (Button) findViewById(R.id.satellite_btn);
        Button hybridBtn = (Button) findViewById(R.id.hybrid_btn);

        mapBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                if(mapReady)
//                    googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
//                LatLng faridabadLocation = new LatLng(28.3789565, 77.323915);
//                CameraPosition cameraPosition = CameraPosition.builder().target(faridabadLocation).zoom(14).build();
//                googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition),
//                        8000, null);
                if (mapReady)
                    flyToThisLocation(NEW_YORK);
            }
        });

        satelliteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                if (mapReady)
//                    googleMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
//                LatLng canadaLocation = new LatLng(53.5349552, -113.5921433);
//                CameraPosition cameraPosition = CameraPosition.builder().target(canadaLocation).zoom(14).build();
//                googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition),
//                        8000, null);
                if (mapReady)
                    flyToThisLocation(SEATTLE);
            }
        });

        hybridBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                if (mapReady)
//                    googleMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
//                LatLng tokyoLocation = new LatLng(35.640239, 139.657539);
//                CameraPosition cameraPosition = CameraPosition.builder().target(tokyoLocation).zoom(14).build();
//                googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition),
//                        8000, null);
                if (mapReady)
                    flyToThisLocation(DUBLIN);
            }
        });

        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.new_map);
        mapFragment.getMapAsync(this);
    }

    private void flyToThisLocation(CameraPosition cameraPosition) {
        googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition),
                8000, null);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mapReady = true;
        this.googleMap = googleMap;
        LatLng gurgaonLocation = new LatLng(28.464528, 77.060769);
        CameraPosition cameraPosition = CameraPosition.builder().target(gurgaonLocation).zoom(14).build();
//        this.googleMap.moveCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
//        this.googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
        this.googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition),
                8000, null);
    }
}
