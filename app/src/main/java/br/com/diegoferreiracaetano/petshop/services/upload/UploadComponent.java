package br.com.diegoferreiracaetano.petshop.services.upload;

import br.com.diegoferreiracaetano.petshop.ApplicationComponent;
import br.com.diegoferreiracaetano.petshop.data.database.interfaces.RepositoryComponent;
import br.com.diegoferreiracaetano.petshop.data.storage.interfaces.StorageComponent;
import dagger.Component;

@Component(dependencies = {ApplicationComponent.class, RepositoryComponent.class, StorageComponent.class}, modules = UploadModule.class)
public interface UploadComponent {



}
