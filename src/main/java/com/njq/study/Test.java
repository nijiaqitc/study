package com.njq.study;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author: nijiaqi
 * @date: 2019/5/20
 */
public class Test {
    public static void main(String[] args) {
//        List<A> list = new ArrayList<>();
//        for (int i = 0;i<10;i++){
//            list.add(new A(new Random().nextInt(100)));
//        }
//        List<A> l = list.stream().sorted(Comparator.comparing(A::getV).reversed()).collect(Collectors.toList());
//        for(int i=0;i<l.size();i++){
//            System.out.println(l.get(i).getV());
//        }
//        Integer a = null;sdsdsd
//        System.out.println(a==1);
//        Integer a = 240;
//        System.out.println(Integer.toBinaryString(a));
//        System.out.println(137&224);
        new HashMap<>(2).put("111", "222");

        int cap = 2;
        int n = cap - 1;
        System.out.println(n>>>1);
        n |= n >>> 1;

        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        System.out.println(n);
    }


    static class  A{
        int v;

        public A(int v) {
            this.v = v;
        }

        public int getV() {
            return v;
        }

        public void setV(int v) {
            this.v = v;
        }
    }





    static class MyLinkedList {

        private class Node{
            private int val;
            private Node next;
            public Node(int val, Node next) {
                this.val = val;
                this.next = next;
            }
            public void setNext(Node n){
                this.next = n;
            }
        }
        private Node head;

        /** Initialize your data structure here. */
        public MyLinkedList() {

        }

        /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
        public int get(int index) {
            if(index == 0){
                return head.val;
            }
            int num = 0;
            Node n = head;
            while (n != null){
                if(index ==num){
                    return n.val;
                }
                n=n.next;
                num++;
            }
            return -1;
        }

        /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
        public void addAtHead(int val) {
            if(head == null){
                head = new Node(val, null);
                return;
            }
            Node n = new Node(val,null);
            n.setNext(head);
            head = n;
        }

        /** Append a node of value val to the last element of the linked list. */
        public void addAtTail(int val) {
            Node n =head;
            while (n.next != null){
                n=n.next;
            }
            n.setNext(new Node(val,null));
        }

        /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
        public void addAtIndex(int index, int val) {
            Node newNode = new Node(val,null );
            if(index == 0){
                newNode.next= head;
                head=newNode;
                return;
            }
            int num = 0;
            index -=1;
            Node n = head;
            while(n.next != null){
                if(index == num){
                    newNode.next=n.next;
                    n.next=newNode;
                    break;
                }
                num++;
                n=n.next;
            }
        }

        /** Delete the index-th node in the linked list, if the index is valid. */
        public void deleteAtIndex(int index) {
            int num = 0;
            Node n = head;
            Node temp;
            if(index == 0){
                temp = n.next;
                head.next = null;
                head=temp;
                return ;
            }
            while (n.next != null){
                if(index-1 == num){
                    temp=n.next.next;
                    n.next.next=null;
                    n.next=temp;
                }
                num++;
                n=n.next;
            }
        }
    }


}
