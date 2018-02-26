package com.whapps.erp.di;

import android.content.Context;
import android.support.annotation.NonNull;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by roman on 25.02.18.
 */

@Module
public class AppModule {

    private Context applicationContext;

    public AppModule(@NonNull Context applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Provides
    @Singleton
    Context provideContext() {
        return applicationContext;
    }
}
