package com.sharad.pollapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class PollFragment extends Fragment {

     String [] listOfTopic = {"Select","Fashion","Beauty","Lifestyle","Wedding","Wellness","Entertainment"};
     onSubmitClick onSubmitClick;

    public PollFragment() {
        // Required empty public constructor
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_poll,container,false);
        Spinner spinner = (Spinner) v.findViewById(R.id.spinner);
        LinearLayout layout = v.findViewById(R.id.linear_layout);
        ImageView addButton = v.findViewById(R.id.add_button);
        EditText mainText = v.findViewById(R.id.editTextTextMultiLine);
        EditText option1 = v.findViewById(R.id.editTextTextPersonName2);
        EditText option2 = v.findViewById(R.id.editTextTextPersonName3);
        EditText textView =  new EditText(v.getContext());
        Button submit = v.findViewById(R.id.button);
        EditText text2 = new EditText(v.getContext());
        ArrayAdapter ad = new ArrayAdapter(v.getContext(), android.R.layout.simple_spinner_item,listOfTopic);
        ad.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner.setAdapter(ad);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(v.getContext(), "Currently We are working on this", Toast.LENGTH_SHORT).show();
//                if(layout.getChildCount() == 2){
//                    textView.setHint("New Option");
//                    textView.setBackground(getResources().getDrawable(R.drawable.text_bg_shape));
//                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT);
//                    layoutParams.setMargins(0,30,0,0);
//                    textView.setLayoutParams(layoutParams);
//                    layout.addView(textView);
//                }else if(layout.getChildCount() == 3){
//                    text2.setHint("New Option");
//                    text2.setBackground(getResources().getDrawable(R.drawable.text_bg_shape));
//                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT);
//                    layoutParams.setMargins(0,30,0,0);
//                    text2.setLayoutParams(layoutParams);
//                    layout.addView(text2);
//                }else{
//                    Toast.makeText(v.getContext(), "Maximum four option can be created", Toast.LENGTH_SHORT).show();
//                }
            }
        });
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String mC = mainText.getText().toString();
                String o1 = option1.getText().toString();
                String o2 = option2.getText().toString();
                String o3 = null;
                String o4 = null;
                if(layout.getChildCount() == 3){
                     o3 = textView.getText().toString();
                }

                if(layout.getChildCount() == 4){
                     o4 = text2.getText().toString();
                }

                if(TextUtils.isEmpty(mC)){
                    mainText.setError("Can't be empty");
                    return;
                }else if(TextUtils.isEmpty(o1)){
                    option1.setError("Required");
                    return;
                }else if(TextUtils.isEmpty(o2)){
                    option2.setError("Required");
                }else{
                    String cate = spinner.getSelectedItem().toString();
                    onSubmitClick.setData(mC,o1,o2,o3,o4,cate);
                    onSubmitClick.removeFragment();

                }


            }
        });
        return  v;

    }
    public interface onSubmitClick{
        public void setData(String mC,String o1,String o2,String o3,String o4,String category);
        public void removeFragment();

    }

    @Override
    public void onAttach(@NonNull Activity activity) {
        super.onAttach(activity);
        try {
            onSubmitClick = (onSubmitClick) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement onSomeEventListener");
        }
    }
}