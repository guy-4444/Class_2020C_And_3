package com.classy.class_2020c_and_3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.os.Handler;
import android.widget.FrameLayout;

import com.google.android.material.textview.MaterialTextView;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class Activity_Main extends AppCompatActivity {


    private MaterialTextView main_LBL_title;
    private Fragment_List fragment_list;
    private Fragment_Map fragment_map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViews();
        initFragments();

    }

    private void findViews() {
        main_LBL_title = findViewById(R.id.main_LBL_title);
    }

    @Override
    protected void onStart() {
        super.onStart();
        fragment_map.setMap("Givaataim");
    }

    private void initFragments() {
        fragment_list = new Fragment_List();
        fragment_list.setActivityCallBack(callback);
        FragmentTransaction transaction1 = getSupportFragmentManager().beginTransaction();
        transaction1.replace(R.id.main_LAY_list, fragment_list);
        transaction1.commit();

        fragment_map = Fragment_Map.newInstance();
        fragment_map.setActivityCallBack(callback);
        fragment_map.setLocationCallBack(callBack_location);
        FragmentTransaction transaction2 = getSupportFragmentManager().beginTransaction();
        transaction2.replace(R.id.main_LAY_map, fragment_map);
        transaction2.commit();
    }

    CallBack_Location callBack_location = new CallBack_Location() {
        @Override
        public void locationReady(double lat, double lon) {

            Geocoder geocoder;
            List<Address> addresses;
            geocoder = new Geocoder(Activity_Main.this, Locale.getDefault());

            try {
                addresses = geocoder.getFromLocation(lat, lon, 1);
                main_LBL_title.setText(addresses.get(0).getFeatureName());
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    };

    CallBack_MainActivity callback = new CallBack_MainActivity() {
        @Override
        public void setMyTitle(String title) {
            main_LBL_title.setText(title);

        }

        @Override
        public void setMyColor(int color) {
            main_LBL_title.setBackgroundColor(color);

        }
    };

}