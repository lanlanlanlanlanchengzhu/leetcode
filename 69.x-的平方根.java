/*
 * @lc app=leetcode.cn id=69 lang=java
 *
 * [69] x 的平方根
 */

// @lc code=start
class Solution {
    int result = Integer.MIN_VALUE;
    public int mySqrt(int x) {
        if (x == 0 || x == 1) {
            return x;
        }
        mySqrtInternal(x, 0, x);
        return result;
    }
    private void mySqrtInternal(int target, int start, int end) {
        if (start > end) {
            return;
        }
        int mid = (start + end) / 2;
        if (target / mid < mid) {
            mySqrtInternal(target, start, mid - 1);
        } else {
            result = Math.max(result, mid);
            mySqrtInternal(target, mid + 1, end);
        }
    }
}
// @lc code=end

