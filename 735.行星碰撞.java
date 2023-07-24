/*
 * @lc app=leetcode.cn id=735 lang=java
 *
 * [735] 行星碰撞
 */

// @lc code=start
class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> valueStack = new Stack<>();

        for (int asteroid : asteroids) {
            boolean alive = true;

            while (alive && !valueStack.isEmpty() && valueStack.peek() > 0 && asteroid < 0) {
                int peek = valueStack.peek();
                alive = peek + asteroid < 0;
                if (peek + asteroid <= 0) {
                    valueStack.pop();
                }
            }

            if (alive) {
                valueStack.push(asteroid);
            }
        }

        int[] ret = new int[valueStack.size()];
        for (int i = valueStack.size() - 1; i >= 0; i--) {
            ret[i] = valueStack.pop();
        }
        return ret;
    }
}
// @lc code=end

