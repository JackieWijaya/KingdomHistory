package com.si5a.kingdomhistory;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class AdapterGrid extends RecyclerView.Adapter<AdapterGrid.GridViewHolder> {
    private ArrayList<ModelKingdom> dataKingdom;

    public AdapterGrid(ArrayList<ModelKingdom> dataKingdom) {
        this.dataKingdom = dataKingdom;
    }

    public interface OnItemClickCallBack {
        void onItemClicked(ModelKingdom data);
    }

    private OnItemClickCallBack callBack;

    public void setOnItemCallBack(OnItemClickCallBack callBack) {
        this.callBack = callBack;
    }

    @NonNull
    @Override
    public GridViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_item_kingdom, parent, false);
        return new GridViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GridViewHolder holder, int position) {
        ModelKingdom kingdom = dataKingdom.get(position);

        Glide
                .with(holder.itemView.getContext())
                .load(kingdom.getFoto())
                .into(holder.ivGridKingdom);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callBack.onItemClicked(dataKingdom.get(holder.getAdapterPosition()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataKingdom.size();
    }

    public class GridViewHolder extends RecyclerView.ViewHolder {
        ImageView ivGridKingdom;

        public GridViewHolder(@NonNull View itemView) {
            super(itemView);
            ivGridKingdom = itemView.findViewById(R.id.iv_grid_kingdom);
        }
    }

}
