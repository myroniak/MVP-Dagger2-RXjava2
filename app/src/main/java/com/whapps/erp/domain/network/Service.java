package com.whapps.erp.domain.network;


import com.whapps.erp.domain.ApiService;
import com.whapps.erp.domain.model.Event;
import com.whapps.erp.domain.model.Timeline;
import com.whapps.erp.domain.model.User;
import com.whapps.erp.domain.network.NetworkError;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.functions.Func2;
import rx.schedulers.Schedulers;

public class Service {
    private final ApiService networkService;

    public Service(ApiService networkService) {
        this.networkService = networkService;
    }

    private Observable<ArrayList<User>> getUsers(String auth, String companyId, String name) {
        return networkService.searchUsers(auth, companyId, name);
    }

    private Observable<ArrayList<User>> getTeams(String auth, String companyId, String name) {
        return networkService.searchTeams(auth, companyId, name);

    }

    public Subscription events(String auth, String userId, int year, int month, int day, final GetEventsCallback getEventsCallback) {
        return networkService.events(auth, userId, year, month, day)
                .onErrorResumeNext(new Func1<Throwable, Observable<? extends ArrayList<Event>>>() {
                    @Override
                    public Observable<? extends ArrayList<Event>> call(Throwable throwable) {
                        return Observable.error(throwable);
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .debounce(500, TimeUnit.MILLISECONDS)
                .subscribe(new Subscriber<ArrayList<Event>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        getEventsCallback.onError(new NetworkError(e));

                    }

                    @Override
                    public void onNext(ArrayList<Event> cityListResponse) {
                        getEventsCallback.onSuccess(cityListResponse);

                    }
                });

    }

    public Subscription timeline(String auth, String userId, final GetTimelineCallback getEventsCallback) {
        return networkService.timeline(auth, userId)
                .onErrorResumeNext(new Func1<Throwable, Observable<? extends ArrayList<Timeline>>>() {
                    @Override
                    public Observable<? extends ArrayList<Timeline>> call(Throwable throwable) {
                        return Observable.error(throwable);
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .debounce(500, TimeUnit.MILLISECONDS)
                .subscribe(new Subscriber<ArrayList<Timeline>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        getEventsCallback.onError(new NetworkError(e));

                    }

                    @Override
                    public void onNext(ArrayList<Timeline> cityListResponse) {
                        getEventsCallback.onSuccess(cityListResponse);

                    }
                });

    }

    public Subscription timelineBefore(String auth, String userId, String beforeId,final GetTimelineCallback getEventsCallback) {
        return networkService.afterTimeline(auth, userId, beforeId)
                .onErrorResumeNext(new Func1<Throwable, Observable<? extends ArrayList<Timeline>>>() {
                    @Override
                    public Observable<? extends ArrayList<Timeline>> call(Throwable throwable) {
                        return Observable.error(throwable);
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .debounce(500, TimeUnit.MILLISECONDS)
                .subscribe(new Subscriber<ArrayList<Timeline>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        getEventsCallback.onError(new NetworkError(e));

                    }

                    @Override
                    public void onNext(ArrayList<Timeline> cityListResponse) {
                        getEventsCallback.onSuccess(cityListResponse);

                    }
                });

    }

    public Subscription getUsers(String auth, String companyId, String name, final GetUserCallback callback) {
        Observable<ArrayList<User>> combined = Observable.zip(getUsers(auth, companyId, name), getTeams(auth, companyId, name), new Func2<ArrayList<User>, ArrayList<User>, ArrayList<User>>() {
            @Override
            public ArrayList<User> call(ArrayList<User> users, ArrayList<User> teams) {
                ArrayList<User> arrayList = new ArrayList<>();
                for (User user : users) {
                    user.setType("user");
                }
                for (User team : teams) {
                    team.setType("team");
                }
                arrayList.addAll(users);
                arrayList.addAll(teams);
                return arrayList;
            }
        });

        return combined
                .onErrorResumeNext(new Func1<Throwable, Observable<? extends ArrayList<User>>>() {
                    @Override
                    public Observable<? extends ArrayList<User>> call(Throwable throwable) {
                        return Observable.error(throwable);
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .debounce(500, TimeUnit.MILLISECONDS)
                .subscribe(new Subscriber<ArrayList<User>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.onError(new NetworkError(e));

                    }

                    @Override
                    public void onNext(ArrayList<User> cityListResponse) {
                        callback.onSuccess(cityListResponse);

                    }
                });
    }

    public interface GetUserCallback {
        void onSuccess(ArrayList<User> userResponse);

        void onError(NetworkError networkError);
    }

    public interface GetEventsCallback {
        void onSuccess(ArrayList<Event> response);

        void onError(NetworkError networkError);
    }

    public interface GetTimelineCallback {
        void onSuccess(ArrayList<Timeline> response);

        void onError(NetworkError networkError);
    }
}