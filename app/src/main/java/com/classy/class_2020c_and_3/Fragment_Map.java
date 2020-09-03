package com.classy.class_2020c_and_3;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;


public class Fragment_Map extends Fragment {

    private static final String TAG = "pttt" + Fragment_Map.class.getName();

    protected View view;
    private TextView map_LBL_info;

    private CallBack_MainActivity callBack_mainActivity;
    private CallBack_Location callBack_location;

    public void setActivityCallBack(CallBack_MainActivity callBack_mainActivity) {
        this.callBack_mainActivity = callBack_mainActivity;
    }

    public void setLocationCallBack(CallBack_Location callBack_location) {
        this.callBack_location = callBack_location;
    }

    public static Fragment_Map newInstance() {
        Log.d(TAG, "newInstance");

        Fragment_Map fragment = new Fragment_Map();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView");

        if(view==null){
            view = inflater.inflate(R.layout.fragment_map, container, false);
        }

        findViews(view);

        map_LBL_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (callBack_mainActivity != null) {
                    callBack_mainActivity.setMyColor(Color.GREEN);
                }

                if (callBack_location != null) {
                    callBack_location.locationReady(32.049278, 34.806560);
                }
            }
        });


        return view;
    }

    private void findViews(View view) {
        map_LBL_info = view.findViewById(R.id.map_LBL_info);
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        Log.d("pttt", "onSaveInstanceState");

        super.onSaveInstanceState(outState);
    }


    public void setMap(String location) {
        map_LBL_info.setText(location);
    }


    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);

        if (!hidden) {

        }
    }
}
