package com.portfolio.jgsilveira.cesar.linkedlists.intersection;

import com.portfolio.jgsilveira.cesar.linkedlists.mailprocessor.Node;

import org.junit.Assert;
import org.junit.Test;

import static com.portfolio.jgsilveira.cesar.linkedlists.intersection.ListIntersectionHelper.getIntersectionNode;
import static com.portfolio.jgsilveira.cesar.linkedlists.intersection.ListIntersectionHelper.nonNull;

public class IntersectionTest {

    @Test
    public void intersection_intersectionNodeFound() {
        Node firstHead = getFirstHead();
        Node secondHead = getSecondHead();
        String expectedContent = "cheap travels for you";

        Object intersectionNode = getIntersectionNode(firstHead, secondHead);

        Assert.assertTrue(nonNull(intersectionNode));
        Assert.assertEquals(expectedContent, intersectionNode.toString());
    }

    private Node getFirstHead() {
        String mail1 = "first message";
        String mail2 = "new offers to you! today only!";
        String mail3 = "warning! don't miss the opportunity";
        String mail4 = "cheap travels for you";
        String mail5 = "Barbecue tomorrow! Don't forget to confirm your presence!";
        String mail6 = "Subscribed channels notifications";
        String mail7 = "what will you do today?";
        Node head = new Node(mail1);
        head.setNext(new Node(mail2));
        head.getNext().setNext(new Node(mail3));
        head.getNext().getNext().setNext(new Node(mail4));
        head.getNext().getNext().getNext().setNext(new Node(mail5));
        head.getNext().getNext().getNext().getNext().setNext(new Node(mail6));
        head.getNext().getNext().getNext().getNext().getNext().setNext(new Node(mail7));
        return head;
    }

    private Node getSecondHead() {
        String mail1 = "New offers";
        String mail2 = "Aliexpress - Pending items in your car";
        String mail3 = "cheap travels for you";
        String mail4 = "Barbecue tomorrow! Don't forget to confirm your presence!";
        String mail5 = "Subscribed channels notifications";
        String mail6 = "what will you do today?";
        Node head = new Node(mail1);
        head.setNext(new Node(mail2));
        head.getNext().setNext(new Node(mail3));
        head.getNext().getNext().setNext(new Node(mail4));
        head.getNext().getNext().getNext().setNext(new Node(mail5));
        head.getNext().getNext().getNext().getNext().setNext(new Node(mail6));
        return head;
    }

}
