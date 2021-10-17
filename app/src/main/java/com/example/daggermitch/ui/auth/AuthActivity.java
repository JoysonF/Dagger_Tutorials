package com.example.daggermitch.ui.auth;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import androidx.lifecycle.ViewModelProvider;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.request.RequestOptions;
import com.example.daggermitch.R;
import com.example.daggermitch.viewmodels.ViewModelProviderFactory;
import javax.inject.Inject;
import dagger.android.support.DaggerAppCompatActivity;

public class AuthActivity extends DaggerAppCompatActivity {

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);
        setLogo();
        authViewModel = new ViewModelProvider(this, providerFactory).get(AuthViewModel.class);
        Log.v("sdagsd", "" + requestOptions);

    }

    private void setLogo() {
        requestManager.load(logo).into((ImageView) findViewById(R.id.login_logo));
    }
}