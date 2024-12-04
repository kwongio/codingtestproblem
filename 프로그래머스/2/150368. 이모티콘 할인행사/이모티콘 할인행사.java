import java.util.*;

class Solution {
    int[] select;
    int max = Integer.MIN_VALUE;
    int ansMoney = 0;
    public int[] solution(int[][] u, int[] e) {
        
        select = new int[e.length];
        DFS(u, e, 0);
        
        return new int[]{max,ansMoney};
    }
    
    void DFS(int[][] u, int[] e, int depth){
        if(depth == e.length){
            int p = 0;
            int m = 0;
            for(int i = 0; i < u.length;i++){
                int total  =0;
                int a=u[i][0];
                int b = u[i][1];
                for(int j =0 ; j < e.length; j++){
              
                    if(select[j] >= a){
                        total+= (int)(e[j] - e[j] * (select[j] * 0.01));
                    }
                }
                if(total >= b){
                    p++;
                }else{
                    m+= total;
                }
            }
            if(p > max || (p == max && m > ansMoney)){
                max = p;
                ansMoney = m;
            }
            return;
        }
        
        for(int i = 10; i <= 40; i+=10){
            select[depth] = i; 
            DFS(u, e, depth + 1);
        }
        
    }
}