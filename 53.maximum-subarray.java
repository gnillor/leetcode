/*
 * [53] Maximum Subarray
 *
 * https://leetcode.com/problems/maximum-subarray
 *
 * algorithms
 * Easy (39.98%)
 * Total Accepted:    257.2K
 * Total Submissions: 643.3K
 * Testcase Example:  '[-2,1,-3,4,-1,2,1,-5,4]'
 *
 * 
 * Find the contiguous subarray within an array (containing at least one
 * number) which has the largest sum.
 * 
 * 
 * For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
 * the contiguous subarray [4,-1,2,1] has the largest sum = 6.
 * 
 * 
 * click to show more practice.
 * 
 * More practice:
 * 
 * If you have figured out the O(n) solution, try coding another solution using
 * the divide and conquer approach, which is more subtle.
 * 
 */
class Solution {
    public int maxSubArray(int[] nums) {
		int maxSub = nums[0], maxEnding = nums[0];
		for (int i = 1; i < nums.length; i++) {
			maxEnding = Math.max(maxEnding + nums[i], nums[i]);
			maxSub = Math.max(maxEnding, maxSub);
		}
		return maxSub;
    }
}
