/*
 * @lc app=leetcode.cn id=2130 lang=java
 *
 * [2130] 链表最大孪生和
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int pairSum(ListNode head) {
        ListNode slow = head;
        ListNode slowNext = slow.next;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;

            ListNode newSlowNext = slowNext.next;
            slowNext.next = slow;
            slow = slowNext;
            slowNext = newSlowNext;
        }

        int ret = 0;
        while (slow != null && slowNext != null) {
            ret = Math.max(ret, slow.val + slowNext.val);
            slow = slow.next;
            slowNext = slowNext.next;
        }
        return ret;
    }
}
// @lc code=end

