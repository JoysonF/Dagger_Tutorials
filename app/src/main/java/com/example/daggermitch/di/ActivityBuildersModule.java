package com.example.daggermitch.di;

import com.example.daggermitch.di.auth.AuthViewModelsModule;
import com.example.daggermitch.ui.auth.AuthActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/*
A abstract class that declares the clients .i.e Activityies or Fragments or any class that needs dependencies
 */
@Module
public abstract class ActivityBuildersModule {

    @ContributesAndroidInjector(
            modules = {
                    AuthViewModelsModule.class
            }
    )
    abstract AuthActivity contributeAuthActivity();

}
