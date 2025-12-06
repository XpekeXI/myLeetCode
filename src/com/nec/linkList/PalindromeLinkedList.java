package com.nec.linkList;

import java.util.ArrayList;
import java.util.List;

/**
 * 回文链表
 * 给定一个单链表的头节点head, 判断该链表是否是回文链表
 * <p>
 * 输入: head=[1,2,2,1]
 * 输出: true
 */
public class PalindromeLinkedList {
    public static void main(String[] args) {
        ListNode l14 = new ListNode(1, null);
        ListNode l13 = new ListNode(2, l14);
        ListNode l12 = new ListNode(2, l13);
        ListNode l11 = new ListNode(1, l12);
        boolean palind = isPalind(l11);
        System.out.println(palind);
    }

    // 使用数组存储链表, 然后用双指针判断是否是否回文
    public static boolean isPalind(ListNode head) {
        // 新建数组集合存储链表
        List<Integer> arrs = new ArrayList<Integer>();

        // 将链表的值复制到数组中
        ListNode curr = head;
        while (curr != null) {
            arrs.add(curr.val);
            curr = curr.next;
        }

        // 使用双指针判断是否回文
        int left = 0, right = arrs.size() - 1;
        while (left < right) {
            if (arrs.get(left) != arrs.get(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

}
