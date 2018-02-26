package com.whapps.erp.ui.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.whapps.erp.DTApplication;
import com.whapps.erp.R;
import com.whapps.erp.domain.model.Timeline;
import com.whapps.erp.domain.network.Service;
import com.whapps.erp.presentation.presenter.MainPresenter;
import com.whapps.erp.presentation.view.MainView;

import java.util.ArrayList;

import javax.inject.Inject;

/**
 * Created by roman on 26.02.18.
 */

public class FirstFragment extends Fragment implements MainView {

    public static FirstFragment newInstance() {
        return new FirstFragment();
    }

    private TextView textView;
    @Inject
    public Service service;
    private MainPresenter presenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment,
                container, false);
        DTApplication.getComponent().inject(this);

        presenter = new MainPresenter(service, this);
        presenter.getTimeline();

        renderView(view);
        init();

        return view;
    }

    public void renderView(View view) {
        textView = view.findViewById(R.id.textView);
    }

    private void init() {

        textView.setText("FirstFragment");

    }

    @Override
    public void showWait() {

    }

    @Override
    public void removeWait() {

    }

    @Override
    public void onFailure(String appErrorMessage) {

    }

    @Override
    public void getUserSuccess(String listUsers) {

    }

    @Override
    public void getTimelineSuccess(ArrayList<Timeline> users) {

    }
}