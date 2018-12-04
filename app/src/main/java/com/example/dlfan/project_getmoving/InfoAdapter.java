package com.example.dlfan.project_getmoving;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

class MyItem{
    int mIcon;
    String nName;
    String nSource;
    MyItem(int aIcon,String aName,String aSource){mIcon = aIcon; nName = aName; nSource = aSource;}
}

public class InfoAdapter extends BaseAdapter {
    private Context mContext;
    private int mResource;
    private ArrayList<MyItem> mItems = new ArrayList<MyItem>();

    public InfoAdapter(Context context, int resource, ArrayList<MyItem> items){
        mContext = context;
        mResource = resource;
        mItems = items;
    }

    public int getCount(){
        return mItems.size();
    }
    public Object getItem(int position){
        return  mItems.get(position);
    }
    public long getItemId(int position){
        return  position;
    }

    public View getView(int position, View convertView, ViewGroup parent){
        if(convertView==null){
            LayoutInflater inflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(mResource, parent, false);
        }
        ImageView icon = (ImageView)convertView.findViewById(R.id.iconItem);
        icon.setImageResource(mItems.get(position).mIcon);

        TextView name = (TextView)convertView.findViewById(R.id.nameText);
        name.setText(mItems.get(position).nName);

        TextView age = (TextView)convertView.findViewById(R.id.sourceText);
        age.setText(mItems.get(position).nSource);

        return convertView;
    }
}
