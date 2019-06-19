package edu.polytech.myapplication.test;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import edu.polytech.myapplication.R;
import edu.polytech.myapplication.domain.MainTarae;

public class MainTaraeAdapter extends RecyclerView.Adapter<MainTaraeAdapter.TaraeViewHolder> {

    List<MainTarae> mainTaraeList;

    public MainTaraeAdapter(List<MainTarae> mainTaraeList) {
        this.mainTaraeList = mainTaraeList;
    }

    @NonNull
    @Override
    public MainTaraeAdapter.TaraeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.maintarae_item, parent, false);

        TaraeViewHolder viewHolder = new TaraeViewHolder(view);

        return viewHolder;
    }


    @Override
    public void onBindViewHolder(@NonNull MainTaraeAdapter.TaraeViewHolder holder, int position) {
        holder.title.setText(mainTaraeList.get(position).getTitle());
        holder.content.setText(mainTaraeList.get(position).getContent());

        holder.date.setText(mainTaraeList.get(position).getDate());
        holder.viewCount.setText(String.valueOf(mainTaraeList.get(position).getViewCount()));
        holder.likeCount.setText(String.valueOf(mainTaraeList.get(position).getLikeCOunt()));
    }

    @Override
    public int getItemCount() {
        return mainTaraeList.size();
    }

    public class TaraeViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        TextView content;
        TextView date;

        TextView viewCount;
        TextView likeCount;

        public TaraeViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.TaraeTitle_TextView);
            content = itemView.findViewById(R.id.TaraeContent_TextView);
            date = itemView.findViewById(R.id.TaraeTime_TextView);
            viewCount = itemView.findViewById(R.id.TaraeViewCount_TextView);
            likeCount = itemView.findViewById(R.id.TaraeLikeCount_TextView);
        }
    }
}
