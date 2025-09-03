package main.java.com.nec.linkList;

/**
 * @Description: 合并两个有序链表
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * 输入：l1 = [1,2,4], l2 = [1,3,4]
 * 输出：[1,1,2,3,4,4]
 **/
public class Leet21 {

    public static void main(String[] args) {
        ListNode l14 = new ListNode(4);
        ListNode l12 = new ListNode(2, l14);
        ListNode l1 = new ListNode(1, l12);

        ListNode l24 = new ListNode(4);
        ListNode l23 = new ListNode(3, l24);
        ListNode l2 = new ListNode(1, l23);

//        ListNode listNode = mergeTwoLists1(l1, l2);
        ListNode listNode = mergeTwoLists2(l1, l2);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    /**
     * 递归解法
     *
     * 递推公式: 如果链表1的第一个元素 < 链表2的第一个元素, 则f(n, m) = f(n1) ->  f(n-1, m), 否则, f(n, m) = f(m1) -> f(n, m-1)
     * 终止条件: 链表1或链表2为空
     */
    public static ListNode mergeTwoLists1(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        }
        if (list1.val < list2.val) {
            list1.next = mergeTwoLists1(list1.next, list2);
            return list1;
        } else {
            list2.next =  mergeTwoLists1(list1, list2.next);
            return list2;
        }
    }



    /**
     * 迭代解法
     * 设定一个哨兵节点, prehead, 相当于AQS中的头节点, 最后使用这个节点的next指针返回新链表,
     * 用一个动态的节点tail, 来表示新链表的尾节点
     */
    public static ListNode mergeTwoLists2(ListNode list1, ListNode list2) {
        ListNode prehead = new ListNode(-1);
        ListNode tail = prehead;

        // 遍历过程中, 一个个添加新链表节点
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                tail.next = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }
        // 如果某一个链表还有剩余, 则直接将其添加到到新链表的尾部
        if (list1 != null) {
            tail.next = list1;
        } else {
            tail.next = list2;
        }
        return prehead.next;
    }

}

