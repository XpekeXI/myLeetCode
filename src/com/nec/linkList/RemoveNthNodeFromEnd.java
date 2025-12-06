package com.nec.linkList;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 删除倒数第N个节点
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点
 * <p>
 * 输入: [1,2,3,4,5] n=2
 * 输出: [1,2,3,5]
 */
public class RemoveNthNodeFromEnd {

    public static void main(String[] args) {
        ListNode l15 = new ListNode(5, null);
        ListNode l14 = new ListNode(4, l15);
        ListNode l13 = new ListNode(3, l14);
        ListNode l12 = new ListNode(2, l13);
        ListNode l11 = new ListNode(1, l12);
        ListNode l3 = removeN2(l11, 2);
        while (l3 != null) {
            System.out.print(l3.val + ", ");
            l3 = l3.next;
        }
    }

    /**
     * 计算链表的长度, 得到正向要删除的元素位置
     */
    public static ListNode removeN1(ListNode head, int n) {
        int length = 0;
        ListNode node = head;
        while (node != null) {
            length++;
            node = node.next;
        }
        ListNode pre = new ListNode(0, head);
        ListNode newPre = pre;
        // 遍历得到正向的length - n+1的位置, 即为要删除的节点
        for (int i = 1; i < length - n + 1; i++) {
            newPre = newPre.next;
        }
        // 删除当前节点, 即将其上个节点的指针, 指向当前节点的下个节点
        newPre.next = newPre.next.next;
        ListNode ans = pre.next;
        return ans;
    }

    /**
     * 使用栈, 将链表的节点依次入栈, 弹出第n个节点, 就是要删除的节点
     */
    public static ListNode removeN2(ListNode head, int n) {
        Deque<ListNode> stack = new LinkedList<>();
        // 删除当前节点, 即将其上个节点的指针, 指向当前节点的下个节点
        // 依然需要前面节点的辅助
        ListNode pre = new ListNode(0, head);
        ListNode headPre = pre;
        // 将节点依次压入栈
        while (pre != null) {
            stack.push(pre);
            pre = pre.next;
        }
        // 弹出n个元素, 下一个元素就是要删除节点的前一个节点
        for (int i = 1; i <= n; i++) {
            stack.pop();
        }
        pre = stack.pop();
        pre.next = pre.next.next;
        return headPre.next;
    }

}
