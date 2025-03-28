package com.example.finalprodproject.feature_roadmap.presentation.adapters;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.finalprodproject.R;
import com.example.finalprodproject.databinding.CircleItemBinding;
import com.example.finalprodproject.feature_main.data.RoadmapItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GraphAdapter extends RecyclerView.Adapter<GraphAdapter.ViewHolder> {
    private final List<RoadmapItem> items;
    private final List<Integer> drawablesList = new ArrayList<>();
    private OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(int id);
    }

    public GraphAdapter(List<RoadmapItem> items) {
        this.items = items;

        drawablesList.add(R.color.color_stroke_negative);
        drawablesList.add(R.color.color_stroke_positive);
        drawablesList.add(R.color.color_stroke_accent);
        drawablesList.add(R.color.color_purple);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public GraphAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CircleItemBinding binding = CircleItemBinding.inflate(LayoutInflater.from(parent.getContext()));
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull GraphAdapter.ViewHolder holder, int position) {
        holder.hideElements();
        int indexRandom = new Random().nextInt(drawablesList.size());
        if (position % 2 == 0) {
                holder.binding.circleTitleFirst.setVisibility(View.VISIBLE);
                holder.binding.circleImageFirst.setVisibility(View.VISIBLE);
                if (position + 1 != items.size()) holder.binding.circleRightFirst.setVisibility(View.VISIBLE);
                holder.binding.circleRightPagerFirst.setVisibility(View.VISIBLE);

                holder.binding.circleTitleFirst.setText(items.get(position).getText());
                holder.binding.circleRightPagerFirst.setText(Integer.toString(items.get(position).getScores()));

                holder.binding.circleImageFirst.setBorderColor(ContextCompat.getColor(holder.itemView.getContext(), drawablesList.get(indexRandom)));
                Glide.with(holder.itemView).load(items.get(position).getImage()).into(holder.binding.circleImageFirst);
        } else {
                holder.binding.circleTitleSecond.setVisibility(View.VISIBLE);
                holder.binding.circleImageSecond.setVisibility(View.VISIBLE);
                if (position + 1 != items.size()) holder.binding.circleLeftSecond.setVisibility(View.VISIBLE);
                holder.binding.circleRightPagerSecond.setVisibility(View.VISIBLE);

                holder.binding.circleTitleSecond.setText(items.get(position).getText());
                holder.binding.circleRightPagerSecond.setText(Integer.toString(items.get(position).getScores()));

                holder.binding.circleImageSecond.setBorderColor(ContextCompat.getColor(holder.itemView.getContext(), drawablesList.get(indexRandom)));
                Glide.with(holder.itemView).load(items.get(position).getImage()).into(holder.binding.circleImageSecond);
        }

        holder.itemView.setOnClickListener(v -> {
            if (listener != null) listener.onItemClick(items.get(position).getId());
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private CircleItemBinding binding;

        public ViewHolder(CircleItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        private void hideElements() {
            binding.circleTitleFirst.setVisibility(View.GONE);
            binding.circleImageFirst.setVisibility(View.GONE);
            binding.circleRightFirst.setVisibility(View.GONE);
            binding.circleRightPagerFirst.setVisibility(View.GONE);
            binding.circleTitleSecond.setVisibility(View.GONE);
            binding.circleImageSecond.setVisibility(View.GONE);
            binding.circleLeftSecond.setVisibility(View.GONE);
            binding.circleRightPagerSecond.setVisibility(View.GONE);

        }
    }
}

