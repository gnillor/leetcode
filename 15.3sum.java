/*
 * [15] 3Sum
 *
 * https://leetcode.com/problems/3sum/description/
 *
 * algorithms
 * Medium (21.82%)
 * Total Accepted:    299.7K
 * Total Submissions: 1.4M
 * Testcase Example:  '[-1,0,1,2,-1,-4]'
 *
 * Given an array S of n integers, are there elements a, b, c in S such that a
 * + b + c = 0? Find all unique triplets in the array which gives the sum of
 * zero.
 *
 * Note: The solution set must not contain duplicate triplets.
 *
 *
 * For example, given array S = [-1, 0, 1, 2, -1, -4],
 *
 * A solution set is:
 * [
 * ⁠ [-1, 0, 1],
 * ⁠ [-1, -1, 2]
 * ]
 *
 */
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		int len = nums.length;
		if (len <= 2) return null;
		quickSort(nums, 0, len - 1);
		for (int t = 0; t < len; t++) {
			System.out.print(nums[t] + ", ");
		}
	 	for (int i = 0; i < len; i++) {
			for (int j = i + 1; j < len - 1; j++) {
				int target = - nums[i] - nums[j];
				System.out.print(target + ", ");
				if (binarySearch(nums, target, j + 1, len - 1)) {
					result.add(Arrays.asList(nums[i], nums[j], target));
				}
			}
		}
		return result;
    }

	public void quickSort(int[] nums, int begin, int end) {
		if (begin >= end) return;
		int i = begin;
		int j = end + 1;
		int pivot = nums[begin];
		while (true) {
			while (nums[++i] < pivot) {
				if (i == end) break;
			}
			while (nums[--j] > pivot) {
				if (j == begin) break;
			}
			if (i >= j) break;
			exch(nums, i, j);
		}
		exch(nums, begin, j);
		quickSort(nums, begin, j - 1);
		quickSort(nums, j + 1, end);
	}

	public void exch(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	public boolean binarySearch(int[] nums, int target, int begin, int end) {
		if (begin > end) return false;
		int mid = (begin + end) / 2;
		if (target > nums[mid]) {
			binarySearch(nums, target, mid + 1, end);
		} else if (target < nums[mid]) {
			binarySearch(nums, target, begin, mid - 1);
		} else {
			return true;
		}
		return false;
	}
}
