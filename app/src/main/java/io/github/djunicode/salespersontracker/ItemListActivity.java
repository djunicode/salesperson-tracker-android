package io.github.djunicode.salespersontracker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class ItemListActivity extends AppCompatActivity {

   private String s1[]={"Dummy title 1","Dummy title 2","Dummy title 3","Dummy title 4","Dummy title 5","Dummy title 6","Dummy title 7","Dummy title 8","Dummy title 9","Dummy title 10" };
   private String s2[]={"Dummy content 1","Dummy content 2","Dummy content 3","Dummy content 4","Dummy content 5","Dummy content 6" ,"Dummy content 7","Dummy content 8","Dummy content 9","Dummy content 10"};
    private RecyclerView recyclerView;
    private ItemAdapter itemAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_list);

        recyclerView=findViewById(R.id.ItemListRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        itemAdapter=new ItemAdapter(this,getList());
        recyclerView.setAdapter(itemAdapter);


    }

    private ArrayList<ItemModel> getList(){
        ArrayList<ItemModel > models=new ArrayList<>();
        for(int i=0;i<10;i++){
            ItemModel m= new ItemModel();
            m.setProduct(s1[i]);
            m.setInfo(s2[i]);
            models.add(m);
        }
        return models;
    }


}
