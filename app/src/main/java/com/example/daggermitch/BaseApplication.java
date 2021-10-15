package com.example.daggermitch;

import com.example.daggermitch.di.DaggerAppComponent;
import dagger.android.AndroidInjector;
import dagger.android.support.DaggerApplication;

/*
Behaves as a client, where we can inject dependencies from the service (AppComponent)
 */
public class BaseApplication extends DaggerApplication {

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return DaggerAppComponent.builder().application(this).build();
    }
}
