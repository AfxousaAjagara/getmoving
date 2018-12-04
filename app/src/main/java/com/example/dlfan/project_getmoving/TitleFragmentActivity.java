package com.example.dlfan.project_getmoving;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

public class TitleFragmentActivity extends Fragment {
    public interface  OnTitleSelectedListner{
        public void onTitleSelected(int i);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState){
        View rootView = (View)inflater.inflate(R.layout.activity_main,container,false);
        ListView lv = (ListView)rootView.findViewById(R.id.listView);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Activity activity =getActivity();
                ((OnTitleSelectedListner)activity).onTitleSelected(position);
            }
        });
        lv.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        return  rootView;
    }
}
