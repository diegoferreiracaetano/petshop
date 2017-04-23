package br.com.diegoferreiracaetano.petshop.data.storage.firebase;

import com.google.firebase.storage.StorageReference;

import br.com.diegoferreiracaetano.petshop.data.storage.interfaces.StorageInterface;

public class StorageFirebase implements StorageInterface {

    private static final String PNG = ".png";
    private final StorageReference mRootReference;


    public StorageFirebase(StorageReference storageReference) {
        mRootReference = storageReference;
    }

/*?
    @Override
    public Observable<File> saveFileDocument(String nameFile, String collaboratorId, String documentId, String uri) {

        String path = COLLABORATORS + "/" + collaboratorId + "/" + documentId;

        File file = new File(nameFile, uri, documentId, collaboratorId);

        StorageReference reference = mRootReference.child(path + "/" + file.getId() + PNG);

        UploadTask uploadTask = reference.putFile(Uri.parse(uri));

        return uploadFile(uploadTask, file);
    }

    @Override
    public Observable<File> returnFileDocument(File file) {


        String path = COLLABORATORS + "/" + file.getCollaboratorId() + "/" + file.getDocumentId();

        StorageReference reference = mRootReference.child(path + "/" + file.getId() + PNG);

        UploadTask uploadTask = reference.putFile(Uri.parse(file.getUri()));

        if (!file.getSession().isEmpty())
            uploadTask = reference.putFile(Uri.parse(file.getUri()), new StorageMetadata.Builder().build(), Uri.parse(file.getSession()));

        return uploadFile(uploadTask, file);
    }

    @Override
    public Observable<File> saveFileDirect(String nameFile, String customerId, String uri) {
        String path = ATTACHMENTS + "/" + CUSTOMERS + "/" + customerId + "/";

        File file = new File(nameFile, uri);

        StorageReference reference = mRootReference.child(path + "/" + file.getId() + PNG);

        UploadTask uploadTask = reference.putFile(Uri.parse(uri));

        return uploadFile(uploadTask, file);
    }

    @Override
    public Observable<File> uploadFile(final UploadTask uploadTask, final File file) {

        return Observable.create(emitter -> {

            uploadTask
                    .addOnSuccessListener(taskSnapshot -> {

                        String uriImage = taskSnapshot.getDownloadUrl() != null ?
                                taskSnapshot.getDownloadUrl().toString() : "";

                        file.setUpload(StorageEvents.SUCCESS.getValue())
                                .setUri(uriImage).setSession("");
                        emitter.onNext(file);
                    })
                    .addOnProgressListener(taskSnapshot -> {

                        String uriSession = taskSnapshot.getUploadSessionUri() != null ?
                                taskSnapshot.getUploadSessionUri().toString() : "";

                        file.setUpload(StorageEvents.LOADING.getValue())
                                .setSession(uriSession);
                        emitter.onNext(file);
                    })
                    .addOnFailureListener(e -> {
                        file.setUpload(StorageEvents.ERROR.getValue());
                        emitter.onNext(file);
                    })
                    .addOnCompleteListener(v -> emitter.onComplete());

        });
    }

*/
}


