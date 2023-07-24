/*
 * @lc app=leetcode.cn id=649 lang=java
 *
 * [649] Dota2 参议院
 */

// @lc code=start

import java.util.ArrayDeque;
import java.util.Queue;

class Solution {
    public String predictPartyVictory(String senate) {
        Queue<Integer> radiantQueue = new ArrayDeque<>();
        Queue<Integer> direQueue = new ArrayDeque<>();
        for (int i = 0; i < senate.length(); i++) {
            if (senate.charAt(i) == 'R') {
                radiantQueue.offer(i);
            } else {
                direQueue.offer(i);
            }
        }

        while (!radiantQueue.isEmpty() && !direQueue.isEmpty()) {
            Integer radiantIdx = radiantQueue.poll();
            Integer direIdx = direQueue.poll();
            if (radiantIdx < direIdx) {
                radiantQueue.offer(radiantIdx + senate.length());
            } else {
                direQueue.offer(direIdx + senate.length());
            }
        }

        return radiantQueue.isEmpty() ? "Dire" : "Radiant";
    }
}
// @lc code=end

