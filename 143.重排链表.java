/*
 * @lc app=leetcode.cn id=143 lang=java
 *
 * [143] 重排链表
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
    public void reorderList(ListNode head) {
        ListNode mid = getMidNode(head);
        ListNode right = mid.next;
        mid.next = null;
        right = reverseListNode(right);
        mergeListNodes(head, right);
    }

    private ListNode getMidNode(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }

    private ListNode reverseListNode(ListNode node) {
        if (node == null) {
            return node;
        }
        ListNode curr = node, next = node.next;
        curr.next = null;
        while (next != null) {
            ListNode newNext = next.next;
            next.next = curr;
            curr = next;
            next = newNext;
        }

        return curr;
    }

    private void mergeListNodes(ListNode left, ListNode right) {
        ListNode leftCurr = left, rightCurr = right, curr = null;
        while (leftCurr != null && rightCurr != null) {
            if (curr != null) {
                curr.next = leftCurr;
            }
            ListNode leftNext = leftCurr.next;
            leftCurr.next = rightCurr;

            curr = rightCurr;
            leftCurr = leftNext;
            rightCurr = rightCurr.next;
        }

        if (curr != null) {
            curr.next = leftCurr;
        }
    }
}
// @lc code=end

