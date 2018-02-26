package com.whapps.erp.domain;

import com.whapps.erp.domain.model.Event;
import com.whapps.erp.domain.model.Timeline;
import com.whapps.erp.domain.model.User;

import java.util.ArrayList;

import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by ennur on 6/25/16.
 */
public interface ApiService {

    @GET("company/{company_id}/users")
    Observable<ArrayList<User>> searchUsers(@Header("Authorization") String auth, @Path("company_id") String companyId, @Query("name") String name);

    @GET("company/{company_id}/groups")
    Observable<ArrayList<User>> searchTeams(@Header("Authorization") String auth, @Path("company_id") String companyId, @Query("name") String name);

    @GET("user/{user_id}/events/{year}/{month}/{day}")
    Observable<ArrayList<Event>> events(@Header("Authorization") String auth, @Path("user_id") String userId, @Path("year") int year, @Path("month") int month,
                                        @Path("day") int day);

    @GET("user/{user_id}/timeline")
    Observable<ArrayList<Timeline>> timeline(@Header("Authorization") String auth, @Path("user_id") String userId);

    @GET("user/{user_id}/timeline")
    Observable<ArrayList<Timeline>> afterTimeline(@Header("Authorization") String auth, @Path("user_id") String userId, @Query("before_timeline_id") String afterTimelineId);


}
