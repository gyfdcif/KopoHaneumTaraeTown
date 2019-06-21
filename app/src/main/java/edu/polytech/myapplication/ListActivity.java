package edu.polytech.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import edu.polytech.myapplication.domain.MainCustomAdapter;
import edu.polytech.myapplication.domain.MainTarae;

public class ListActivity extends Fragment {
    private static String TAG = "recyclerview_main";
    View view;

    private ArrayList<MainTarae> mArrayList;
    private MainCustomAdapter mAdapter;
    private RecyclerView mRecyclerView;
    private LinearLayoutManager mLinearLayoutManager;
    private int count = -1;

    public static ListActivity newInstance() {
        Bundle args = new Bundle();
        ListActivity fragment = new ListActivity();
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_list, container, false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerview_main_list);
        mRecyclerView.setHasFixedSize(true);
        mLinearLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        mRecyclerView.scrollToPosition(0);

        mAdapter = new MainCustomAdapter(mArrayList);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initDataset();
    }

    private void initDataset() {
        //for Test
        ArrayList<MainTarae> mSearchData = new ArrayList<>();
        mSearchData.add(new MainTarae("1", "kopo22", "타이틀1", "첫번째 메인타래", "2019-06-21", 0, 0));
        mSearchData.add(new MainTarae("2", "kopo22", "타이틀2", "두번째 메인타래", "2019-06-21", 0, 0));
        mSearchData.add(new MainTarae("3", "kopo22", "타이틀3", "세번째 메인타래", "2019-06-21", 0, 0));
    }
}
