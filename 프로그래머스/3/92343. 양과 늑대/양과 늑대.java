import java.util.*;

class Solution {
    List<Integer>[] tree;
    int max = 0;
    public int solution(int[] info, int[][] edges) {
        tree = new List[info.length];
        for(int i =0 ; i < info.length; i++){
            tree[i] = new ArrayList<>();
        }
        
        for(int i =0 ; i < edges.length; i++){
            int s = edges[i][0];
            int e = edges[i][1];
            tree[s].add(e);
        }
        
        ArrayDeque<Node> q = new ArrayDeque<>();
        Set<Integer> v = new HashSet<>();
        q.add(new Node(0, 1, 0,new HashSet<>()));
        while(!q.isEmpty()){
            Node node = q.poll();
            int cur = node.node;
            int sheep = node.sheep;
            int wolf = node.wolf;
            node.visit.addAll(tree[cur]);
            max = Math.max(sheep, max);
            for(int next: node.visit){
                Set<Integer> newVisit= new HashSet<>(node.visit);
                newVisit.remove(next);
               if(info[next] == 1){
                   if(sheep != wolf + 1){
                       q.add(new Node(next, sheep, wolf + 1,newVisit));
                   }
               }else{
                   q.add(new Node(next, sheep + 1, wolf,newVisit));
               }
            }
        }
        return max;
    }
    
    class Node{
        int node;
        int sheep;
        int wolf;
        Set<Integer> visit;
        public Node(int node, int sheep, int wolf, Set<Integer> visit){
            this.node = node;
            this.sheep = sheep;
            this.wolf = wolf;
            this.visit = visit;
        }
    }
}