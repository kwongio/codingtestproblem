import java.util.*;

class Solution {
    Map<String, int[]> map = new HashMap<>();
    public int[] solution(String[] keyinput, int[] board) {
        int[] answer = {};
        map.put("left", new int[]{0, -1});
        map.put("right", new int[]{0, 1});
        map.put("up", new int[]{1, 0});
        map.put("down", new int[]{-1, 0});
        int w = board[0]/2;
        int h = board[1]/2;
        
        
        int x =0 ;
        int y = 0;
        for(String input : keyinput){
            int nx = map.get(input)[0] + x;
            int ny = map.get(input)[1] + y;
            
            
            if(Math.abs(nx) <= h && Math.abs(ny) <= w){
                x = nx;
                y = ny;
            }
        }
        return new int[]{y, x};
    }
}