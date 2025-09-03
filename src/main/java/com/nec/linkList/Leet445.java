package main.java.com.nec.linkList;

import java.util.Stack;

/**
 * @Description:
 * 给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。
 * 它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 *
 */
public class Leet445 {

    public static void main(String[] args) {
        ListNode l13 = new ListNode(3);
        ListNode l14 = new ListNode(4, l13);
        ListNode l12 = new ListNode(2, l14);
        ListNode l17 = new ListNode(7, l12);

        ListNode l24 = new ListNode(4);
        ListNode l26 = new ListNode(6, l24);
        ListNode l25 = new ListNode(5, l26);

        ListNode listNode = addTwoNumbers(l17, l25);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    /**
     * 该题的主要难点在于链表中 每个数的顺序和我们做加法的顺序是相反的
     * 为了逆序处理所有数位, 我们可以使用栈
     * 将所有的数压入栈中, 然后再依次取出相加
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }
        int carry = 0;
        ListNode ans = null;
        while(!stack1.isEmpty() || !stack2.isEmpty() || carry != 0) {
            int a = stack1.isEmpty() ? 0 : stack1.pop();
            int b = stack2.isEmpty() ? 0 : stack2.pop();
            int cur = a + b + carry;
            ListNode node = new ListNode(cur % 10);
            carry = cur / 10;
            node.next = ans;
            ans = node;
        }
        return ans;
    }
}
