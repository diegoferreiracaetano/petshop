package br.com.diegoferreiracaetano.petshop.services.upload;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

import javax.inject.Inject;

import br.com.diegoferreiracaetano.petshop.AppApplication;

import static dagger.internal.Preconditions.checkNotNull;

public class UploadService extends Service implements UploadContract.Service {

    @Inject
    UploadPresenter mUploadPresenter;

    private UploadContract.Presenter mPresenter;

    public UploadService() {
        initializeDagger();
    }

    private void initializeDagger() {

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        return Service.START_NOT_STICKY;
    }

    @Override
    public void setPresenter(@NonNull UploadContract.Presenter presenter) {
        mPresenter = checkNotNull(presenter, "the presenter can not be null");
    }

    @Override
    public void onCreate() {
        super.onCreate();
       // mPresenter.start();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        //mPresenter.destroy();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

}
