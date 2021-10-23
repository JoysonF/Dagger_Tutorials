package com.example.daggermitch.ui.auth;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.LiveDataReactiveStreams;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.ViewModel;

import com.example.daggermitch.SessionManager;
import com.example.daggermitch.models.User;
import com.example.daggermitch.network.auth.AuthApi;

import javax.inject.Inject;

import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class AuthViewModel extends ViewModel {

    private static final String TAG = AuthViewModel.class.getSimpleName();

    private AuthApi authApi;

    SessionManager sessionManager;

    private MediatorLiveData<AuthResource<User>> authUser = new MediatorLiveData<>();


    @Inject
    public AuthViewModel(AuthApi authApi, SessionManager sessionManager) {
        this.authApi = authApi;
        this.sessionManager = sessionManager;
        Log.d(TAG, "AuthViewModel: is working");

    }

    public void authenticateUserWithId(int userId) {

        Log.d(TAG, "authenticateUserWithId: ");
        sessionManager.authenticateWithId(queryUserId(userId));
    }

    private LiveData<AuthResource<User>> queryUserId(int userId) {
        Flowable<AuthResource<User>> authResourceFlowable = authApi.getUser(userId)

                .onErrorReturn(new Function<Throwable, User>() {
                    @Override
                    public User apply(Throwable throwable) throws Exception {
                        Log.d("TTTT", "error apply: ");
                        User errorUser = new User(1, "testuser", "test@gmail.com", "testwebsite");
                        errorUser.setId(-1);
                        return errorUser;
                    }
                })

                .map(new Function<User, AuthResource<User>>() {
                    @NonNull
                    @Override
                    public AuthResource<User> apply(@NonNull User user) throws Exception {
                        Log.d("TTTT", "map apply: " + user.getEmail());
                        if (user.getId() == -1) {
                            return AuthResource.error("Could not authenticate", null);
                        }
                        return AuthResource.authenticated(user);
                    }
                })
                .subscribeOn(Schedulers.io());

        return LiveDataReactiveStreams.fromPublisher(authResourceFlowable);
    }

    public LiveData<AuthResource<User>> observeAuthState() {
        return sessionManager.getAuthUser();
    }
}
