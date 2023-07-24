/*
 * @lc app=leetcode.cn id=841 lang=java
 *
 * [841] 钥匙和房间
 */

// @lc code=start

class Solution {
    private boolean[] visitedRooms;
    private int count = 0;

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        this.visitedRooms = new boolean[rooms.size()];
        visitRooms(0, rooms);
        return count == rooms.size();
    }

    private void visitRooms(int roomNum, List<List<Integer>> rooms) {
        if (visitedRooms[roomNum]) {
            return;
        } else {
            visitedRooms[roomNum] = true;
            count++;
        }

        for (int room : rooms.get(roomNum)) {
            visitRooms(room, rooms);
        }
    }
}
// @lc code=end

