package QueueAndStack;

import java.util.*;

/**
 * 钥匙和房间
 * 有 N 个房间，开始时你位于 0 号房间。每个房间有不同的号码：0，1，2，...，N-1，并且房间里可能有一些钥匙能使你进入下一个房间。
 * 在形式上，对于每个房间 i 都有一个钥匙列表 rooms[i]，每个钥匙 rooms[i][j] 由 [0,1，...，N-1] 中的一个整数表示，其中 N = rooms.length。 钥匙 rooms[i][j] = v 可以打开编号为 v 的房间。
 * 最初，除 0 号房间外的其余所有房间都被锁住。
 * 你可以自由地在房间之间来回走动。
 * 如果能进入每个房间返回 true，否则返回 false。
 */
public class CanVisitAllRooms {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        queue.offer(0);
        set.add(0);
        while (queue.size()>0&&set.size()<rooms.size()){
            int i = queue.poll();
            List<Integer> keys = rooms.get(i);
            for (Integer key : keys) {
                if (!set.contains(key)){
                    queue.offer(key);
                    set.add(key);
                }
            }
        }
        return set.size()==rooms.size();
    }
    public boolean canVisitAllRooms2(List<List<Integer>> rooms) {
        boolean[] visiteds = new boolean[rooms.size()];
        dfs(visiteds,rooms,0);
        for (boolean visited : visiteds) {
            if (!visited)return false;
        }
        return true;
    }
    private void dfs(boolean[] visiteds, List<List<Integer>> rooms,int room){
        if (visiteds[room])return;
        visiteds[room] = true;
        for (Integer key : rooms.get(room)) {
            if (key==room)continue;
            dfs(visiteds,rooms,key);
        }
    }
}
