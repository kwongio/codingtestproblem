import java.util.*;

class Solution {
    public List<Integer> solution(int[] p, int[] s) {
        
        List<Integer> list = new ArrayList<>();
        for(int i =0; i < p.length; i++){
            int num = (100 -p[i])%s[i] != 0 ? 1 : 0;
            list.add((100 - p[i])/s[i] + num);
        }
        
        int a = list.get(0);
        int cnt = 0;
        List<Integer> ans = new ArrayList<>();
        for(int v : list){
            if(a >= v){
                cnt++;
            }else{
                ans.add(cnt);
                cnt =1;
                a = v;
            }
        }
        if(cnt != 0){
            ans.add(cnt);
        }
        
        return ans;
    }
}