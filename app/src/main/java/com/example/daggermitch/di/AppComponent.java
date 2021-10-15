package com.example.daggermitch.di;

import android.app.Application;

import com.example.daggermitch.BaseApplication;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

//BaseApplication is a client of the Appcomponent (Service), if will fetch dependencies from the Appcomponent
@Component(
        //When we add modules here, dagger will create implementation class for the AppComponent
        modules = {
                AndroidSupportInjectionModule.class
        }
)
public interface AppComponent extends AndroidInjector<BaseApplication> {

    //use a builder pattern to create an object
    @Component.Builder
    interface Builder {

        //To bind an object to the AppComponent, i.e provide a object into the dagger graph, while the Appcomponent is created
        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }

}
