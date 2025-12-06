package com.nec.linkList;

/**
 *  反转链表
 *
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 *
 * 输入：head = [1,2,3,4,5]
 * 输出：[5,4,3,2,1]
 **/
public class ReverseList {

    public static void main(String[] args) {
        ListNode l15 = new ListNode(5, null);
        ListNode l14 = new ListNode(4, l15);
        ListNode l13 = new ListNode(3, l14);
        ListNode l12 = new ListNode(2, l13);
        ListNode l11 = new ListNode(1, l12);
        ListNode l2 = reverseList2(l11);
        while (l2 != null) {
            System.out.print(l2.val + ", ");
            l2 = l2.next;
        }
    }

    /**
     * 迭代方式
     */
    public static ListNode reverseList1(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        // 链表反转其实就是将当前节点的next指针改为指向前一个节点
        while (cur != null) {
            // 取到当前节点的下一个节点
            ListNode next = cur.next;
            // 将当前节点的next指针指向前一个节点
            cur.next = pre;
            // 继续向后遍历, 当前节点赋值为前驱节点
            pre = cur;
            // 后继节点赋值为当前节点
            cur = next;
        }
        return pre;
    }

    /**
     * 递归方式
     */
     public static ListNode reverseList2(ListNode head) {
     // 当前节点为空, 或当前节点的下一个节点为空, 则递归截止
     if (head == null || head.next == null) {
     return head;
     }
     /*
     * 递归的思想就是依次交给后续解决
     * 假设我们处于N(k)节点, 其之后的节点都反转完成, 即N(k+1)到尾节点都反转完成
     * 只需要将N(k+1)的后继指针指向N(k), 即N(k).next.next = N(k)
     * 然后N(k)的后继指针置为null
     */
    ListNode newHead = reverseList2(head.next);
    head.next.next = head;
    head.next = null;
    // 返回反转之后的头节点
        return newHead;

}



        }

