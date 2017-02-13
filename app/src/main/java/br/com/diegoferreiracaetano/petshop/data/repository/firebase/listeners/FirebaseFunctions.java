package br.com.diegoferreiracaetano.petshop.data.repository.firebase.listeners;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.GenericTypeIndicator;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import io.reactivex.functions.Function;

public class FirebaseFunctions<T> {

    private final Class<T> type;

    public FirebaseFunctions(Class<T> type) {
        this.type = type;
    }

    public Class<T> getMyType() {
        return type;
    }


    public Function<DataSnapshot, List<T>> getList() {
        return dataSnapshot -> {
            List<T> list = new ArrayList<>();
            if (dataSnapshot.hasChildren()) {
                Iterable<DataSnapshot> children = dataSnapshot.getChildren();
                for (DataSnapshot child : children) {
                    list.add(child.getValue(getMyType()));
                }
            }
            return list;
        };
    }

    public Function<DataSnapshot, T> get() {
        return dataSnapshot -> dataSnapshot.getValue(getMyType());
    }

    public Function<DataSnapshot, Set<T>> getSet() {
        return dataSnapshot -> {
            GenericTypeIndicator<Map<T, Boolean>> map = new GenericTypeIndicator<Map<T, Boolean>>() {};
            Map<T, Boolean> customers = dataSnapshot.getValue(map);
            return customers.keySet();
        };
    }

}
