package com.nec.hashtable;

import com.nec.linkList.ListNode;

import java.util.HashSet;

/**
 * @Description:    相交链表
 * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null
 * 题目数据 保证 整个链式结构中不存在环。
 *
 * 注意，函数返回结果后，链表必须 保持其原始结构 。
 **/
public class IntersectionTwoLinkedLists {

    public static void main(String[] args) {
        ListNode l15 = new ListNode(5, null);
        ListNode l14 = new ListNode(4, l15);
        ListNode l13 = new ListNode(8, l14);
        ListNode l12 = new ListNode(1, l13);
        ListNode l11 = new ListNode(4, l12);
        ListNode l23 = new ListNode(1, l13);
        ListNode l22 = new ListNode(6, l23);
        ListNode l21 = new ListNode(5, l22);
        ListNode l3 = getInter(l11, l21);
        System.out.println(l3);
    }

    /**
     * 先将链表A的所有节点放入Set集合中
     * 遍历链表B, 如果有节点在Set集合中, 则从该节点后的所有节点都与链表A相交
     * 如果都没有在, 则没有相交
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashSet<ListNode> nodeSet = new HashSet<>();
        ListNode temp = headA;
        while (temp != null) {
            nodeSet.add(temp);
            temp = temp.next;
        }

        temp = headB;
        while (temp != null) {
            if (nodeSet.contains(temp)) {
                return temp;
            }
            temp = temp.next;
        }

        return null;
    }

    /**
     * 双指针
     * 两个链表长度分别为m和n
     * 如果两个链表相交, 相交部分长度为c, 链表a剩余不相交的部分为a, 链表b不相交的部分为b, 则a+c=m, b+c=n
     * 如果两个链表长度相等, 则两个指针会同时走到相交的节点
     * 如果两个链表长度不相等, 总会有一个指针提前走完, 如果链表a走完时, 继续走链表b的头结点;链表b走完时,继续走链表a的头结点
     * 则指针a走m+n的长度, 指针b走n+m的长度, 可以保证两个指针会同时走到相交的节点
     *
     * 如果两个链表不相交, 则两个指针都走完m+n的长度之后, 就会指向null, 返回null即可
     */
    public static ListNode getInter(ListNode heada, ListNode headb) {
        if (heada == null || headb == null) {
            return null;
        }
        ListNode pa = heada, pb = headb;
        while (pa != pb) {
            pa = pa == null ? headb : pa.next;
            pb = pb == null ? heada : pb.next;
        }
        return pa;
    }
}
