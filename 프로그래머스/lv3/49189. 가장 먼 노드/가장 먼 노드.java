import java.util.*;

class node {
    int idx, dist;
    
    node(int idx, int dist) {
        this.idx = idx;
        this.dist = dist;
    }
}

class Solution {
    ArrayList<Integer>[] map;
    
    public int solution(int n, int[][] edge) {
        int answer = 0;
        int max = Integer.MIN_VALUE;
        int[] dist = new int[n + 1];
        boolean[] visited = new boolean[n + 1];
        
        map = new ArrayList[n + 1];
        for(int i = 1; i <= n; i++)
            map[i] = new ArrayList<>();
        
        for(int i = 0; i < edge.length; i++) {
            int u = edge[i][0];
            int v = edge[i][1];
            
            map[u].add(v);
            map[v].add(u);
        }
        
        for(int i = 1; i <= n; i++)
            Collections.sort(map[i]);
        
        Queue<node> q = new LinkedList<>();
        q.add(new node(1, 0));
        visited[1] = true;
        
        while(!q.isEmpty()) {
            node cur = q.poll();
            
            max = Math.max(max, cur.dist);
            dist[cur.idx] = cur.dist;
            
            for(int next : map[cur.idx]) {
                if(!visited[next]) {
                    visited[next] = true;
                    q.add(new node(next, cur.dist + 1));
                }
            }
        }
        
        for(int i = 1; i <= n; i++) {
            if(max == dist[i])
                answer++; 
        }
        
        return answer;
    }
}