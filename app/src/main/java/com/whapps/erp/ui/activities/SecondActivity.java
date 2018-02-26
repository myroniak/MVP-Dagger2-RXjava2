package com.whapps.erp.ui.activities;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.whapps.erp.DTApplication;
import com.whapps.erp.R;
import com.whapps.erp.ui.fragments.FirstFragment;
import com.whapps.erp.ui.fragments.SecondFragment;

/**
 * Created by roman on 26.02.18.
 */

public class SecondActivity extends AppCompatActivity {

    private Button buttonFragmentOne, buttonFragmentTwo;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        DTApplication.getComponent().inject(this);

        renderView();
        init();

    }

    public void renderView() {

        buttonFragmentOne = findViewById(R.id.button_one);
        buttonFragmentTwo = findViewById(R.id.button_two);
    }

    public void init() {

        buttonFragmentOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.container, FirstFragment.newInstance(), "myTag");
                transaction.commit();
            }
        });

        buttonFragmentTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.container, SecondFragment.newInstance(), "myTag");
                transaction.commit();
            }
        });

    }
}