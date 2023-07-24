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
		if (m > n) {
			return findMedianSortedArrays(nums2, nums1);
		}
		int iMin = 0, iMax = m;
		while (iMin <= iMax) {
			int i = (iMin + iMax) / 2;
			int j = (m + n + 1) / 2 - i;
			
			int left1Max = (i == 0) ? 0 : nums1[i - 1];
			int right1Min = (i == m) ? Integer.MAX_VALUE : nums1[i];
			int left2Max = (j == 0) ? 0 : nums2[j - 1];
			int right2Min = (j == n) ? Integer.MAX_VALUE : nums2[j];

			if (left1Max > right2Min) {
				iMax--;
			} else if (left2Max > right1Min) {
				iMin++;
			} else {
				if ((m + n) % 2 == 0) {
					return (Math.max(left1Max, left2Max) + Math.min(right1Min, right2Min)) / 2.0;
				} else {
					return Math.max(left1Max, left2Max);
				}
			}
		}
		return 1;
    }
}

