package com.example.dlfan.project_getmoving;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class DetailsFragmentActivity extends Fragment {
    static int index = -1;

    public DetailsFragmentActivity(){}

    public void setSelection(int i){index=i;}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.activity_details,container,false);
        TextView tv = (TextView)view.findViewById(R.id.textview);
        if(index>=0)
            tv.setText("Something");


        return view;
    }
}
