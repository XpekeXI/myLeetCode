package main.java.com.nec.doublePointer;

import com.nec.leet.linklist.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author zhaoxuan
 * @Description:    环形链表
 * @date 2023/7/15
 *
 * 给你一个链表的头节点 head ，判断链表中是否有环。
 *
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。
 * 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
 * 注意：pos 不作为参数进行传递 。仅仅是为了标识链表的实际情况。
 *
 * 如果链表中存在环 ，则返回 true 。 否则，返回 false 。
 *
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 *
 */
public class Leet141 {

    public static void main(String[] args) {
        ListNode l4 = new ListNode(-4);
        ListNode l3 = new ListNode(0, l4);
        ListNode l2 = new ListNode(2, l3);
        ListNode l1 = new ListNode(3, l2);
        l4.next = l2;
        boolean b = hasCycle2(l1);
        System.out.println(b);
    }

    /**
     * 哈希表
     * 使用哈希表存储已经遍历过的, 每遍历到一个节点, 判断该节点是否被添加过, 添加过则存在环
     * 时间复杂度:
     * 遍历了链表所有值, O(n)
     * 空间复杂度:
     * 使用了一个哈希表, 极端情况下为O(n)
     */
    public static boolean hasCycle1(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            // set集合添加对象, 如果不包含该对象, 则返回true, 如果包含, 则返回false
            if (!set.add(head)) {
                return true;
            }
            head = head.next;
        }
        return false;
    }

    /**
     * 双指针
     * 使用快慢指针, 慢指针一次移动一格, 快指针一次移动两格,
     * 如果没有环, 快指针会率先达到链表尾节点
     * 如果有环, 两个指针早晚会相遇
     */
    public static boolean hasCycle2(ListNode head) {
        ListNode lk = head;
        ListNode rk = head.next;
        while (lk != rk) {
            if (rk == null || rk.next == null) {
                // 快指针到达终点, 没有环
                return false;
            }
            // 慢指针前进一格
            lk = lk.next;
            // 快指针前进两格
            rk = rk.next.next;
        }
        // 上述循环结束, 则快慢指针相遇, 链表中有环
        return true;
    }
}
