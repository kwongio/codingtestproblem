import java.util.*;
class Solution {
    public int solution(int[][] jobs){ 
        PriorityQueue<int[]> q = new PriorityQueue<>((o1, o2)-> o1[1] - o2[1]);
        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);
        int answer = 0;
        int i = 0;
        int time =0;
        int cnt = 0;
        while(cnt != jobs.length){
            while(i < jobs.length && jobs[i][0] <= time){
                q.add(jobs[i]);
                i++;
            }
            
            if(!q.isEmpty()){
                int[] job = q.poll();
                System.out.println(job[0] + " " + job[1]);
                time += job[1];
                answer +=time - job[0];
                cnt++;
            }else{
                time++;                
            }
        
        }
        return answer/jobs.length;
    }
}