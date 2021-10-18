package com.example.daggermitch.ui.auth;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.lifecycle.ViewModelProvider;

import com.bumptech.glide.RequestManager;
import com.bumptech.glide.request.RequestOptions;
import com.example.daggermitch.R;
import com.example.daggermitch.viewmodels.ViewModelProviderFactory;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

public class AuthActivity extends DaggerAppCompatActivity implements View.OnClickListener {

    private static final String TAG = "AuthActivity";

    @Inject
    Drawable logo;

    @Inject
    RequestManager requestManager;

    @Inject
    RequestOptions requestOptions;

    @Inject
    ViewModelProviderFactory providerFactory;

    private AuthViewModel authViewModel;

    private EditText userId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);
        userId = findViewById(R.id.user_id_input);
        findViewById(R.id.login_button).setOnClickListener(this);
        setLogo();
        authViewModel = new ViewModelProvider(this, providerFactory).get(AuthViewModel.class);
        Log.v("sdagsd", "" + requestOptions);
        subscribeObservers();
    }

    private void setLogo() {
        requestManager.load(logo).into((ImageView) findViewById(R.id.login_logo));
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.login_button) {
            attemptLogin();
        }
    }

    private void subscribeObservers() {
        authViewModel.observeUser().observe(this, user -> {
            if (user != null) {
                Log.d(TAG, "onChanged: " + user.getEmail());
            }
        });
    }

    private void attemptLogin() {
        if (TextUtils.isEmpty(userId.getText().toString())) {
            return;
        }
        authViewModel.authenticateUserWithId(Integer.parseInt(userId.getText().toString()));
    }
}