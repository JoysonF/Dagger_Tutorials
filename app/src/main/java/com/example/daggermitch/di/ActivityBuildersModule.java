package com.example.daggermitch.di;

import com.example.daggermitch.AuthActivity;

import dagger.Module;
import dagger.Provides;
import dagger.android.ContributesAndroidInjector;

/*
A abstract class that declares the clients .i.e Activityies or Fragments or any class that needs dependencies
 */
@Module
public abstract class ActivityBuildersModule {

    @ContributesAndroidInjector
    abstract AuthActivity contributeAuthActivity();

}
