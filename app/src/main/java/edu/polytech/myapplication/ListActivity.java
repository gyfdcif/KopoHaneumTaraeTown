package edu.polytech.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

public class ListActivity extends Fragment {
    View view;

    public static ListActivity newInstance() {
        Bundle args = new Bundle();
        ListActivity fragment = new ListActivity();
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_list, container, false);
        return view;
    }
}
