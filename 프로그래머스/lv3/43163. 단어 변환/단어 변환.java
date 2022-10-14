import java.util.*;

class node {
    int idx, move;
    
    node(int idx, int move) {
        this.idx = idx;
        this.move = move;
    }
}

class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        int N = words.length;
        boolean[] visited = new boolean[N]; // BFS
        boolean[][] checked = new boolean[N][N]; // 변경 가능 여부
         
        int cnt = 0; // begin -> words 가능한 것 확인 
        for(int i = 0; i < N; i++) { 
            if(target.equals(words[i]))
                cnt++;
        }
        if(cnt == 0)
            return 0;
        
        for(int i = 0; i < N; i++) { // words[i] <-> word[j] 변경 가능한지 확인
            for(int j = 0; j < N; j++) {
                if(i == j || checked[i][j]) 
                    continue;
                
                int comp = 0;
                for(int k = 0; k < begin.length(); k++) {
                    if(words[i].charAt(k) == words[j].charAt(k)) 
                        continue;
                    else
                        comp++; // 다른 알파벳 개수
                }
                if(comp == 1) {
                    checked[i][j] = checked[j][i] = true;
                }
            }
        }
        
        // begin -> words[i] 가능한 것 확인
        Queue<node> q = new LinkedList<>();
        for(int i = 0; i < N; i++) {
            cnt = 0;
            for(int j = 0; j < begin.length(); j++) {
                if(begin.charAt(j) == words[i].charAt(j))
                    continue;
                else
                    cnt++;
            }
            if(cnt == 1) {
                visited[i] = true;
                q.add(new node(i, 1));
            }
        }
    
        while(!q.isEmpty()) {
            node cur = q.poll();
            
            if(words[cur.idx].equals(target)) {
                answer = cur.move;   
                break;
            }
            
            for(int i = 0; i < N; i++) {
                boolean check = checked[cur.idx][i]; 
                
                if(!check || cur.idx == i)
                    continue;
                
                if(!visited[i]) {
                    visited[i] = true;
                    q.add(new node(i, cur.move + 1));
                }
            }
        }
        
        return answer;
    }
    
}