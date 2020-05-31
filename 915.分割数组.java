/*
 * @lc app=leetcode.cn id=915 lang=java
 *
 * [915] 分割数组
 */

// @lc code=start
class Solution {
    public int partitionDisjoint(int[] A) {
        int[] min = new int[A.length];
        int[] max = new int[A.length];
        min[A.length - 1] = Integer.MAX_VALUE;
        max[0] = A[0];
        for (int i = A.length - 2; i >= 0; i--) {
            min[i] = Math.min(min[i + 1], A[i + 1]);
        }
        for (int i = 1; i < A.length; i++) {
            max[i] = Math.max(max[i - 1], A[i]);
        }
        for (int i = 0; i < A.length; i++) {
            if (max[i] <= min[i]) {
                return i + 1;
            }
        }
        return 0;
    }
}
// @lc code=end

