package com.ronengi;

/**
 * Created by stimpy on 7/31/16.
 */
public class StackClient {
    public static void main(String[] args) {

        Stack<String> st = new LinkedListStack<>();  // ArrayStack<>();


        st.push("this");
        st.push("is");
        st.push("a");
        st.push("stack");
        st.push("of");
        st.push("strings");

        while (!st.isEmpty())
            System.out.println(st.pop());

    }
}
