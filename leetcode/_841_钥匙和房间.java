package leetcode;

import java.util.HashSet;
import java.util.List;

/**
 * @author FlyGreyWolf
 * @since 2020/8/31
 */
public class _841_钥匙和房间 {

    public boolean flag = false;

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {


        boolean[] visit = new boolean[rooms.size()];


        visit[0] = true;
        process(rooms, visit, rooms.get(0), 1);
        return flag;
    }



    public void process(List<List<Integer>> rooms, boolean[] visit, List<Integer> hasKey, int hasSolve) {

        if(hasSolve == rooms.size()) {
            flag = true;
        }

        if(flag == true) {
            return;
        }


        for(Integer key : hasKey) {
            if(visit[key] == false) {
                visit[key] = true;


                process(rooms, visit, rooms.get(key), hasSolve+1);
                visit[key] = false;
            } else {
                process(rooms, visit, rooms.get(key), hasSolve);
            }
        }
    }

}
