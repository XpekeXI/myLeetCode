package com.nec.linkList;

import java.util.HashMap;
import java.util.Map;

/**
 * 请你设计并实现一个满足  LRU (最近最少使用) 缓存 约束的数据结构。
 * 实现 LRUCache 类：
 * LRUCache(int capacity) 以 正整数 作为容量 capacity 初始化 LRU 缓存
 * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 * void put(int key, int value) 如果关键字 key 已经存在，则变更其数据值 value ；如果不存在，则向缓存中插入该组 key-value 。如果插入操作导致关键字数量超过 capacity ，则应该 逐出 最久未使用的关键字。
 * 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。
 */
public class LRUCache {
    static class DLinkedNode {
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;

        public DLinkedNode() {

        }
        public DLinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private static Map<Integer, DLinkedNode> cache = new HashMap<>();
    private static int size;
    private static int capacity;
    // 伪头节点, 仅用来表示链表第一个节点的前驱节点, 方便维护
    // 伪尾节点, 仅用来表示链表最后一个节点的后继节点, 方便维护
    private static DLinkedNode head, tail;

    public LRUCache(int capacity) {
        this.size = 0;
        // 初始化容量
        this.capacity = capacity;
        head = new DLinkedNode();
        tail = new DLinkedNode();
        // 维护一个空链表, 伪头节点的后继指针指向伪尾节点, 伪尾节点的的前驱指针指向伪头节点
        head.next = tail;
        tail.prev = head;
    }

    // 根据key查找value
    public static int get(int key) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            return -1;
        }
        // 如果key存在, 先通过哈希表定位,再移到头部
        moveToHead(node);
        return node.value;
    }

    // 将当前节点移动到头部
    private static void moveToHead(DLinkedNode node) {
        removeNode(node);
        addToHead(node);
    }

    // 删除节点
    private static void removeNode(DLinkedNode node) {
        // 当前节点的前驱节点的next指针指向当前节点的后继节点
        node.prev.next = node.next;
        // 当前节点的后继节点的prev指针指向前驱节点
        node.next.prev = node.prev;
    }

    // 将当前节点放在第一个节点
    private static void addToHead(DLinkedNode node) {
        // 当前节点的前驱指针为伪头节点
        node.prev = head;
        // 当前节点的后继指针为原伪头节点的后继节点
        node.next = head.next;
        // 原伪头节点的后继节点的前驱指针指向当前节点
        head.next.prev = node;
        // 原伪头节点的后继节点改为当前节点
        head.next = node;
    }

    public static void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            // 如果key不存在, 创建一个新的节点
            DLinkedNode newNode = new DLinkedNode(key, value);
            // 添加仅哈希表
            cache.put(key, node);
            // 将该节点放入链表的头部
            addToHead(newNode);
            size++;
            if (size > capacity) {
                // 如果超出容量限制, 则删除链表的尾节点
                DLinkedNode tail = removeTail();
                // 删除哈希表中对应的项
                cache.remove(tail.key);
                size--;
            }
        } else {
            // 如果key存在, 替换value的值, 并将该节点移动到第一个节点
            node.value = value;
            moveToHead(node);
        }
    }

    public static DLinkedNode removeTail() {
        DLinkedNode node = tail.prev;
        removeNode(node);
        return node;
    }

    public static void main(String[] args) {

    }

}
