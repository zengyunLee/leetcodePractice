package com.aaron.javapractice;
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {val = x;}
}
public class ListUtil {

    public static ListNode initListFromArray(int [] arr) {
        if(arr == null || arr.length == 0) {
            return  null;
        }
        ListNode head = new ListNode(arr[0]);
        ListNode temp = head;
        for(int i = 1; i < arr.length; i++) {
            temp.next = new ListNode(arr[i]);
            temp = temp.next;
        }
        return head;
    }

    public static void printList(ListNode head) {
        ListNode temp = head;
        while(temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }
    }
}
