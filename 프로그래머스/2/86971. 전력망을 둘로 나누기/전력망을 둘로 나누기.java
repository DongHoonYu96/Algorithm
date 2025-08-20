import java.util.*;

class Solution {
    static ArrayList<Integer>[] adj = new ArrayList[104];
    static int[][] graph = new int[104][104];
    static boolean[] vis = new boolean[104];
    static int n;
    
    int dfs(int node){
        vis[node]=true;
        
        int ret=1;
        for(int i=1;i<=n;++i){
            if(vis[i]) continue;
            
            if(graph[node][i]==1){
                ret+=dfs(i);
            }
        }
        return ret;
        
    }
    
    public int solution(int N, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        n=N;
        for(int i=0;i<104;++i){
            adj[i]=new ArrayList<>();
        }
        for(var wire : wires){
            int from = wire[0];
            int to  = wire[1];
            adj[from].add(to);
            adj[to].add(from);
            graph[from][to]=1;
            graph[to][from]=1;
        }
        // for(int i=1;i<n;++i){
        //     System.out.println(adj[i]);
        // }
        
        // 연결끊을 index 고르기
        // 연결끊기
        // dfs
        // 원상복구
        for(int i=0;i<wires.length;++i){
            int from = wires[i][0];
            int to = wires[i][1];
            
            graph[from][to]=0;
            graph[to][from]=0;
            
            Arrays.fill(vis,false);
            var v = new ArrayList<Integer>();
            for(int j=1;j<=n;++j){
                if(vis[j]) continue;
                
                v.add(dfs(j));
            }
            
            graph[from][to]=1;
            graph[to][from]=1;
            
            // System.out.println(v.get(0) +" " + v.get(1));
            answer = Math.min(answer,Math.abs(v.get(0)-v.get(1)));
        }
        return answer;
    }
}