package com.whapps.erp.ui.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.whapps.erp.R;

/**
 * Created by roman on 26.02.18.
 */

public class SecondFragment extends Fragment {

    public static SecondFragment newInstance() {
        return new SecondFragment();
    }

    private TextView textView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment,
                container, false);

        renderView(view);
        init();

        return view;
    }

    public void renderView(View view) {
        textView = view.findViewById(R.id.textView);
    }

    private void init() {

        textView.setText("SecondFragment");

    }
}