import java.util.*;

class Solution {
    static int[] vis = new int[204];
    
    void dfs(int cur, int[][] computers){
        vis[cur]=1;
        
        
        int n = computers[cur].length;
        
        for(int i=0;i<n;++i){
            var nxt = computers[cur][i] == 1 ? i : -1;
            if(nxt==-1) continue;
            if(vis[nxt]>0) continue;
            dfs(nxt,computers);
        }
        // for(var nxt : computers[cur]){
        //     if(vis[nxt]>0) continue;
        //     dfs(nxt,computers);
        // }
    }
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        for(int i=0;i<n;++i){
            if(vis[i]>0) continue;
            dfs(i,computers);
            answer++;
        }
        return answer;
    }
}