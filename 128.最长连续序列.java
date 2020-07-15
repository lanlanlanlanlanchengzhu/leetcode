/*
 * @lc app=leetcode.cn id=128 lang=java
 *
 * [128] 最长连续序列
 */

// @lc code=start
class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet();
        for (int i = 0; i < nums.length; i++) {
            numSet.add(nums[i]);
        }
        int res = 0;
        for (Integer oneNum : numSet) {
            if (!numSet.contains(oneNum - 1)) {
                int tmp = oneNum;
                int tmpCount = 1;
                while (numSet.contains(++tmp)) {
                    tmpCount++;
                }
                res = Math.max(res, tmpCount);
            }
        }
        return res;
    }
}
// @lc code=end

