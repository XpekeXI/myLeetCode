package main.java.com.nec.linkList;

/**
 *  反转链表
 *
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 *
 * 输入：head = [1,2,3,4,5]
 * 输出：[5,4,3,2,1]
 **/
public class Leet206 {

    public static void main(String[] args) {
        ListNode l5 = new ListNode(5);
        ListNode l4 = new ListNode(4, l5);
        ListNode l3 = new ListNode(3, l4);
        ListNode l2 = new ListNode(2, l3);
        ListNode l1 = new ListNode(1, l2);

//        ListNode listNode = reverseList1(l1);
        ListNode listNode = reverseList2(l1);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    /**
     * 递归解法:
     * 递推条件: f(n) = f(n-1) -> f(1), f(n-1)(即node.next)指向f(1)(即node), 即node.next.next = node
     * 终止条件: 链表为空
     */
    public static ListNode reverseList1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode listNode = reverseList1(head.next);
        // 将f(n-1)指向f(1)
        head.next.next = head;
        // 将f(1)的指向置为空, 反转之后, f(1)成了尾节点, 则next为空
        head.next = null;
        return listNode;
    }

    /**
     * 迭代解法
     * 在遍历链表时, 将当前节点的后一个节点变为前一个节点
     */
    public static ListNode reverseList2(ListNode head) {

        // 设置前驱节点
        ListNode prev = null;
        // 当前遍历的节点
        ListNode curr = head;
        while (curr != null) {
            // 取出当前节点的后继节点
            ListNode next = curr.next;
            // 将当前节点的后一个节点变为前一个节点
            curr.next = prev;
            // 当前节点向前移一位
            prev = curr;
            // 后继节点置为当期节点
            curr = next;
        }
        return prev;
    }

}

