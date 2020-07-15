/*
 * @lc app=leetcode.cn id=82 lang=java
 *
 * [82] 删除排序链表中的重复元素 II
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode();
        dummy.next = head;
        
        ListNode pre = dummy;
        ListNode nextDifferent = head.next;
        while (head != null && head.next != null) {
            while (nextDifferent != null && head.val == nextDifferent.val) {
                // 找到最后一个不同的元素
                nextDifferent = nextDifferent.next;
            }
            if (head.next != nextDifferent) {
                // 存在重复
                pre.next = nextDifferent;
            } else {
                pre = pre.next;
            }
            head = nextDifferent;
        }

        return dummy.next;
    }
}
// @lc code=end

