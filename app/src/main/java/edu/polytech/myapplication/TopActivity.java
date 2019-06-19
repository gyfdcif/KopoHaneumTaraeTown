package edu.polytech.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

public class TopActivity extends Fragment {
    View view;

    public static TopActivity newInstance() {
        Bundle args = new Bundle();
        TopActivity fragment = new TopActivity();
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_top, container, false);
        return view;
    }
}
