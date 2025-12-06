package com.nec.heap;

/**
 * 数组中的第K个最大元素
 * 给定数组nums和整数k, 请返回数组中第k个最大的元素
 * 请注意: 你需要找的是数组排序后的第k个最大的元素, 而不是第k个不同的元素
 * 必须设计时间复杂度为O(n)的算法
 * <p>
 * 示例:
 * 输入: [3,2,1,5,6,4], k=2
 * 输出: 5
 */
public class KthLargestElement {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println(getKLargest(nums, 2));
    }

    public static int getKLargest(int[] nums, int k) {
        quickSort(nums, 0, nums.length - 1);
        return nums[k - 1];
        // 将数组从大到小排序, 则k-1的索引位置就是第K大的元素
        // return quickSelect(nums, 0, nums.length - 1, k - 1);
    }


    /**
     * 原生快排
     * 从第一个元素开始, 找到它的位置, 左边比它大, 右边比它小, 然后交换位置
     * 继续递归排它左边的元素以及右边的元素
     * 时间复杂度O(nlogn), 空间复杂度O(logn)
     */
    public static void quickSort(int[] nums, int l, int r) {
        if (l >= r) {
            return;
        }
        int index = partSort(nums, l, r);
        // 快排左边
        quickSort(nums, l, index - 1);
        // 快排右边
        quickSort(nums, index + 1, r);
    }

    // 找到第一个元素的应该的位置, 放置并返回索引
    public static int partSort(int[] nums, int l, int r) {
        int key = l;
        while (l < r) {
            // nums[l]比nums[k]大, 符合排序要求,继续向后找
            while (nums[l] > nums[key]) {
                l++;
            }
            // nums[r]比nums[k]小, 符合排序要求,继续向前找
            while (nums[r] < nums[key]) {
                r--;
            }
            // 上两个循环结束, nums[l]比nums[k]小, nums[r]比nums[key]大
            // 交换两个位置后, 则变成左边大, 右边小, 可以继续寻找key的位置
            if (l < r) {
                int temp = nums[l];
                nums[l] = nums[r];
                nums[r] = temp;
            }
        }
        // 走到这里说明, l=r, 且l的左侧都比nums[key]大, 右侧都小, 找到了key的位置
        // 交换l与key的位置的值, 并返回l索引
        int temp = nums[key];
        nums[key] = nums[l];
        nums[l] = temp;
        return l;
    }

    /**
     * 找到排序后第k个索引位置值
     */
    public static int quickSelect(int[] nums, int l, int r, int k) {
        if (l >= r) {
            return nums[k];
        }
        int num = nums[l], i = l, j = r;
        while (i < j) {
            while (nums[i] > num) {
                i++;
            }
            while (nums[j] < num) {
                j--;
            }
            if (i < j) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
        // 走到这里, 则i和j相等, 如果j大于等于k, 则第k个索引在 [l, j] 的区间内
        if (j >= k) {
            return quickSelect(nums, l, j, k);
        } else {
            return quickSelect(nums, j + 1, r, k);
        }
    }

    public static int bucketSelect() {
        return 1;
    }

    public static void buildMaxHeap(int[] arr, int heapSize) {
        for (int i = heapSize / 2 - 1; i >= 0; i--) {
            adjustHeap(arr, i, heapSize);
        }
    }

    public static void adjustHeap(int[] arr, int i, int heapSize) {
        int left = i * 2 + 1, right = i * 2 + 2, largest = i;
        if (left < heapSize && arr[left] > arr[largest]) {
            largest = left;
        }
        if (right < heapSize && arr[right] > arr[largest]) {
            largest = right;
        }
        if (largest != i) {
            swap(arr, i, largest);
            adjustHeap(arr, largest, heapSize);
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
