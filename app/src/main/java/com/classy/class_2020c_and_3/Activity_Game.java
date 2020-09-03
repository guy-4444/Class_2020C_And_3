package com.classy.class_2020c_and_3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.google.android.material.textview.MaterialTextView;

public class Activity_Game extends AppCompatActivity implements CallBack_Location {

    private MaterialTextView game_LBL_location;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        game_LBL_location = findViewById(R.id.game_LBL_location);

        Fragment_Map fragment_map = Fragment_Map.newInstance();
        fragment_map.setLocationCallBack(this);
        FragmentTransaction transaction2 = getSupportFragmentManager().beginTransaction();
        transaction2.replace(R.id.game_LAY_map, fragment_map);
        transaction2.commit();
    }

    @Override
    public void locationReady(double lat, double lon) {
        game_LBL_location.setText(lat + ", " + lon);
    }
}