import java.util.*;



class Solution {
    int[][] map;
    int zero =0;
    int one = 0;
    public int[] solution(int[][] arr) {
        map = arr;
        DFS(0, 0, arr.length);
        return new int[]{zero, one};
    }
    
    public void DFS(int x, int y, int size){
        if(size == 1){
            if(map[x][y] == 0){
                zero++;
            }else{
                one++;
            }
            return;
        }
        
        if(check(x, y , size)){
            if(map[x][y] == 0){
                zero++;
            }else{
                one++;
            }
            return;
        }
        int newSize = size/2;
        DFS(x, y, newSize);
        DFS(x + newSize, y , newSize);
        DFS(x, y+ newSize , newSize);
        DFS(x  +newSize, y + newSize , newSize);
    }
    
    public boolean check(int x, int y, int size){
        int color = map[x][y];
        for(int i =x ; i < x + size; i++){
            for(int j = y; j < y + size; j++){
                if(map[i][j] != color){
                    return false;
                }
            }
        }
        return true;
    }
}