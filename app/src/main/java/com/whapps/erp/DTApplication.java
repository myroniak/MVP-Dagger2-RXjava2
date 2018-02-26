package com.whapps.erp;

import android.app.Application;

import com.whapps.erp.di.AppComponent;
import com.whapps.erp.di.AppModule;
import com.whapps.erp.di.DaggerAppComponent;
import com.whapps.erp.di.NetworkModule;

import java.io.File;

/**
 * Created by roman on 25.02.18.
 */

public class DTApplication extends Application {

    private static DTApplication INSTANCE;
    private static AppComponent appComponent;
    private File cacheFile;

    @Override
    public void onCreate() {
        super.onCreate();

        INSTANCE = this;
        cacheFile = new File(getCacheDir(), "responses");
        appComponent = buildComponent();
    }

    public static AppComponent getComponent() {
        return appComponent;
    }

    protected AppComponent buildComponent() {
        return DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .networkModule(new NetworkModule(cacheFile))
                .build();
    }

    public static DTApplication getInstance() {
        return INSTANCE;
    }


}
