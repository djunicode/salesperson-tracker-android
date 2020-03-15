package io.github.djunicode.salespersontracker;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class UpdateTargetFragment extends Fragment {


    public UpdateTargetFragment() {
        // Required empty public constructor
    }

    String s1[]={"Dummy title 1","Dummy title 2","Dummy title 3","Dummy title 4","Dummy title 5","Dummy title 6","Dummy title 7","Dummy title 8","Dummy title 9","Dummy title 10" };
    String s2[]={"Dummy content 1","Dummy content 2","Dummy content 3","Dummy content 4","Dummy content 5","Dummy content 6" ,"Dummy content 7","Dummy content 8","Dummy content 9","Dummy content 10"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         View r=inflater.inflate(R.layout.fragment_update_target, container, false);
        RecyclerView r2 = r.findViewById(R.id.UpdateTargetsRecyclerView);
        RecyclerView.Adapter adapter2 = new UpdateTargetAdapter(getContext(), s1, s2);

        r2.setAdapter(adapter2);
        r2.setLayoutManager(new LinearLayoutManager(getContext()));


        return r;
    }

}
