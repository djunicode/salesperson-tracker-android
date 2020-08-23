package io.github.djunicode.salespersontracker;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ItemAdapter extends RecyclerView.Adapter<ItemHolder> {

    Context c;
    ArrayList<ItemModel> itemModels;

    public ItemAdapter(Context c, ArrayList<ItemModel> itemModels) {
        this.c = c;
        this.itemModels = itemModels;
    }

    @NonNull
    @Override
    public ItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_update_target,null);
        return new ItemHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemHolder holder, int position) {
        holder.info.setText(itemModels.get(position).getInfo());
        holder.product.setText(itemModels.get(position).getProduct());

        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClickListener(View v, int position) {
                String gTitle=itemModels.get(position).getProduct();
                String gInfo=itemModels.get(position).getInfo();
                String gQuantity=holder.quantity.getText().toString();

                Intent intent=new Intent(c,BillingActivity.class);
                intent.putExtra("iTitle",gTitle);
                intent.putExtra("iInfo",gInfo);
                intent.putExtra("iQuantity",gQuantity);
                c.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return itemModels.size();
    }
}
