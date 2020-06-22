package com.aaron.javapractice;

import java.util.LinkedList;
import java.util.Stack;

/**
 * ${DESCRIPTION}
 *
 * @author Ricky Fung
 */
public class LinkedNodeDemo {

    public static void main(String[] args) {

        LinkedNodeDemo demo = new LinkedNodeDemo();
        demo.test();
    }

    public void test() {

        Node head = initLinkedList(5);

        printLinkedList(head);

        System.out.println("**************");

        //反转链表
        Node node = reverseLinkedList(head);
        printLinkedList(node);
    }

    /**原地反转链表**/
    private Node reverseLinkedList(Node head) {
        if (head == null || head.next==null) {
            return head;
        }
        Node prev = null;
        Node next = null;
        while(head!=null) {
            next = head.next;   //保存下一个节点
            head.next = prev;   //重置next
            prev = head;    //保存当前节点
            head = next;
        }
        return prev;
    }

    private Node reverseByStack(Node head) {
        if(head == null || head.next == null) {
            return  head;
        }
        Stack<Node>  stack = new Stack<>();
        Node cur = head;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        Node newHead = stack.pop();
        Node next = newHead;
        while (stack.size() != 0) {
            next.next = stack.pop();
            next = next.next;

        }
        next.next = null;
        return  newHead;

    }

    /**初始化链表**/
    private Node initLinkedList(int num) {
        Node head = new Node(0);
        Node cur = head;
        for(int i=1; i<num;i++){
            cur.next = new Node(i);
            cur = cur.next;
        }
        return head;
    }

    /**打印链表**/
    private void printLinkedList(Node head) {
        Node node = head;
        while(node != null){
            System.out.println(node.value);
            node = node.next;
        }
    }

    /**单向链表Node定义**/
    static class Node<T> {
        private T value;    //节点值
        private Node<T> next;   //后继节点

        public Node() {
        }
        public Node(T value) {
            this.value = value;
        }
    }

}