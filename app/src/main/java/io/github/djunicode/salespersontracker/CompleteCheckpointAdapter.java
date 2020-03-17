package io.github.djunicode.salespersontracker;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class CompleteCheckpointAdapter extends RecyclerView.Adapter < CompleteCheckpointAdapter.MyAdapterCheckpoint>
{

    String checkpointTitles[];
    String  checkpointInfo[];
    Context ctx;
    public CompleteCheckpointAdapter(Context ct, String s1[],String s2 [])
    {
        ctx=ct;
        checkpointTitles=s1;
        checkpointInfo=s2;


    }
    @NonNull
    @Override
    public MyAdapterCheckpoint onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_complete_checkpoint, parent, false);

        MyAdapterCheckpoint vh = new MyAdapterCheckpoint(v);
        return vh;
    }


    @Override
    public void onBindViewHolder(@NonNull MyAdapterCheckpoint holder, int position)
    {


        holder.chkptTitle.setText( checkpointTitles[position]);
        holder.chkptContent.setText(checkpointInfo[position]);


    }

    @Override
    public int getItemCount() {
        return checkpointTitles.length;
    }

    public class MyAdapterCheckpoint extends RecyclerView.ViewHolder
    {
        CardView CompleteCheckpointCArdView;
        TextView chkptTitle,chkptContent;
        public MyAdapterCheckpoint(View v)
        {
            super(v);
            CompleteCheckpointCArdView=v.findViewById(R.id.CheckPointCardView);
            chkptTitle=v.findViewById(R.id.chkptTitle);
            chkptContent=v.findViewById(R.id.chkptContent);


        }
    }


}
