import java.util.*;

class Solution {
    
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        graph = new ArrayList[n];
        for (int i =0 ;i <n;i++){
            graph[i] = new ArrayList<>();
        }
        
        for (int i =0;i <n;i++){
            for (int j = 0 ;j <n;j++){
                if (computers[i][j] == 1){
                    graph[i].add(j);
                    graph[j].add(i);
                }
            }
        }
        
        visited = new boolean[n];
        
        for (int i = 0 ;i <n;i++){
            if (!visited[i]){
                BFS(i);
                answer++;
            }
        }
        
        return answer;
    }
    
    static void DFS(int cur){
        visited[cur] = true;
        
        for (int next : graph[cur]){
            if (!visited[next]){
                DFS(next);
            }
        }
    }
    
    static void BFS(int cur){
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.add(cur);
        visited[cur] = true;
        
        while (!queue.isEmpty()){
            int c = queue.poll();
            
            for (int next : graph[c]){
                if (!visited[next]){
                    visited[next] = true;
                    queue.add(next);
                }
            }
        }
    }
}