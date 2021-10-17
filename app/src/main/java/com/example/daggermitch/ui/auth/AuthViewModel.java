package com.example.daggermitch.ui.auth;

import android.util.Log;

import androidx.lifecycle.ViewModel;

import com.example.daggermitch.network.auth.AuthApi;

import javax.inject.Inject;

public class AuthViewModel extends ViewModel {

    private static final String TAG = AuthViewModel.class.getSimpleName();

    private AuthApi authApi;

    @Inject
    public AuthViewModel(AuthApi authApi) {
        this.authApi = authApi;
        Log.d(TAG, "AuthViewModel: is working");

        if (this.authApi == null) {
            Log.d(TAG, "AuthViewModel: is null");
        } else {
            Log.d(TAG, "AuthViewModel: is not null");
        }
    }

}
