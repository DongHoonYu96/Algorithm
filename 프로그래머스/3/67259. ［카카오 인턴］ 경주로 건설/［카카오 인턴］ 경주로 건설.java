import java.util.*;

class Solution {
    static class Info{
        int y,x,cost,dir;
        Info(int y, int x, int cost, int dir){
            this.y=y;
            this.x=x;
            this.cost=cost;
            this.dir=dir;
        }
        
        public String toString(){
            return this.y+" "+this.x+" "+this.cost+" "+this.dir;
        }
    }
    static int[] dy = {1,0,-1,0}; //아래, 오른쪽, 위, 좌
    static int[] dx = {0,1,0,-1};

    
    public int solution(int[][] board) {
        int answer = Integer.MAX_VALUE;
        int n = board.length;
        int[][][] vis = new int[n][n][4]; // 방향정보도 추가해야함! (다른방향이면 다른상태임)
        var q = new ArrayDeque<Info>();
        q.add(new Info(0,0,0,0)); //아래
        q.add(new Info(0,0,0,1)); //오른쪽
        vis[0][0][0]=0;
        vis[0][0][1]=0;
        
        while(q.size()>0){
            var cur = q.poll();
            int y = cur.y;
            int x = cur.x;
            int cost = cur.cost;
            int dir = cur.dir;
            
            // System.out.println(cur);
            
            if(y==n-1 && x==n-1){
                answer = Math.min(answer,cost);
                // return cost;
            }
            
            for(int i=0;i<4;++i){
                int ny=y+dy[i];
                int nx=x+dx[i];
                if(ny<0 || ny>=n || nx<0 || nx>=n) continue;
                if(ny==0 && nx==0) continue;
                if(board[ny][nx]==1) continue;
                if(Math.abs(i-dir)==2) continue; // 반대방향
                
                
                int nextCost=0;
                if(dir != i){
                    nextCost = cost + 600; // 직선도로도 만들어야함
                }
                else{
                    nextCost = cost + 100;
                }
                
                // 이미 방문했어도, 비용이 작다면 재방문 필요!!!
                if(vis[ny][nx][i]==0 || vis[ny][nx][i] > nextCost) {
                    q.add(new Info(ny,nx,nextCost, i));
                    vis[ny][nx][i]=nextCost;
                }
                
                
            }
        }
        
        return answer;
    }
}