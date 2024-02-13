import java.util.*;
class Solution {
    static int N = 1_000_001;

    public int[] solution(int[][] edges) {
        int[] out = new int[N];
        int[] in = new int[N];
        for(int i = 0 ;i < edges.length; i++){
            out[edges[i][0]]++;;
            in[edges[i][1]]++;
        }
        
        int create=0;
        int eight =0 ;
        int stick=0;
        for(int i = 1 ; i < N; i++){
            
            if(out[i] >= 2){
                if(in[i] == 0){
                    create = i;
                }else {
                    eight++;
                }
            }else if(out[i] == 0 && in[i] > 0){
                stick++;
                
            }
            
        }
        
        
        return new int[]{create, out[create] - stick - eight, stick, eight};
    }
}