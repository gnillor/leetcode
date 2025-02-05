/*
 * @lc app=leetcode.cn id=15 lang=java
 *
 * [15] 三数之和
 */

// @lc code=start
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length - 1; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                int target = -nums[i] - nums[j];
                int idx = Arrays.binarySearch(nums, j + 1, nums.length, target);
                if (idx > -1) {
                    ret.add(Arrays.asList(nums[i], nums[j], target));
                }
            }
        }

        return ret;
    }
}
// @lc code=end
