package com.whapps.erp.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.whapps.erp.DTApplication;
import com.whapps.erp.R;
import com.whapps.erp.domain.adapter.RecyclerAdapter;
import com.whapps.erp.domain.model.Timeline;
import com.whapps.erp.domain.network.Service;
import com.whapps.erp.presentation.presenter.MainPresenter;
import com.whapps.erp.presentation.view.MainView;

import java.util.ArrayList;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements MainView {

    @Inject
    public Service service;
    private TextView textView;
    private EditText editText;
    private Button buttonToFr;
    private ProgressBar progressBar;
    private RecyclerView.Adapter mAdapter;
    private MainPresenter presenter;
    private RecyclerView rvItems;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DTApplication.getComponent().inject(this);

        renderView();
        init();

        presenter = new MainPresenter(service, this);
        presenter.getTimeline();


    }

    public void renderView() {
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        progressBar = findViewById(R.id.progress);
        editText = findViewById(R.id.editText);
        rvItems = findViewById(R.id.rv);
        buttonToFr = findViewById(R.id.buttonToFr);
    }

    public void init() {

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.toString().length() >= 2) {
                    presenter.getUser(editText.getText().toString());
                } else {
                    textView.setText("");
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        buttonToFr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, SecondActivity.class));
            }
        });

        mLayoutManager = new LinearLayoutManager(this);
        rvItems.setLayoutManager(mLayoutManager);
    }

    private void initRecycler(ArrayList<Timeline> timelineList) {

        mAdapter = new RecyclerAdapter(timelineList);
        rvItems.setAdapter(mAdapter);
    }


    @Override
    public void showWait() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void removeWait() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void onFailure(String appErrorMessage) {
    }

    @Override
    public void getUserSuccess(String listString) {

        textView.setText(listString);

    }

    @Override
    public void getTimelineSuccess(final ArrayList<Timeline> users) {
        initRecycler(users);
    }
}
