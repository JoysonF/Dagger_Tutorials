package com.example.daggermitch.ui.auth;

import android.util.Log;

import androidx.lifecycle.ViewModel;

import javax.inject.Inject;

public class AuthViewModel extends ViewModel {

    private static final String TAG = AuthViewModel.class.getSimpleName();

    @Inject
    public AuthViewModel() {
        Log.d(TAG, "AuthViewModel: is working");
    }

}
