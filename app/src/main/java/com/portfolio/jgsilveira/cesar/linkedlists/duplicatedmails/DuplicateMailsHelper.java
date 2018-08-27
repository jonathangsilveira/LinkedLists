package com.portfolio.jgsilveira.cesar.linkedlists.duplicatedmails;

import com.portfolio.jgsilveira.cesar.linkedlists.mailprocessor.Node;

import java.util.HashSet;

public final class DuplicateMailsHelper {

    private DuplicateMailsHelper() {  }

    public static void removeDuplicatedOnes(Node head) {
        Node previous = null;
        Node current = head;
        HashSet<String> mailContent = new HashSet<>();
        while (current != null) {
            Object data = current.getData();
            String content = data.toString();
            if (mailContent.contains(content)) {
                if (previous != null) {
                    previous.setNext(current.getNext());
                }
            } else {
                previous = current;
                mailContent.add(content);
            }
            current = current.getNext();
        }
    }

    static boolean hasDuplicated(Node head) {
        if (head == null) {
            return false;
        }
        Node current = head;
        HashSet<String> mailContent = new HashSet<>();
        while (current != null) {
            Object data = current.getData();
            String content = data.toString();
            if (mailContent.contains(content)) {
                return true;
            } else {
                mailContent.add(content);
            }
            current = current.getNext();
        }
        return false;
    }

}
