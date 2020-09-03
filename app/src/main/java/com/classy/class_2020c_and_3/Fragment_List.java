package com.classy.class_2020c_and_3;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.android.material.button.MaterialButton;


public class Fragment_List extends Fragment {

    private static final String TAG = "pttt" + Fragment_List.class.getName();

    protected View view;
    private MaterialButton list_BTN_first;
    private MaterialButton list_BTN_second;

    private CallBack_MainActivity callBack_mainActivity;

    public void setActivityCallBack(CallBack_MainActivity callBack_mainActivity) {
        this.callBack_mainActivity = callBack_mainActivity;
    }

    public static Fragment_List newInstance() {
        Log.d(TAG, "newInstance");

        Fragment_List fragment = new Fragment_List();
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
            view = inflater.inflate(R.layout.fragment_list, container, false);
        }

        findViews(view);
        initViews();


        return view;
    }

    private void initViews() {
        list_BTN_first.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                list_BTN_first.setTextColor(Color.RED);
                if (callBack_mainActivity != null) {
                    callBack_mainActivity.setMyTitle("First City");
                }
            }
        });

        list_BTN_second.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                list_BTN_second.setTextColor(Color.RED);
                if (callBack_mainActivity != null) {
                    callBack_mainActivity.setMyColor(Color.GREEN);
                }
            }
        });
    }

    private void findViews(View view) {
        list_BTN_first = view.findViewById(R.id.list_BTN_first);
        list_BTN_second = view.findViewById(R.id.list_BTN_second);
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        Log.d("pttt", "onSaveInstanceState");

        super.onSaveInstanceState(outState);
    }

}
