package edu.polytech.myapplication.domain;

import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import edu.polytech.myapplication.R;

public class MainCustomAdapter extends RecyclerView.Adapter<MainCustomAdapter.CustomViewHolder> {

    private ArrayList<MainTarae> mList;

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        protected TextView Tarae_Id;
        protected TextView user_Id;
        protected TextView Title;
        protected TextView Content;
        protected TextView date;
        protected TextView viewCount;
        protected TextView likeCOunt;

        public CustomViewHolder(View view){
            super(view);
            this.Title = (TextView) view.findViewById(R.id.TaraeTitle_TextView);
            this.Content = (TextView) view.findViewById(R.id.TaraeContent_TextView);
            this.date = (TextView) view.findViewById(R.id.TaraeTime_TextView);
            this.viewCount = (TextView) view.findViewById(R.id.TaraeLikeCount_TextView);
            this.likeCOunt = (TextView) view.findViewById(R.id.TaraeViewCount_TextView);
        }
    }

    public MainCustomAdapter(ArrayList<MainTarae> list) {
        this.mList = list;
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_list, null);
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.maintarae_item, viewGroup, false);
        CustomViewHolder viewHolder = new CustomViewHolder(view);

        return viewHolder;
    }


    // Adapter의 특정 위치(position)에 있는 데이터를 보여줘야 할때 호출됩니다.
    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder viewholder, int position) {

        viewholder.Title.setTextSize(TypedValue.COMPLEX_UNIT_SP, 25);
        viewholder.Content.setTextSize(TypedValue.COMPLEX_UNIT_SP, 25);
        viewholder.date.setTextSize(TypedValue.COMPLEX_UNIT_SP, 25);
        viewholder.viewCount.setTextSize(TypedValue.COMPLEX_UNIT_SP, 25);
        viewholder.likeCOunt.setTextSize(TypedValue.COMPLEX_UNIT_SP, 25);

        viewholder.Title.setGravity(Gravity.CENTER);
        viewholder.Content.setGravity(Gravity.CENTER);
        viewholder.date.setGravity(Gravity.CENTER);
        viewholder.viewCount.setGravity(Gravity.CENTER);
        viewholder.likeCOunt.setGravity(Gravity.CENTER);

        viewholder.Title.setText(mList.get(position).getTitle());
        viewholder.Content.setText(mList.get(position).getContent());
        viewholder.date.setText(mList.get(position).getDate());
        viewholder.viewCount.setText(mList.get(position).getViewCount());
        viewholder.likeCOunt.setText(mList.get(position).getLikeCOunt());
    }

    @Override
    public int getItemCount() {
        return (null != mList ? mList.size() : 0);
    }
}
