/*
 * @lc app=leetcode.cn id=328 lang=java
 *
 * [328] 奇偶链表
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
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode firstOdd = head;
        ListNode oddCurr = head;
        ListNode firstEven = head.next;
        ListNode evenCurr = head.next;

        while (evenCurr != null && evenCurr.next != null) {
            oddCurr.next = oddCurr.next.next;
            oddCurr = oddCurr.next;
            evenCurr.next = evenCurr.next.next;
            evenCurr = evenCurr.next;
        }

        oddCurr.next = firstEven;
        return firstOdd;
    }
}
// @lc code=end

