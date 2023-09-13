/*
 * @lc app=leetcode.cn id=2336 lang=java
 *
 * [2336] 无限集中的最小数字
 */

// @lc code=start

import java.util.Deque;
import java.util.LinkedList;

class SmallestInfiniteSet {
    private Deque<Integer> deque;
    private int start = 1;

    public SmallestInfiniteSet() {
        this.deque = new LinkedList<>();
        addTenNum();
    }

    public int popSmallest() {
        if (deque.isEmpty()) {
            addTenNum();
        }
        return deque.pollFirst();
    }

    public void addBack(int num) {
        if (deque.isEmpty()) {
            deque.addFirst(num);
        }

        int left = deque.peekFirst();
        int right = deque.peekLast();

        if (num < left) {
            deque.addFirst(num);
        } else if (num >= left && num <= right) {
            Stack<Integer> stack = new Stack();
            while (num > deque.peekFirst()) {
                stack.push(deque.pollFirst());
            }
            if (num < deque.peekFirst()) {
                deque.addFirst(num);
            }
            while (!stack.isEmpty()) {
                deque.addFirst(stack.pop());
            }
        } else {
            while (right < num) {
                deque.addLast(++right);
            }
        }
    }

    private void addTenNum() {
        if (!deque.isEmpty()) {
            start = deque.peekLast() + 1;
        }

        for (int i = 0; i < 10; i++) {
            deque.addLast(start++);
        }
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */
// @lc code=end
