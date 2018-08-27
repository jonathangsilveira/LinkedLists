package com.portfolio.jgsilveira.cesar.linkedlists.mailprocessor;

public class Node {

    private Object mData;

    private Node mNext;

    public Node(String message) {
        mData = message;
    }

    public Node getNext() {
        return mNext;
    }

    public void setNext(Node next) {
        mNext = next;
    }

    public Object getData() {
        return mData;
    }

}
