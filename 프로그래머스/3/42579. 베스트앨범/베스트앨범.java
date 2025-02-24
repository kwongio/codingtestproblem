import java.util.*;

class Solution {
    public List<Integer> solution(String[] g, int[] p) {
        Map<String, List<int[]>> gMap= new HashMap<>();
        Map<String, Integer> playMap = new HashMap<>();
        for(int i = 0; i < g.length; i++){
            if(!gMap.containsKey(g[i])){
                gMap.put(g[i], new ArrayList<>());
                playMap.put(g[i], 0);
            }
            playMap.put(g[i], playMap.get(g[i]) + p[i]);
            List<int[]> gList = gMap.get(g[i]);
            gList.add(new int[]{i, p[i]});
            gMap.put(g[i], gList);
        }
        List<String> list = new ArrayList<>(playMap.keySet());
        list.sort((o1, o2) -> playMap.get(o2) - playMap.get(o1));
        
        List<Integer> answer = new ArrayList<>();
        for(String s : list){
            List<int[]> gList = gMap.get(s);
            gList.sort((o1, o2) -> {
                if(o1[1] == o2[1]){
                    return o1[0] - o2[0];
                }
                return o2[1] - o1[1];
            });
            int cnt =0 ;
            for(int[] v : gList){
                if(cnt == 2){
                    break;
                }
                answer.add(v[0]);
                cnt++;
            }
        }
        
        
        
        return answer;
    }
}