package br.com.diegoferreiracaetano.petshop.data.storage.interfaces;

public enum StorageEvents {

    LOADING("loading"), SUCCESS("success"), ERROR("error");

    private final String valueStatus;

    StorageEvents(String status) {
        valueStatus = status;
    }

    public String getValue() {
        return valueStatus;
    }
}
