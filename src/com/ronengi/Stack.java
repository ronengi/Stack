package com.ronengi;

/**
 * Created by stimpy on 7/31/16.
 */
public interface Stack<T> extends Iterable<T> {
    public void push(T item);
    public T pop();
    public boolean isEmpty();
    public int size();
}
