/*
 * @lc app=leetcode.cn id=215 lang=java
 *
 * [215] 数组中的第K个最大元素
 */

// @lc code=start
class Solution {
    public int findKthLargest(int[] nums, int k) {
        int heapSize = nums.length;
        buildMaxHeap(nums, heapSize);
        for (int i = k; i > 1; i--) {
            swap(nums, 0, --heapSize);
            maxHeapify(nums, 0, heapSize);
        }

        return nums[0];
    }

    public void buildMaxHeap(int[] nums, int heapSize) {
        for (int i = (heapSize - 1) / 2; i >= 0; i--) {
            maxHeapify(nums, i, heapSize);
        }
    }

    public void maxHeapify(int[] nums, int i, int heapSize) {
        int leftChild = i * 2 + 1, rightChild = i * 2 + 2, largest = i;
        if (leftChild < heapSize && nums[largest] < nums[leftChild]) {
            largest = leftChild;
        }
        if (rightChild < heapSize && nums[largest] < nums[rightChild]) {
            largest = rightChild;
        }

        if (largest != i) {
            swap(nums, i, largest);
            maxHeapify(nums, largest, heapSize);
        }
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
// @lc code=end

