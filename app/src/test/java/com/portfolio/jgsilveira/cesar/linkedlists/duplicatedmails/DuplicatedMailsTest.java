package com.portfolio.jgsilveira.cesar.linkedlists.duplicatedmails;

import com.portfolio.jgsilveira.cesar.linkedlists.mailprocessor.Node;

import org.junit.Assert;
import org.junit.Test;

import static com.portfolio.jgsilveira.cesar.linkedlists.duplicatedmails.DuplicateMailsHelper.hasDuplicated;
import static com.portfolio.jgsilveira.cesar.linkedlists.duplicatedmails.DuplicateMailsHelper.removeDuplicatedOnes;

public class DuplicatedMailsTest {

    @Test
    public void removeDuplicatedOnes_withoutDuplicated() {
        String mail1 = "first message";
        String mail2 = "new offers to you! today only!";
        String mail3 = "warning! don't miss the opportunity";
        String mail4 = "new offers to you! today only!";
        String mail5 = "cheap travels for you";
        String mail6 = "warning! don't miss the opportunity";
        String mail7 = "what will you do today?";
        String mail8 = "dinner starts at 9pm. don't forget!";
        String mail9 = "Intern communications!";
        String mail10 = "warning! don't miss the opportunity";
        Node head = new Node(mail1);
        head.setNext(new Node(mail2));
        head.getNext().setNext(new Node(mail3));
        head.getNext().getNext().setNext(new Node(mail4));
        head.getNext().getNext().getNext().setNext(new Node(mail5));
        head.getNext().getNext().getNext().getNext().setNext(new Node(mail6));
        head.getNext().getNext().getNext().getNext().getNext().setNext(new Node(mail7));
        head.getNext().getNext().getNext().getNext().getNext().getNext().setNext(new Node(mail8));
        head.getNext().getNext().getNext().getNext().getNext().getNext().getNext()
                .setNext(new Node(mail9));
        head.getNext().getNext().getNext().getNext().getNext().getNext().getNext().getNext()
                .setNext(new Node(mail10));

        removeDuplicatedOnes(head);

        Assert.assertFalse(hasDuplicated(head));
    }

    @Test
    public void removeDuplicatedOnes_withDuplicated() {
        String mail1 = "first message";
        String mail2 = "new offers to you! today only!";
        String mail3 = "warning! don't miss the opportunity";
        String mail4 = "new offers to you! today only!";
        String mail5 = "cheap travels for you";
        String mail6 = "warning! don't miss the opportunity";
        String mail7 = "what will you do today?";
        String mail8 = "dinner starts at 9pm. don't forget!";
        String mail9 = "Intern communications!";
        String mail10 = "warning! don't miss the opportunity";
        Node head = new Node(mail1);
        head.setNext(new Node(mail2));
        head.getNext().setNext(new Node(mail3));
        head.getNext().getNext().setNext(new Node(mail4));
        head.getNext().getNext().getNext().setNext(new Node(mail5));
        head.getNext().getNext().getNext().getNext().setNext(new Node(mail6));
        head.getNext().getNext().getNext().getNext().getNext().setNext(new Node(mail7));
        head.getNext().getNext().getNext().getNext().getNext().getNext().setNext(new Node(mail8));
        head.getNext().getNext().getNext().getNext().getNext().getNext().getNext()
                .setNext(new Node(mail9));
        head.getNext().getNext().getNext().getNext().getNext().getNext().getNext().getNext()
                .setNext(new Node(mail10));

        Assert.assertTrue(hasDuplicated(head));
    }

}
