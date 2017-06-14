package com.example.user.interviewsample;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.user.interviewsample.data.ItemEvent;

import java.util.List;

import static com.example.user.interviewsample.data.ItemEvent.EVENT_TYPE;
import static com.example.user.interviewsample.data.ItemEvent.MAIN_TYPE;

/**
 * 文件描述 : Adapter 處理
 * Created by User
 * 2017/6/13
 * 版本 : 0.0.0.1
 */

public class DifferentRowAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<ItemEvent> mList;

    public DifferentRowAdapter(List<ItemEvent> list) {
        this.mList = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;

        switch (viewType) {
            case MAIN_TYPE:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_main, parent, false);
                return new MainViewHolder(view);
            case EVENT_TYPE:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_event, parent, false);
                return new EventViewHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ItemEvent object = mList.get(position);
        if (object != null) {
            switch (object.getType()) {
                case MAIN_TYPE:
                    ((MainViewHolder) holder).mTitle.setText(object.getName());
                    break;
                case EVENT_TYPE:
                    ((EventViewHolder) holder).mTitle.setText(object.getName());
                    ((EventViewHolder) holder).mDescription.setText(object.getDescription());
                    break;
            }
        }
    }

    @Override
    public int getItemCount() {
        if (mList == null)
            return 0;
        return mList.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (mList != null) {
            ItemEvent object = mList.get(position);
            if (object != null) {
                return object.getType();
            }
        }
        return 0;
    }

    public static class MainViewHolder extends RecyclerView.ViewHolder {
        private TextView mTitle;

        public MainViewHolder(View itemView) {
            super(itemView);
            mTitle = (TextView) itemView.findViewById(R.id.titleTextView);
        }
    }

    public static class EventViewHolder extends RecyclerView.ViewHolder {
        private TextView mTitle;
        private TextView mDescription;

        public EventViewHolder(View itemView) {
            super(itemView);
            mTitle = (TextView) itemView.findViewById(R.id.titleTextView);
            mDescription = (TextView) itemView.findViewById(R.id.descriptionTextView);
        }
    }
}
