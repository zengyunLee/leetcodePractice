/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
package com.aaron.javapractice;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {val = x;}
}

public class TwoNumSum {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = l1;
        while(l1 != null && l2 != null) {
            int sum = l1.val + l2.val;
            if(sum >= 10) {
                l1.val = sum - 10;
                if(l1.next != null) {
                    l1.next.val++;
                } else {
                    l1.next = new ListNode(1);
                }
            } else {
                l1.val = sum;
            }
            if(l1.next == null && l2.next!=null) {
                l1.next = l2.next;
                break;
            }

            l1 = l1.next;
            l2 = l2.next;
        }
        ListNode l1last = l1;
        while(l1last != null && l1last.val == 10) {
            l1last.val = 0;
            if(l1last.next != null) {
                l1last.next.val++;
                l1last = l1last.next;
            } else {
                l1last.next = new ListNode(1);
            }
        }
        return head;
    }

    static ListNode initListFromArray(int [] arr) {
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

    static void printList(ListNode head) {
        ListNode temp = head;
        while(temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{4,9,9};
        int[] arr2 = new int[]{6};
        ListNode l1 = initListFromArray(arr1);
        ListNode l2 = initListFromArray(arr2);
        System.out.println("input List l1");
        printList(l1);
        System.out.println("input List l2");
        printList(l2);
        TwoNumSum solution = new TwoNumSum();
        ListNode res = solution.addTwoNumbers(l1,l2);
        System.out.println("result List is:");
        printList(res);
    }
}