package com.example.callbank.map;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.callbank.R;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class Map1 extends AppCompatActivity implements OnMapReadyCallback, ActivityCompat.OnRequestPermissionsResultCallback {

    private GoogleMap mapView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map1);

        // 화면전환
        Button mapbutton = (Button) findViewById(R.id.mapbutton);
        mapbutton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Map1.class);
                startActivity(intent);
            }
        });

        Button listbutton = (Button) findViewById(R.id.listbutton);
        listbutton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MapListView.class);
                startActivity(intent);
            }
        });

        //여기까지

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.mapView);
        mapFragment.getMapAsync(Map1.this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        this.mapView = googleMap;

        // NH농협은행 위도 경도 좌표 넣기
        LatLng daegu = new LatLng(35.8823, 128.643);
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(daegu));
        googleMap.moveCamera(CameraUpdateFactory.zoomTo(15));
        MarkerOptions options = new MarkerOptions();
        options.position(daegu)
                .title("NH농협은행")
                .snippet("효목시장지점");
        mapView.addMarker(options);

        daegu = new LatLng(35.898,128.6394);
        options.position(daegu)
                .title("NH농협은행")
                .snippet("동촌 공항지점");
        mapView.addMarker(options);

        // 대구은행 위도 경도 좌표 넣기
        daegu = new LatLng(35.8702,128.7299);
        options.position(daegu)
                .title("대구은행")
                .snippet("반야월지점");
        mapView.addMarker(options);

        daegu = new LatLng(35.8699,128.711);
        options.position(daegu)
                .title("대구은행")
                .snippet("안심지점");
        mapView.addMarker(options);

        // 우리은행 위도 경도 좌표 넣기
        daegu = new LatLng(35.8675,128.7244);
        options.position(daegu)
                .title("우리은행")
                .snippet("반야월지점");
        mapView.addMarker(options);

        // 신협 위도 경도 좌표 넣기
        daegu = new LatLng(35.898,128.6394);
        options.position(daegu)
                .title("신협")
                .snippet("방촌 동호지점점");
        mapView.addMarker(options);

        //새마을금고 위도 경도 좌표 넣기
        daegu = new LatLng(35.8381,128.7112);
        options.position(daegu)
                .title("새마을금고")
                .snippet("수성중앙지점");
        mapView.addMarker(options);

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            googleMap.setMyLocationEnabled(true);
        } else {
            checkLocationPermissionWithRationale();
        }
    }

    // GPS위치 확인
    public static final int MY_PERMISSIONS_REQUEST_LOCATION = 99;

    private void checkLocationPermissionWithRationale() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.ACCESS_FINE_LOCATION)) {
                new AlertDialog.Builder(this)
                        .setTitle("위치정보")
                        .setMessage("이 앱을 사용하기 위해서는 위치정보에 접근이 필요합니다. 위치정보 접근을 허용해 주세요.")
                        .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                ActivityCompat.requestPermissions(Map1.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, MY_PERMISSIONS_REQUEST_LOCATION);
                            }
                        }).create().show();
            } else {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, MY_PERMISSIONS_REQUEST_LOCATION);
            }
        }
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_LOCATION: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                        mapView.setMyLocationEnabled(true);
                    }
                } else {
                    Toast.makeText(this, "permission denied", Toast.LENGTH_LONG).show();
                }
                return;
            }
        }
    }
}

