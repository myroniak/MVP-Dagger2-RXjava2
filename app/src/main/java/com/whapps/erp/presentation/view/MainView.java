package com.whapps.erp.presentation.view;

import com.whapps.erp.domain.model.Timeline;

import java.util.ArrayList;

/**
 * Created by ennur on 6/25/16.
 */
public interface MainView {
    void showWait();

    void removeWait();

    void onFailure(String appErrorMessage);

    void getUserSuccess(String listUsers);

    void getTimelineSuccess(ArrayList<Timeline> users);
}
