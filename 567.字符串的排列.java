/*
 * @lc app=leetcode.cn id=567 lang=java
 *
 * [567] 字符串的排列
 */

// @lc code=start
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        // 字符串问题：双指针/滑动窗口
        if (s2.length() < s1.length()) {
            return false;
        }
        int[] s1Arr = new int[26];
        int[] s2Arr = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            s1Arr[s1.charAt(i) - 'a']++;
            s2Arr[s2.charAt(i) - 'a']++; 
        }
        // 防止数组越界
        for (int i = 0; i < s2.length() - s1.length(); i++) {
            if (match(s1Arr, s2Arr)) {
                return true;
            }
            // s2.length()-1-s1.length~s2.length()-1 还没判断
            s2Arr[s2.charAt(i + s1.length()) - 'a']++;
            s2Arr[s2.charAt(i) - 'a']--;
        }
        // 最后窗口
        return match(s1Arr, s2Arr);
    }

    private boolean match(int[] arr1, int[] arr2) {
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end

