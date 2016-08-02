package com.ronengi;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by stimpy on 7/31/16.
 */
public class ArrayStack<T> implements Stack<T> {

    private T[] s;
    private int N;


    public ArrayStack() {
        s = (T[]) new Object[1];
        N = 0;
    }


    @Override
    public void push(T item) {
        if (N == s.length)
            resize(2 * s.length);
        s[N] = item;
        ++N;
    }


    @Override
    public T pop() {
        if (isEmpty())
            throw new NoSuchElementException("Stack underflow");
        --N;
        T item = s[N];
        s[N] = null;
        if (N > 0  &&  N <= (s.length / 4) )
            resize(s.length / 2);
        return item;
    }


    @Override
    public boolean isEmpty() {
        return N == 0;
    }


    @Override
    public int size() {
        return N;
    }


    @Override
    public Iterator<T> iterator() {
        return new ArrayStackIterator();
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (T i : this)
            sb.append("[").append(i).append("]").append("\t");
        return sb.toString();
    }

    public String toStringAsIs() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length; ++i)
            sb.append("[").append(s[i]).append("]").append("\t");
        return sb.toString();
    }


    private void resize(int capacity) {
        assert capacity >= N;
        T[] copy = (T[]) new Object[capacity];
        for (int i = 0; i < N; ++i)
            copy[i] = s[i];
        s = copy;
    }


    private class ArrayStackIterator implements Iterator<T> {

        private int i = N;

        @Override
        public boolean hasNext() {
            return i > 0;
        }

        @Override
        public T next() {
            if (!hasNext())
                throw new NoSuchElementException();
            --i;
            T item = s[i];
            return item;
        }

    }


}
