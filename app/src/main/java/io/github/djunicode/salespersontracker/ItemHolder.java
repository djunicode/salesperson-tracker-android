package io.github.djunicode.salespersontracker;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ItemHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    EditText quantity;
    TextView product,info;
    Button billBtn;
    ItemClickListener itemClickListener;

    ItemHolder(@NonNull View itemView) {
        super(itemView);
        this.product=itemView.findViewById(R.id.TargetTitle);
        this.info=itemView.findViewById(R.id.TargetInfo);
        this.quantity=itemView.findViewById(R.id.quantityEt);
        this.billBtn=itemView.findViewById(R.id.bill_button);
        billBtn.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {

        this.itemClickListener.onItemClickListener(view,getLayoutPosition());
    }

    public void setItemClickListener(ItemClickListener ic){
        this.itemClickListener=ic;
    }
}
