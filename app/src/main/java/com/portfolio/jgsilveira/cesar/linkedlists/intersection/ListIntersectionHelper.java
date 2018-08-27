package com.portfolio.jgsilveira.cesar.linkedlists.intersection;

import android.support.annotation.Nullable;

import com.portfolio.jgsilveira.cesar.linkedlists.mailprocessor.Node;

final class ListIntersectionHelper {

    private ListIntersectionHelper() {  }

    public static boolean nonNull(@Nullable Object value) {
        return value != null;
    }

    private static int getCount(Node head) {
        int count = 0;
        Node current = head;
        while (nonNull(current)) {
            count++;
            current = current.getNext();
        }
        return count;
    }

    @Nullable
    public static Object getIntersectionNode(Node firstHead, Node secondHead) {
        int nodes1 = getCount(firstHead);
        int nodes2 = getCount(secondHead);
        int differenceCount = nodes1 - nodes2;
        differenceCount = Math.abs(differenceCount);
        Node current1 = firstHead;
        Node current2 = secondHead;
        for (int i = 0; i < differenceCount; i++) {
            if (current1 == null) {
                return null;
            }
            current1 = current1.getNext();
        }
        while (nonNull(current1) && nonNull(current2)) {
            Object data1 = current1.getData();
            Object data2 = current2.getData();
            String message1 = data1.toString();
            String message2 = data2.toString();
            if (message1.equals(message2)) {
                return data1;
            }
            current1 = current1.getNext();
            current2 = current2.getNext();
        }
        return null;
    }

}
