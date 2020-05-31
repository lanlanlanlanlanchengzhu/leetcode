/*
 * @lc app=leetcode.cn id=674 lang=java
 *
 * [674] 最长连续递增序列
 */

// @lc code=start
class Solution {
    public int findLengthOfLCIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int i = 0, j = 0, res = 0;
        while (++j < nums.length) {
            if (nums[j] <= nums[j - 1]) {
                // 非递增
                res = j - 1 - i + 1 > res ? j - 1 - i + 1 : res;
                i = j;
            }
        }
        return res > j - i ? res : j - i;
    }
}
// @lc code=end

