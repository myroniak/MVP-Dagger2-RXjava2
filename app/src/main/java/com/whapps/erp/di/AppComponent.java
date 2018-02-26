package com.whapps.erp.di;


import com.whapps.erp.ui.activities.MainActivity;
import com.whapps.erp.ui.activities.SecondActivity;
import com.whapps.erp.ui.fragments.FirstFragment;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by ennur on 6/28/16.
 */
@Singleton
@Component(modules = {NetworkModule.class, AppModule.class})
public interface AppComponent {
    void inject(MainActivity mainActivityActivity);
    void inject(SecondActivity secondActivity);
    void inject(FirstFragment firstFragment);
}
