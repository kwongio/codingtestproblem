import java.util.*;
class Solution {
    static int[][] map;
    static int N;
    public int[] solution(String[] id_list, String[] report, int k) {
        N = id_list.length;
        map = new int[N][N];
        for(int i = 0; i <report.length; i++){
            String name[] = report[i].split(" ");
            String reporter = name[0];
            String reported = name[1];
            map[getIndex(reporter , id_list)][getIndex(reported , id_list)]++;
        }
        // for(int i = 0; i < N; i++){
        //     for(int j = 0; j < N; j++){
        //         System.out.print(map[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        List<Integer> mail = new ArrayList<>();
        for(int i = 0; i < N; i++){
            int count = 0;
            for(int j = 0; j < N; j++){
                if(map[j][i] >= 1){
                    count++;
                    if(count ==k){
                        mail.add(i);
                        break;
                    }
                }
            }
        }
        int[] answer = new int[N];
        for(int j : mail){
          for(int i = 0; i < N; i++){
              if(map[i][j] >= 1){
                  answer[i]++;
              }
          }
        }
        
        
        
        return answer;
    }
    static int getIndex(String name, String[] id_list ){
        for(int i = 0; i < id_list.length; i++){
            if(id_list[i].equals(name)){
                return i;
            }
        }
        return -1;
    }
}