import java.util.*;

class Solution {
    static ArrayList<Integer>[] adj = new ArrayList[20];
    static int[] arr = new int[4];
    static int ret;
    
    static class Info{
        int sheep, wolf, node;
        HashSet<Integer> vis;
        
        Info(int node, int sheep, int wolf, HashSet<Integer> vis){
            this.node=node;
            this.sheep=sheep;
            this.wolf=wolf;
            this.vis=vis;
        }
    }
    
    public int solution(int[] info, int[][] edges) {
        int answer = 0;
        int n = info.length;
        for(int i=0;i<n;++i){
            adj[i]=new ArrayList<>();
        }
        for(var edge : edges){
            var a = edge[0];
            var b = edge[1];
            adj[a].add(b);
            // adj[b].add(a);
        }
        // for(int i=0;i<n;++i){
        //     System.out.println(adj[i]);
        // }
        // dfs(0,1,0,info,edges);
        
        ArrayDeque<Info> q = new ArrayDeque<>();
        q.offer(new Info(0,1,0,new HashSet<>()));
        
        while(q.size()>0){
            var now = q.poll();
            ret = Math.max(ret, now.sheep);
            now.vis.addAll(adj[now.node]); // 자식들 방문 기록
            
            for(var nxt : now.vis){ // adj(X), now.vis(O)
                var set = new HashSet<>(now.vis);
                
                set.remove(nxt); //자기자신 제거 => 재방문 막기
                
                if(info[nxt] == 1){ //늑대
                    if(now.sheep != now.wolf+1 ) //가능한 경우에만 가기
                        q.offer(new Info(nxt, now.sheep, now.wolf+1, set));
                }
                else{ //양이면 무조건 가셈
                    q.offer(new Info(nxt, now.sheep+1, now.wolf, set));
                }
            }
        }
        
        return ret;
    }
}