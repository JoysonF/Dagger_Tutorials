package com.example.daggermitch.di.auth;

import androidx.lifecycle.ViewModel;

import com.example.daggermitch.di.ViewModelKey;
import com.example.daggermitch.ui.auth.AuthViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
    public abstract class AuthViewModelsModule {

    //INjects viewmodels
    @Binds
    @IntoMap
    @ViewModelKey(AuthViewModel.class)
    public abstract ViewModel bindAuthViewModel(AuthViewModel authViewModel);

}
