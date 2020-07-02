/**
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 *
 * 示例：
 *
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 *
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 *
 * 给定的 n 保证是有效的。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
package com.aaron.javapractice;

public class DelNode {
    public ListNode removeNthFromEnd(ListNode head,int n) {
        ListNode targetNode = head;
        ListNode frontNode = head;
        for(int i = 0; i < n; i++) {
            frontNode = frontNode.next;
        }
        while(frontNode.next != null) {
            frontNode = frontNode.next;
            targetNode = targetNode.next;
        }
        if(targetNode.next == null) {
            return  head;
        } else {
            if(targetNode.next.next != null) {
                targetNode.next = targetNode.next.next;
            } else {
                targetNode.next = null;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        DelNode solu = new DelNode();
        ListNode testCase = ListUtil.initListFromArray(new int []{
               0, 1,2,3,4,5,6,7,8,9
        });
        System.out.println("before delete:");
        ListUtil.printList(testCase);
        System.out.println("after delete :");
        ListNode ans = solu.removeNthFromEnd(testCase,2);
        ListUtil.printList(ans);
    }
}
