import java.util.*;

class Solution {
    static class Info{
        int dest,cost;
        Info(int dest, int cost){
            this.dest=dest;
            this.cost=cost;
        }
    }
    static int[] dist = new int[54];
    static ArrayList<Info> adj[] = new ArrayList[54];
    
    public int solution(int N, int[][] road, int K) {
        int answer = 0;

        Arrays.fill(dist,Integer.MAX_VALUE);
        
        
        for(int i=1;i<=N;++i){
            adj[i]=new ArrayList<>();
        }
        
        for(var r: road){
            var from = r[0];
            var to = r[1];
            var cost = r[2];
            adj[from].add(new Info(to,cost)); 
            adj[to].add(new Info(from,cost)); //다익 -> 양방향?
        }
        
        var pq = new PriorityQueue<Info>((a,b)->a.cost-b.cost);
        dist[1]=0;
        pq.add(new Info(1,0)); // (도착지, 비용)
        
        while(pq.size()>0){
            var cur = pq.poll();

            for(var nxt : adj[cur.dest]){
                if(dist[nxt.dest] > cur.cost + nxt.cost){
                    dist[nxt.dest] = cur.cost + nxt.cost;
                    pq.add(new Info(nxt.dest, dist[nxt.dest]));
                }
            }
        }
        
        for(int i=1;i<=N;++i){
            if(dist[i]<=K) answer++;
        }

        return answer;
    }
}