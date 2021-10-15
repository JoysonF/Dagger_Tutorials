package com.example.daggermitch.di;

import android.app.Application;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    @Provides
    static String getSomeString() {
        return "Fernandes";
    }

    @Provides
    static int isAppNull(Application application) {
        if (application == null) {
            return 1;
        } else {
            return 0;
        }
    }
}
