package com.example.dlfan.project_getmoving;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class DetailsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
            finish();
            return;
        }

        DetailsFragmentActivity details = new DetailsFragmentActivity();

        details.setSelection(getIntent().getIntExtra("index",-1));

        getSupportFragmentManager().beginTransaction().replace(R.id.details, details).commit();
    }
}
