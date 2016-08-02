package com.ronengi;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by stimpy on 7/31/16.
 */
public class LinkedListStack<T> implements Stack<T> {

    private Node first;
    private int N;


    public LinkedListStack() {
        first = null;
        N = 0;
    }


    @Override
    public void push(T item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        ++N;
    }


    @Override
    public T pop() {
        if (isEmpty())
            throw new NoSuchElementException("Stack underflow");
        T item = first.item;
        first = first.next;
        --N;
        return item;
    }


    @Override
    public boolean isEmpty() {
        return first == null;
    }


    @Override
    public int size() {
        return N;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (T i : this)
            sb.append("[").append(i).append("]").append("\t");
        return sb.toString();
    }


    @Override
    public Iterator<T> iterator() {
        return new LinkedListIterator();
    }


    private class Node {
        private T item;
        private Node next;
    }


    private class LinkedListIterator implements Iterator<T> {

        private Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            if (!hasNext())
                throw new NoSuchElementException();
            T item = current.item;
            current = current.next;
            return item;
        }

    }

}
