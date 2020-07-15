/*
 * @lc app=leetcode.cn id=120 lang=java
 *
 * [120] 三角形最小路径和
 */

// @lc code=start
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) {
            return -1;
        }
        Integer[] dp = new Integer[triangle.size()];
        dp[0] = triangle.get(0).get(0);
        for (int i = 1; i < triangle.size(); i++) {
            for (int j = i; j >= 0; j--) {
                int curr = triangle.get(i).get(j);
                if (j == i) {
                    dp[j] = dp[j - 1] + curr;
                } else if (j == 0) {
                    dp[j] = dp[0] + curr;
                } else {
                    dp[j] = Math.min(dp[j] + curr, dp[j - 1] + curr);
                }
            }
        }

        return Collections.min(Arrays.asList(dp));
    }
}
// @lc code=end

