package edu.polytech.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

public class ARActivity extends Fragment {
    View view;

    public static ARActivity newInstance() {
        Bundle args = new Bundle();
        ARActivity fragment = new ARActivity();
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_ar, container, false);
        return view;
    }
}
