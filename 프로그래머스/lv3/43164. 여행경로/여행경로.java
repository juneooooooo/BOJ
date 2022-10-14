import java.util.*;

class Solution {
    static ArrayList<String> routes = new ArrayList<>();
    static boolean[] visited;
    
    public String[] solution(String[][] tickets) {    
        visited = new boolean[tickets.length]; // i 번째 티켓 사용 여부 확인
        
        DFS("ICN", "ICN", 0, tickets);
        
        Collections.sort(routes);
        
        String[] answer = routes.get(0).split(" ");
        
        return answer;
    }
    
    public static void DFS(String cur, String s, int depth, String[][] tickets) {
        if(depth == tickets.length) {
            routes.add(s);
            return;
        }
        
        for(int i = 0; i < tickets.length; i++) {
            if(!visited[i] && tickets[i][0].equals(cur)) {
                visited[i] = true;
                DFS(tickets[i][1], s + " " + tickets[i][1], depth + 1, tickets);
                visited[i] = false;
            }
        }
    }
}