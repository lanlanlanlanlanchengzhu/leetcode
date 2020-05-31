/*
 * @lc app=leetcode.cn id=15 lang=java
 *
 * [15] 三数之和
 */

// @lc code=start
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList();
        Arrays.sort(nums);
        int length = nums.length;
        for (int i = 0; i < length - 2 && nums[i] <= 0; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int start = i + 1, end = length - 1;
            while (start < end) {
                if (nums[i] + nums[start] + nums[end] == 0) {
                    List<Integer> oneRes = new ArrayList(Arrays.asList(nums[i], nums[start], nums[end]));
                    result.add(oneRes);
                    while (start < end && nums[start] == nums[++start]) {}
                    while (start < end && nums[end] == nums[--end]) {}
                } else if (nums[i] + nums[start] + nums[end] < 0) {
                    // 左边右移
                    while (start < end && nums[start] == nums[++start]) {}
                } else {
                    // 右边左移
                    while (start < end && nums[end] == nums[--end]) {}
                }
            }
        }
        return result;
    }
}
// @lc code=end

