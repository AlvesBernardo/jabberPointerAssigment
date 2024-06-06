package com.softwarequality.jabberpoint.utils;

import java.util.ArrayList;
import java.util.List;

public class CustomObservable<T> {
    private final List<CustomObserver<T>> observers = new ArrayList<>();

    public void addObserver(CustomObserver<T> observer) {
        observers.add(observer);
    }

    public void removeObserver(CustomObserver<T> observer) {
        observers.remove(observer);
    }

    public void notifyObservers(T data) {
        for (CustomObserver<T> observer : observers) {
            observer.update(data);
        }
    }
}
