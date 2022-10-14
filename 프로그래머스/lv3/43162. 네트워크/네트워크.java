class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];
        
        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                DFS(n, i, computers, visited);
                answer++;
            }
        }
        
        return answer;
    }
    
    public static void DFS(int n, int idx, int[][] computers, boolean[] visited) {
        visited[idx] = true;
        
        for(int i = 0; i < n; i++) {
            if(computers[idx][i] == 0 || i == idx)
                continue;
            
            if(computers[idx][i] == 1 && !visited[i])
                DFS(n, i, computers, visited);
        }
    }
}