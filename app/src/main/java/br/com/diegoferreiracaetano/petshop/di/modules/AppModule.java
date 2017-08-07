package br.com.diegoferreiracaetano.petshop.di.modules;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import br.com.diegoferreiracaetano.petshop.AppApplication;
import dagger.Module;
import dagger.Provides;

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
