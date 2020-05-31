/*
 * @lc app=leetcode.cn id=151 lang=java
 *
 * [151] 翻转字符串里的单词
 */

// @lc code=start
class Solution {
    public String reverseWords(String s) {
        String[] arr = s.split(" ");
        Stack<String> stack = new Stack();
        for (int i = 0; i < arr.length; i++) {
            stack.push(arr[i]);
            stack.push(" ");
        }
        StringBuilder sb = new StringBuilder();
        String last = "";
        while (!stack.isEmpty()) {
            String tmp = stack.pop();
            if (!(" ".equals(last) && " ".equals(tmp))) {
                sb.append(tmp);
            }
            last = tmp;
        }
        while (sb.length() > 0) {
            if (" ".charAt(0) == sb.charAt(0)) {
                sb = new StringBuilder(sb.substring(1, sb.length()));
            } else {
                break;
            }
        }
        while (sb.length() > 0) {
            if (" ".charAt(0) == sb.charAt(sb.length() - 1)) {
                sb = new StringBuilder(sb.substring(0, sb.length() - 1));
            } else {
                break;
            }
        }
        return sb.toString();
    }
}
// @lc code=end

