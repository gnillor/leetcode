/*
 * @lc app=leetcode.cn id=24 lang=java
 *
 * [24] 两两交换链表中的节点
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
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode pre = dummy;
        ListNode first = head;

        while (first != null && first.next != null) {
            ListNode second = first.next;
            ListNode newFirst = second.next;
            pre.next = second;
            second.next = first;

            pre = first;
            first = newFirst;
        }

        pre.next = first;

        return dummy.next;
    }
}
// @lc code=end

