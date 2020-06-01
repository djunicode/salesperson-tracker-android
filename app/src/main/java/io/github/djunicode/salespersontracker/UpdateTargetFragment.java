package io.github.djunicode.salespersontracker;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * A simple {@link Fragment} subclass.
 */
public class UpdateTargetFragment extends Fragment {

    public UpdateTargetFragment() {
        // Required empty public constructor
    }

    //String s1[]={"Dummy title 1","Dummy title 2","Dummy title 3","Dummy title 4","Dummy title 5","Dummy title 6","Dummy title 7","Dummy title 8","Dummy title 9","Dummy title 10" };
    //String s2[]={"Dummy content 1","Dummy content 2","Dummy content 3","Dummy content 4","Dummy content 5","Dummy content 6" ,"Dummy content 7","Dummy content 8","Dummy content 9","Dummy content 10"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View r=inflater.inflate(R.layout.fragment_update_target, container, false);

        final String[] task_id = new String[100];
        final String[] qty = new String[100];

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl( TaskRetriever.BASE_URL )
                .addConverterFactory( GsonConverterFactory.create() )
                .build();

        /*
        TaskRetriever tr = retrofit.create( TaskRetriever.class );
        Call<List<DailyTask>> call = tr.getDailyTasks();
        call.enqueue( new Callback<List<DailyTask>>() {
            @Override
            public void onResponse(Call<List<DailyTask>> call, Response<List<DailyTask>> response) {
                List<DailyTask> taskList = response.body();
                    for(int i=0;i<taskList.size();i++)
                    {
                        task_id[i] = taskList.get( i ).getId();
                        qty[i] = taskList.get( i ).getQuantity();
                    }
            }
            @Override
            public void onFailure(Call<List<DailyTask>> call, Throwable t) {
                Toast.makeText( getContext(), "Error in fetching tasks..", Toast.LENGTH_SHORT ).show();
            }
        } );
        */

        RecyclerView r2 = r.findViewById(R.id.UpdateTargetsRecyclerView);
        RecyclerView.Adapter adapter2 = new UpdateTargetAdapter(getContext(), task_id, qty);
        r2.setAdapter(adapter2);
        r2.setLayoutManager(new LinearLayoutManager(getContext()));
        return r;
    }

}
