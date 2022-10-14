class Solution {
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        char[][] map = new char[m][n]; // [y][x]
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                map[i][j] = board[i].charAt(j);
            }
        }
        
        while(true) {
            int cnt = checkBlock(m, n, map);
            if(cnt == 0)
                break;
            
            answer += cnt;
            dropBlock(m, n, map);
        }
        
        return answer;
    }
    
    int checkBlock(int m, int n, char[][] map) {
        int cnt = 0;
        boolean[][] visited = new boolean[m][n];
        
        for(int i = 0; i < m - 1; i++) {
            for(int j = 0; j < n - 1; j++) {
                if(map[i][j] == '0')
                    continue;
                
                checkFour(map, visited, i, j);
            }
        }
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(visited[i][j]) {
                    cnt++;
                    map[i][j] = '0';
                }
            }
        }
        
        return cnt;
    }
    
    void checkFour(char[][] map, boolean[][] visited, int i, int j) {
        char c = map[i][j];
        
        for(int y = i; y < i + 2; y++) {
            for(int x = j; x < j + 2; x++) {
                if(c != map[y][x])
                    return;
            }
        }
        
        for(int y = i; y < i + 2; y++) {
            for(int x = j; x < j + 2; x++) {
                visited[y][x] = true;
            }
        }
    }
    
    void dropBlock(int m, int n, char[][] map) {
        for(int x = 0; x < n; x++) {
            for(int y = m - 1; y >= 0; y--) {
                if(map[y][x] == '0') {
                    for(int ny = y - 1; ny >= 0; ny--) {
                        if(map[ny][x] != '0') {
                            map[y][x] = map[ny][x];
                            map[ny][x] = '0';
                            break;
                        }
                    }
                }
            }
        }
    }
    
    
}