import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        //큰 것부터 함녀 되네
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int v : tangerine){
            map.put(v, map.getOrDefault(v, 0) + 1);
        }
        List<Integer> list = new ArrayList<>();
        for(int v : map.values()){
            list.add(v);
        }
        Collections.sort(list, Collections.reverseOrder());
        
        int cnt =0;
        for(int v :list){
            k-=v;
            cnt++;
            if(k <= 0){
                break;
            }
        }
        
        return cnt;
    }
}