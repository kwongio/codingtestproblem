import java.util.*;

class Solution {
    public List<Integer> solution(int N, int[] stages) {
        int[] cnt = new int[N + 1];
        for(int i = 0; i < stages.length; i++){
            int v=  stages[i];
            if(v == N + 1) continue;
            cnt[v]++;
        }
        double total = stages.length;
        List<Node> list = new ArrayList<>();
        for(int i = 1; i <= N; i++){
            if(cnt[i] == 0){
                list.add(new Node(i, 0));
            }else{
                double fail = cnt[i]/total;
            total-= cnt[i];
            list.add(new Node(i, fail));
            }
            
        }
       list.sort((o1, o2) -> {
            int compare = Double.compare(o2.fail, o1.fail); 
            if (compare == 0) {
                return Integer.compare(o1.stage, o2.stage);
            }
            return compare;
        });

        
        List<Integer> ans = new ArrayList<>();
        for(Node n : list){
            ans.add(n.stage);
        }
        
        return ans;
    }
    
    class Node{
        int stage;
        double fail;
        
        public Node(int stage, double fail){
            this.stage = stage;
            this.fail = fail;
        }
    }
}