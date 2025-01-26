/*
 * [4] Median of Two Sorted Arrays
 *
 * https://leetcode.com/problems/median-of-two-sorted-arrays
 *
 * algorithms
 * Hard (22.36%)
 * Total Accepted:    211.6K
 * Total Submissions: 946.4K
 * Testcase Example:  '[1,3]\n[2]'
 *
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 *
 * Find the median of the two sorted arrays. The overall run time complexity
 * should be O(log (m+n)).
 *
 * Example 1:
 *
 * nums1 = [1, 3]
 * nums2 = [2]
 *
 * The median is 2.0
 *
 *
 *
 * Example 2:
 *
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 *
 * The median is (2 + 3)/2 = 2.5
 *
 *
 */
class Solution {
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int m = nums1.length;
		int n = nums2.length;
		int len = m + n;
		if (len % 2 == 0) {
			int firstIdx = len / 2;
			return (getKth(nums1, 0, m - 1, nums2, 0, n - 1, firstIdx)
					+ getKth(nums1, 0, m - 1, nums2, 0, n - 1, firstIdx + 1)) / 2.0;
		} else {
			return getKth(nums1, 0, m - 1, nums2, 0, n - 1, (len / 2) + 1);
		}
	}

	private int getKth(int[] num1, int start1, int end1, int[] num2, int start2, int end2, int k) {
		int m = end1 - start1 + 1;
		int n = end2 - start2 + 1;

		if (m > n) {
			return getKth(num2, start2, end2, num1, start1, end1, k);
		}
		if (m == 0) {
			return num2[start2 + k - 1];
		}
		if (k == 1) {
			return Math.min(num1[start1], num2[start2]);
		}

		int i = start1 + Math.min(m, k / 2) - 1;
		int j = start2 + Math.min(n, k / 2) - 1;
		if (num1[i] < num2[j]) {
			return getKth(num1, i + 1, end1, num2, start2, end2, k - (i - start1 + 1));
		} else {
			return getKth(num1, start1, end1, num2, j + 1, end2, k - (j - start2 + 1));
		}
	}
}
