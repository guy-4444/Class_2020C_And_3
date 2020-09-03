package com.classy.class_2020c_and_3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.button.MaterialButton;

public class Activity_Tabs extends AppCompatActivity {

    private MaterialButton tabs_BTN_list;
    private MaterialButton tabs_BTN_map;

    private Fragment_List fragment_list;
    private Fragment_Map fragment_map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabs);

        findViews();
        initViews();

        fragment_list = Fragment_List.newInstance();
        fragment_map = Fragment_Map.newInstance();

        FragmentTransaction t = getSupportFragmentManager().beginTransaction();
        t.add(R.id.tabs_LAY_content, fragment_list);
        t.add(R.id.tabs_LAY_content, fragment_map);
        t.commit();

        getSupportFragmentManager().beginTransaction().hide(fragment_map).commit();

    }

    private void showList() {
        getSupportFragmentManager().beginTransaction().hide(fragment_map).commit();
        getSupportFragmentManager().beginTransaction().show(fragment_list).commit();
    }

    private void showMap() {
        getSupportFragmentManager().beginTransaction().hide(fragment_list).commit();
        getSupportFragmentManager().beginTransaction().show(fragment_map).commit();
    }

    private void initViews() {
        tabs_BTN_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showList();
            }
        });

        tabs_BTN_map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showMap();
            }
        });
    }

    private void findViews() {
        tabs_BTN_list = findViewById(R.id.tabs_BTN_list);
        tabs_BTN_map = findViewById(R.id.tabs_BTN_map);
    }

}