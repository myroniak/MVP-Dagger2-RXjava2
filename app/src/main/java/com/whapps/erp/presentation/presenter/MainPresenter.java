package com.whapps.erp.presentation.presenter;

import com.whapps.erp.domain.model.Timeline;
import com.whapps.erp.domain.model.User;
import com.whapps.erp.domain.network.NetworkError;
import com.whapps.erp.domain.network.Service;
import com.whapps.erp.presentation.view.MainView;

import java.util.ArrayList;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by ennur on 6/25/16.
 */
public class MainPresenter {

    private final Service service;
    private final MainView view;
    private CompositeSubscription subscriptions;

    public MainPresenter(Service service, MainView view) {
        this.service = service;
        this.view = view;
        this.subscriptions = new CompositeSubscription();
    }

    public void getUser(String name) {
        view.showWait();

        Subscription subscription = service.getUsers("Basic ZmE3M2FmYWQtZTAwZS00MDliLWI2MDYtMjY5MjlmZjM2NmY5OmMwM2QyODc2MWNkYTRlNDhhMjNhYWMxMTBjZDg1NjBh",
                "22778021-2bed-4221-94c4-47c58ec6c91d", name, new Service.GetUserCallback() {
                    @Override
                    public void onSuccess(ArrayList<User> userResponse) {

                        String listString = "";
                        String typeUser = "";

                        for (User user : userResponse) {
                            if (user.getType().contains("user")) {
                                typeUser = "user: " + user.getName();
                            } else {
                                typeUser = "team: " + user.getName();
                            }
                            listString += typeUser + "\n";
                        }

                        view.removeWait();
                        view.getUserSuccess(listString);
                    }

                    @Override
                    public void onError(NetworkError networkError) {
                        view.removeWait();
                        view.onFailure(networkError.getAppErrorMessage());
                    }

                });

        subscriptions.add(subscription);
    }

    public void getTimeline() {
        view.showWait();

        Subscription subscription = service.timeline("Basic ZmE3M2FmYWQtZTAwZS00MDliLWI2MDYtMjY5MjlmZjM2NmY5OmMwM2QyODc2MWNkYTRlNDhhMjNhYWMxMTBjZDg1NjBh",
                "fc4e5fa7-ee06-4d29-87dd-75f60e60f1ba", new Service.GetTimelineCallback() {
                    @Override
                    public void onSuccess(ArrayList<Timeline> userResponse) {
                        view.removeWait();
                        view.getTimelineSuccess(userResponse);
                    }

                    @Override
                    public void onError(NetworkError networkError) {
                        view.removeWait();
                        view.onFailure(networkError.getAppErrorMessage());
                    }

                });

        subscriptions.add(subscription);
    }

    public void onStop() {
        subscriptions.unsubscribe();
    }
}
