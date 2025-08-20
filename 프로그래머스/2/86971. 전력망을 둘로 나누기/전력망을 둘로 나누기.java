import java.util.*;

class Solution {
    static ArrayList<Integer>[] adj = new ArrayList[104];
    static int[][] graph = new int[104][104];
    static boolean[] vis = new boolean[104];
    static int n;
    static int answer = Integer.MAX_VALUE;
    
    int dfs(int node){
        vis[node]=true;
        
        int child=1; // 자기자신 카운팅
        
        for(var nxt : adj[node]){
            if(vis[nxt]) continue;
            
            child+=dfs(nxt);
        }
        
        answer = Math.min(answer,Math.abs((n-child)-child));
        return child;
    }
    
    public int solution(int N, int[][] wires) {
        
        n=N;
        for(int i=0;i<104;++i){
            adj[i]=new ArrayList<>();
        }
        for(var wire : wires){
            int from = wire[0];
            int to  = wire[1];
            adj[from].add(to);
            adj[to].add(from);
        }

        dfs(1);
        
        return answer;
    }
}