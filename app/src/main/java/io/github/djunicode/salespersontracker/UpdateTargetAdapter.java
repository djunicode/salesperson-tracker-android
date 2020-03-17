package io.github.djunicode.salespersontracker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class UpdateTargetAdapter extends RecyclerView.Adapter < UpdateTargetAdapter.MyAdapterTarget>
{
    String TargetTitles[];
    String  TargetInfo[];
    Context ctx;
    public UpdateTargetAdapter(Context ct, String s1[],String s2 [])
    {
        ctx=ct;
        TargetTitles=s1;
        TargetInfo=s2;


    }


    @NonNull
    @Override
    public UpdateTargetAdapter.MyAdapterTarget onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_update_target, parent, false);

        UpdateTargetAdapter.MyAdapterTarget
                vh = new UpdateTargetAdapter.MyAdapterTarget(v);
        return vh;
    }


    @Override
    public void onBindViewHolder(@NonNull UpdateTargetAdapter.MyAdapterTarget holder, int position)
    {


        holder.TargetTitle.setText( TargetTitles[position]);
        holder.TargetInfo.setText(TargetInfo[position]);


    }

    @Override
    public int getItemCount()
    {
        return  TargetInfo.length;
    }


    public class MyAdapterTarget extends RecyclerView.ViewHolder
    {
        CardView UpdateTargetCardView;
        TextView TargetTitle,TargetInfo;
        public MyAdapterTarget(View v)
        {
            super(v);
            UpdateTargetCardView=v.findViewById(R.id.UpdateTargetCardView);
            TargetTitle=v.findViewById(R.id.TargetTitle);
            TargetInfo=v.findViewById(R.id.TargetInfo);
        }
    }
}
