/*
 * @lc app=leetcode.cn id=148 lang=java
 *
 * [148] 排序链表
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
    // 插入排序
    public ListNode sortList(ListNode head) {
        ListNode dummy = new ListNode(0);
        while (head != null) {
            ListNode tmpDummy = dummy;
            ListNode curr = head;
            head = head.next;
            while (tmpDummy.next != null && tmpDummy.next.val < curr.val) {
                tmpDummy = tmpDummy.next;
            }
            // 找到插入位置
            curr.next = tmpDummy.next;
            tmpDummy.next = curr;
        }
        return dummy.next;
    }
}
// @lc code=end

