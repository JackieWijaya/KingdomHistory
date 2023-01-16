package com.si5a.kingdomhistory;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class AdapterCard extends RecyclerView.Adapter<AdapterCard.CardViewHolder> {
    private ArrayList<ModelKingdom> dataKingdom;

    public AdapterCard(ArrayList<ModelKingdom> dataKingdom) {
        this.dataKingdom = dataKingdom;
    }

    public interface OnItemClickCallBack {
        void onItemClicked(ModelKingdom data);
    }

    private AdapterGrid.OnItemClickCallBack callBack;

    public void setOnItemCallBack(AdapterGrid.OnItemClickCallBack callBack) {
        this.callBack = callBack;
    }

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item_kingdom, parent, false);
        return new CardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolder holder, int position) {
        ModelKingdom kingdom = dataKingdom.get(position);

        holder.tvNamaKingdom.setText(kingdom.getNama());
        holder.tvTentangKingdom.setText(kingdom.getTentang());

        Glide
                .with(holder.itemView.getContext())
                .load(kingdom.getFoto())
                .into(holder.ivKingdom);

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

    public class CardViewHolder extends RecyclerView.ViewHolder {
        ImageView ivKingdom;
        TextView tvNamaKingdom, tvTentangKingdom;

        public CardViewHolder(@NonNull View itemView) {
            super(itemView);
            ivKingdom = itemView.findViewById(R.id.iv_kingdom);
            tvNamaKingdom = itemView.findViewById(R.id.tv_nama_kingdom);
            tvTentangKingdom = itemView.findViewById(R.id.tv_tentang_kingdom);
        }
    }

}
