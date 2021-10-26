package com.sharad.pollapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements PollFragment.onSubmitClick {

    FloatingActionButton mAdding;
    RecyclerView recyclerView;
    MainActivityAdapter adapter;
    PollFragment myFrag;
    ArrayList<InformationClass> mainList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAdding = findViewById(R.id.floatingActionButton);
        recyclerView = findViewById(R.id.recycler_view_main);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        mainList.add(new InformationClass("which is better for marketing ?","Facebook","Instagram","","","Business",0));

        adapter = new MainActivityAdapter(this,mainList);
        recyclerView.setAdapter(adapter);
        mAdding.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
              if(savedInstanceState == null){

                  recyclerView.setVisibility(View.INVISIBLE);
                  myFrag = new PollFragment();
                  FragmentManager manager = getSupportFragmentManager();
                  FragmentTransaction transaction = manager.beginTransaction();
                  transaction.setReorderingAllowed(true);
                  transaction.add(R.id.main_layout,myFrag,"sharad").addToBackStack(null).commit();
                  mAdding.setVisibility(View.INVISIBLE);
              }
           }
       });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        recyclerView.setVisibility(View.VISIBLE);
        mAdding.setVisibility(View.VISIBLE);
    }

    @Override
    public void setData(String mC, String o1, String o2, String o3, String o4,String category) {
        mainList.add(new InformationClass(mC,o1,o2,o3,o4,category,0));
        adapter.notifyDataSetChanged();


    }

    @Override
    public void removeFragment() {
        getSupportFragmentManager().beginTransaction().remove(myFrag).commit();
        recyclerView.setVisibility(View.VISIBLE);
        mAdding.setVisibility(View.VISIBLE);
    }

}