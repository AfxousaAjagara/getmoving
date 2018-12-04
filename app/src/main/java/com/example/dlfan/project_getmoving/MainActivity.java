package com.example.dlfan.project_getmoving;

import android.content.Intent;
import android.content.res.Configuration;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements TitleFragmentActivity.OnTitleSelectedListner{

    //생성시의 동작
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //데이터 원본
        ArrayList<MyItem> data = new ArrayList<MyItem>();

        //어댑터 생성
        final InfoAdapter adapter = new InfoAdapter(this, R.layout.item, data);
        data.add(new MyItem(R.drawable.ic_launcher_foreground,"Bella","1"));

        //어댑터 연결
        ListView list = (ListView)findViewById(R.id.listView);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View vClicked, int position, long id) {
                String name = (String)((TextView)vClicked.findViewById(R.id.nameText)).getText();
                Toast.makeText(MainActivity.this, name + " selected", Toast.LENGTH_SHORT).show();
            }
        });
    }
    //가로보기
    public void onTitleSelected(int i){
        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){ //가로보기 사용중 details Fragment를 선택한 항목에 맞게 바꿈
            DetailsFragmentActivity detailsFragmentActivity = new DetailsFragmentActivity();
            detailsFragmentActivity.setSelection(i);
            getSupportFragmentManager().beginTransaction().replace(R.id.details, detailsFragmentActivity).commit();
        } else{
            Intent intent = new Intent(this, DetailsActivity.class);
            intent.putExtra("index", i);
            startActivity(intent);
        }
    }

    //메뉴 생성
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.main_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }
    //메뉴 선택시 이벤트
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()){
            case R.id.search_vault:
                Toast.makeText(this, "selected", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this, SearchVaultActivity.class));
                return true;
            case R.id.edit_vault:
                Toast.makeText(this,"selected2",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this,EditVaultActivity.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }



}
