import java.util.*;


class Node{
    int x;
    int y;
    int card;
    int cnt;
    int find;
    boolean[] image;
    boolean[][] visit;
    
    public Node(int x, int y, int card, int cnt, int find, boolean[] image, boolean[][] visit){
        this.x = x;
        this.y=  y;
        this.card =card;
        this.cnt =cnt;
        this.find = find;
        this.image = image;
        this.visit = visit;
    }
}

class Solution {
    int N = 4;
    int[] dx = {1,-1,0,0};
    int[] dy = {0,0,1,-1};
    List<int[]> list = new ArrayList<>();
    int answer= Integer.MAX_VALUE;
    int min = Integer.MAX_VALUE;
    int size;
    public int solution(int[][] board, int r, int c) {
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(board[i][j] != 0){
                    list.add(new int[]{board[i][j], i, j});
                }
            }
        }
        
        size = list.size()/2;
        BFS(board, r, c);
        return answer;
    }
    public int[] getCardLocation(int x, int y, int card){
        for(int[] c : list){
            int rx = c[1];
            int ry = c[2];
            if(!(rx == x && ry == y) && card == c[0]){
                return new int[]{rx,ry};
            }
        }
        // return new int[]{0, 0};
        throw new RuntimeException();
    }
    
    public void BFS(int[][] board, int sx, int sy){
        ArrayDeque<Node> q = new ArrayDeque<>();
        boolean[][] cc = new boolean[N][N];
        cc[sx][sy] = true;
        q.add(new Node(sx, sy, board[sx][sy], 0, 0, new boolean[size], cc));
        while(!q.isEmpty()){
            Node now = q.poll();
            int x = now.x;
            int y = now.y;
            int card = now.card;
            int cnt = now.cnt;
            int find = now.find; 
            boolean[][] visit = now.visit;
            boolean[] image = now.image;
            if(find == size){
                answer= Math.min(cnt, answer);
                continue;
            }
            if(card > 0 && !image[card-1]){
                min = Integer.MAX_VALUE;
                int[] pair = getCardLocation(x, y, card);
                boolean[][] visit2 = new boolean[N][N];
                visit2[x][y] = true;
                
                int[][] copyBoard = new int[4][4];
                for(int i =0 ; i < 4 ;i++){
                    for(int j = 0; j < 4 ;j++){
                        if(board[i][j] > 0 && !image[board[i][j] - 1]){
                            copyBoard[i][j] = board[i][j];
                        }
                    }
                }
                
                DFS(x, y, pair[0], pair[1], card, visit2, copyBoard, 0 , image);
                
                
                boolean[] copyImage = Arrays.copyOf(image, image.length);
                copyImage[card-1]= true;
                
                boolean[][] nextVisit = new boolean[N][N];
                nextVisit[pair[0]][pair[1]] = true;
                
                q.add(new Node(pair[0], pair[1], 0, cnt + min + 2, find + 1, copyImage, nextVisit));
                continue;
            }
            
             for(int i =0 ; i < 4; i++){
                int[] next= ctrlMove(x, y, i, board, visit, image);
                int nx= next[0];
                int ny = next[1];
                if(nx == x && ny == y) continue;
                if(isRange(nx ,ny) && !visit[nx][ny]){
                    visit[nx][ny] = true;
                    q.add(new Node(nx, ny, board[nx][ny], cnt + 1, find, image, visit));
                }
            }
            for(int i =0 ; i < 4; i++){
                int nx = dx[i] + x;
                int ny = dy[i] + y;
                if(isRange(nx , ny) && !visit[nx][ny]){
                    visit[nx][ny] = true;
                    q.add(new Node(nx, ny, board[nx][ny], cnt + 1, find, image, visit));
                }
            }
            
            
          
            
       
            
         
           //  for(int i =0 ; i < 4; i++){
           //      System.out.println(Arrays.toString(visit[i]));
           //  }
           // System.out.println();
        }
    
    }
    public int[] ctrlMove(int x, int y, int num, int[][] board, boolean[][] visit, boolean[] image){
        if(num == 0){
            for(int i = x - 1; i >= 0; i--){
                if(board[i][y] != 0 && !visit[i][y] && !image[board[i][y] - 1]){
                    return new int[]{i, y};
                }
            }
            return new int[]{0, y};
        }else if(num == 1){
            for(int i = x + 1; i < N; i++){
                if(board[i][y] != 0 && !visit[i][y] && !image[board[i][y] - 1]){
                    return new int[]{i, y};
                }
            }
            return new int[]{N - 1, y};            
            
        }else if(num == 2){
            for(int i = y - 1; i >= 0; i--){
                if(board[x][i] != 0 && !visit[x][i] && !image[board[x][i] - 1]){
                    return new int[]{x, i};
                }
            }
            return new int[]{x, 0};             
        }else if(num == 3){
            for(int i = y + 1; i < N; i++){
                if(board[x][i] != 0 && !visit[x][i] && !image[board[x][i] - 1]){
                    return new int[]{x, i};
                }
            }
            return new int[]{x, N - 1};             
        }
        throw new RuntimeException();
    }
    
    
    public void DFS(int x, int y, int rx, int ry, int card, boolean[][] visit, int[][] board, int cnt, boolean[] image){
        if(cnt > min) return;
        if(x == rx && y == ry){
            min = Math.min(min, cnt);
            return;
        }
        
       for(int i =0 ; i < 4; i++){
            int nx = dx[i] + x;
            int ny = dy[i] + y;
            if(isRange(nx, ny) && !visit[nx][ny]){
                visit[nx][ny] = true;
                int[] p = new int[]{nx,ny};
                DFS(nx, ny, rx, ry, card, visit, board, cnt+ 1, image);
                visit[nx][ny] = false;
            }
        }
        
        for(int i =0 ; i < 4; i++){
            int[] next= ctrlMove(x, y, i, board, visit ,image);
            int nx= next[0];
            int ny = next[1];
            if(nx == x && ny == y) continue;
            if(isRange(nx, ny) && !visit[nx][ny]){
                visit[nx][ny] = true;
                DFS(nx, ny, rx, ry, card, visit, board, cnt+ 1, image);
                visit[nx][ny] = false;                
            }
        }       
        
     
    }
    
    public boolean isRange(int x, int y){
        return x >=0 && x < N && y>=0 && y < N;
    }
    
}