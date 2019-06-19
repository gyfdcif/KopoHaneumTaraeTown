package edu.polytech.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

public class StoredActivity extends Fragment {
    View view;

    public static StoredActivity newInstance() {
        Bundle args = new Bundle();
        StoredActivity fragment = new StoredActivity();
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_stored, container, false);
        return view;
    }
}
