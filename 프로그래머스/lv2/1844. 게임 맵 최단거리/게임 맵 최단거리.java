import java.util.*;

class node {
    int y, x;
    
    node(int y, int x) {
        this.y = y;
        this.x = x;
    }
}

class Solution {
    static int[] dy = {-1, 1, 0, 0}; // 상, 하, 좌, 우
    static int[] dx = {0, 0, -1, 1}; 
    static boolean[][] visited;
    
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        visited = new boolean[n][m];
        Queue<node> q = new LinkedList<>();
        
        q.add(new node(0, 0));
        visited[0][0] = true;
        
        while(!q.isEmpty()) {
            node cur = q.poll();
            
            for(int i = 0; i < 4; i++) {
                int ny = cur.y + dy[i];
                int nx = cur.x + dx[i];
                
                if(ny < 0 || ny >= n || nx < 0 || nx >= m)
                    continue;
                
                if(maps[ny][nx] == 1 && !visited[ny][nx]) {
                    q.add(new node(ny, nx));
                    maps[ny][nx] = maps[cur.y][cur.x] + 1;
                    visited[ny][nx] = true;
                }
            }
            
        }
        
        return maps[n - 1][m - 1] == 1 ? -1 : maps[n - 1][m - 1];
    }
}