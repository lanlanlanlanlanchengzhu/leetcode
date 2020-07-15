/*
 * @lc app=leetcode.cn id=393 lang=java
 *
 * [393] UTF-8 编码验证
 */

// @lc code=start
class Solution {
    public boolean validUtf8(int[] data) {
        int n = 0;
        for (int i = 0; i < data.length; i++) {
            if (n > 0) {
                if (data[i] >> 6 != 0b10) {
                    return false;
                }
                n--;
            } else if (data[i] >> 7 == 0b0) {
                n = 0;
            } else if (data[i] >> 5 == 0b110) {
                n = 1;
            } else if (data[i] >> 4 == 0b1110) {
                n = 2;
            } else if (data[i] >> 3 == 0b11110) {
                n = 3;
            } else {
                return false;
            }
        }
        return n == 0;
    }
}
// @lc code=end

