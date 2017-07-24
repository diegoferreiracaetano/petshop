package br.com.diegoferreiracaetano.petshop;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import dagger.Module;
import dagger.Provides;
import static android.os.Build.MODEL;

@Module
public class AppModule {

    @Provides Context provideContext(AppApplication application) {
        return application.getApplicationContext();
    }

    @Provides
    public SharedPreferences provideSharedPreferences(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context);
    }
}
