package br.com.diegoferreiracaetano.petshop.services.upload;

import dagger.Module;
import dagger.Provides;

@Module
public class UploadModule {

    private UploadContract.Service mService;

    public UploadModule(UploadContract.Service service) {
        this.mService = service;
    }


    @Provides
    UploadContract.Service getUploadService() {
        return mService;
    }

}
