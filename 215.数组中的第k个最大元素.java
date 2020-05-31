/*
 * @lc app=leetcode.cn id=215 lang=java
 *
 * [215] 数组中的第K个最大元素
 */

// @lc code=start
class Solution {
    public int findKthLargest(int[] nums, int k) {
        sort(nums, 0, nums.length - 1);
        return nums[nums.length - k];
    }

    // 升序
    private void sort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int i = start, j = end;
        int tmp = nums[i];
        while (i < j) {
            while (nums[j] >= tmp && i < j) {
                j--;
            }
            if (i < j) {
                nums[i] = nums[j];
                i++;
            }
            while (nums[i] <= tmp && i < j) {
                i++;
            }
            if (i < j) {
                nums[j] = nums[i];
                j--;
            }
        }
        nums[i] = tmp;
        sort(nums, start, i - 1);
        sort(nums, i + 1, end);
    }

}
// @lc code=end

