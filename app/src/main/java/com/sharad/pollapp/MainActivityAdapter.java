package com.sharad.pollapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivityAdapter extends RecyclerView.Adapter<MainActivityAdapter.MyViewHolder> {

    Context context;
    ArrayList<InformationClass> adapterList;


    public MainActivityAdapter(Context context,ArrayList<InformationClass> adapterList) {
        this.context = context;
        this.adapterList = adapterList;
    }

    @NonNull


    @Override
    public MainActivityAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.content_view,parent,false);
        return new MyViewHolder(v);

    }

    @Override
    public void onBindViewHolder(@NonNull MainActivityAdapter.MyViewHolder holder, @SuppressLint("RecyclerView") int position) {

        holder.mCategory.setText(adapterList.get(position).category);
        holder.mContent.setText(adapterList.get(position).mContent);
        holder.op1.setText(adapterList.get(position).optionOne);
        holder.op2.setText(adapterList.get(position).optionTwo);

        holder.op1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(adapterList.get(position).choice == 0){
                    String str = holder.op1.getText().toString();
                    Toast.makeText(context, str +" selected", Toast.LENGTH_SHORT).show();
                    holder.op1.setBackground(context.getResources().getDrawable(R.drawable.ten_percent));
                    holder.op1.setText("   " + str + "               40 %");
                    adapterList.get(position).setOptionOne("   " + str + "               40 %");
                    holder.votes.setText("121 Vote");
                    holder.op2.setBackground(context.getResources().getDrawable(R.drawable.ten_percent));
                    String str2 = holder.op2.getText().toString();
                    holder.op2.setText("   " + str2 + "               60 %");
                    adapterList.get(position).setOptionTwo("   " + str2 + "               60 %");
                    adapterList.get(position).setChoice(1);
                }
            }
        });
        holder.op2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(adapterList.get(position).choice == 0){
                    String str = holder.op2.getText().toString();
                    Toast.makeText(context, str +" selected", Toast.LENGTH_SHORT).show();
                    holder.op2.setBackground(context.getResources().getDrawable(R.drawable.ten_percent));
                    holder.op2.setText("   " + str + "               40 %");
                    adapterList.get(position).setOptionTwo("   " + str + "               40 %");
                    holder.op1.setBackground(context.getResources().getDrawable(R.drawable.ten_percent));
                    String str2 = holder.op1.getText().toString();
                    holder.op1.setText("   " + str2 + "                60 %");
                    adapterList.get(position).setOptionOne("   " + str + "               60 %");
                    holder.votes.setText("121 Vote");
                    adapterList.get(position).setChoice(1);
                }

            }
        });


    }

    @Override
    public int getItemCount() {
        return adapterList.size();
    }

    public  class MyViewHolder extends RecyclerView.ViewHolder{
        TextView mCategory;
        TextView mContent;
        TextView op1;
        TextView op2;
        TextView op3;
        TextView op4;
        TextView votes;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            mCategory = itemView.findViewById(R.id.textView5);
            mContent = itemView.findViewById(R.id.textView6);
            op1 = itemView.findViewById(R.id.textView7);
            op2 = itemView.findViewById(R.id.textView8);
            votes = itemView.findViewById(R.id.textView9);



        }
    }
}

