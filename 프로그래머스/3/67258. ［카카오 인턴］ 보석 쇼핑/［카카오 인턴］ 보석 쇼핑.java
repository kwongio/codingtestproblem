import java.util.*;


class Solution {
    public int[] solution(String[] gems) {
        Set<String> types= new HashSet<>(Arrays.asList(gems));
        int N = types.size();
        int s= 0;
        int e =0;
        int start = 0;
        int end = 0;
        
        Map<String, Integer> map = new HashMap<>();
        int minLen = Integer.MAX_VALUE;
        
        while(e < gems.length){
            
            map.put(gems[e], map.getOrDefault(gems[e], 0) + 1);
            
            while(map.size() == N){
                if(e - s < minLen){
                    minLen = e - s;
                    start = s ;
                    end = e;
                }
                map.put(gems[s], map.get(gems[s]) - 1);
                if(map.get(gems[s]) == 0){
                    map.remove(gems[s]);
                }
                s++;
            }
            e++;
        }
        
        return new int[]{start + 1 ,end + 1};
    }
}