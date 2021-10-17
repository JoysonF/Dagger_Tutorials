package com.example.daggermitch.di.auth;

import com.example.daggermitch.network.auth.AuthApi;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/*
This module will provide dependencies to the AuthActivity (AuthComponent)
 */
@Module
public class AuthModule {

    @Provides
    static AuthApi provideAuthApi(Retrofit retrofit) {
        return retrofit.create(AuthApi.class);
    }

}
