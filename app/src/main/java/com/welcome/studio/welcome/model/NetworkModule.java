package com.welcome.studio.welcome.model;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.firebase.storage.FirebaseStorage;
import com.welcome.studio.welcome.model.repository.FirebaseRepository;
import com.welcome.studio.welcome.model.repository.FirebaseRepositoryImpl;
import com.welcome.studio.welcome.model.repository.LocationRepository;
import com.welcome.studio.welcome.model.repository.LocationRepositoryImpl;
import com.welcome.studio.welcome.model.repository.UserRepository;
import com.welcome.studio.welcome.model.repository.UserRepositoryImpl;
import com.welcome.studio.welcome.util.Constance;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import pl.charmas.android.reactivelocation.ReactiveLocationProvider;

/**
 * Created by @mistreckless on 28.11.2016. !
 */
@Module
public class NetworkModule {

    @Singleton
    @Provides
    UserRepository provideUserRepository(RestApi restApi, SharedPreferences sharedPreferences, Context context) {
        return new UserRepositoryImpl(restApi, sharedPreferences, context);
    }

    @Singleton
    @Provides
    RestApi provideRestApi() {
        return RestApiCreator.getRestApi();
    }

    @Singleton
    @Provides
    FirebaseRepository provideFirebaseRepository() {
        return new FirebaseRepositoryImpl(FirebaseStorage.getInstance(),
                FirebaseStorage.getInstance().getReferenceFromUrl(Constance.URL.FIREBASE_STORAGE));
    }

    @Singleton
    @Provides
    LocationRepository provideLocationRepository(ReactiveLocationProvider locationProvider){
        return new LocationRepositoryImpl(locationProvider);
    }

    @Singleton
    @Provides
    ReactiveLocationProvider provideReactiveLocationProvider(Context context){
        return new ReactiveLocationProvider(context);
    }
}
