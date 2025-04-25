package com.example.rejibstore.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rejibstore.Domain.CategoryModel;
import com.example.rejibstore.R;
import com.example.rejibstore.databinding.ViewHolderCategoryBinding;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {
    private ArrayList<CategoryModel> items;
    private Context context;
    private int selectedPosition = -1;
    private int lastSelectedPosition = -1;

    public CategoryAdapter(ArrayList<CategoryModel> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public CategoryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        ViewHolderCategoryBinding binding = ViewHolderCategoryBinding.inflate(LayoutInflater.from(context)
                , parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryAdapter.ViewHolder holder, int position) {
        holder.binding.tittleTxt.setText(items.get(position).getTitle());

        holder.binding.getRoot().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lastSelectedPosition=selectedPosition;
                selectedPosition=position;
                notifyItemChanged(lastSelectedPosition);
                notifyItemChanged(selectedPosition);
            }
        });

        if(selectedPosition==position){
            holder.binding.tittleTxt.setBackgroundResource(R.drawable.blue_bg);
            holder.binding.tittleTxt.setTextColor(context.getResources().getColor(R.color.white));
        }else{
            holder.binding.tittleTxt.setBackgroundResource(R.drawable.stroke_bg);
            holder.binding.tittleTxt.setTextColor(context.getResources().getColor(R.color.black));
        }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ViewHolderCategoryBinding binding;

        public ViewHolder(ViewHolderCategoryBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
