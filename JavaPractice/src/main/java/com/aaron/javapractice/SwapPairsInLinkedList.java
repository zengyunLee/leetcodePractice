/**
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * 示例:
 *
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/swap-nodes-in-pairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
package com.aaron.javapractice;

import java.util.LinkedList;
import java.util.Queue;

public class SwapPairsInLinkedList {
    // 借助队列实现
    public ListNode swapPairsByQueue (ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        Queue<ListNode> queue1 = new LinkedList<>();
        Queue<ListNode> queue2 = new LinkedList<>();
        ListNode cur = head;
        int index = 0;
        while (cur != null) {
            if(index % 2 == 0) {
                queue1.add(cur);
            } else {
                queue2.add(cur);
            }
            index++;
            cur = cur.next;
        }
        ListNode res = queue2.remove();
        ListNode tail = res;
        for(int i = 0; i < index - 1; i++) {
            if(i % 2 == 0) {
                tail.next = queue1.remove();
            } else {
                if(queue2.size() > 0) {
                    tail.next = queue2.remove();
                } else if(queue1.size() > 0) {
                    tail.next = queue1.remove();
                }
            }
            tail = tail.next;
        }
        if(tail != null) {
            tail.next = null;
        }
        return  res;
    }

    // 递归

    public ListNode swapPairsByRecursive(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode fir = head;
        ListNode sec = head.next;
        fir.next = swapPairsByRecursive(sec.next);
        sec.next = fir;
        return sec;
    }

    // 迭代
    public ListNode swapPairs (ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode cur = head;
        ListNode tail = null;
        ListNode cacheHead = null;
        while (cur.next != null) {
            cacheHead = cur.next.next;
            if(cacheHead != null) {
                tail = cur;
                cur.next.next = cur;
                cur.next = cacheHead.next;
                cur = cacheHead;
            } else {
                tail.next = cur;
                break;
            }
        }
        return head.next;
    }

        /**打印链表**/
    private static void printLinkedList(ListNode head) {
        ListNode node = head;
        while(node != null){
            System.out.println(node.val);
            node = node.next;
        }
    }

    public static void main(String[] args) {
        ListNode testCase = new ListNode(0);
        ListNode cur = testCase;
        for(int i = 1 ; i < 4; i++) {
            cur.next = new ListNode(i);
            cur = cur.next;
        }
        System.out.println("before resolve:");
        printLinkedList(testCase);
        SwapPairsInLinkedList solution = new SwapPairsInLinkedList();
        ListNode res = solution.swapPairsByRecursive(testCase);
        System.out.println("after resolve:");
        printLinkedList(res);
    }
}
