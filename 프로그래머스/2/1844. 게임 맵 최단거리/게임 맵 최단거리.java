import java.util.*;

class Solution {
    
    static class Info{
        int y,x;
        Info(int y, int x){
            this.y=y;
            this.x=x;
        }
    }
    
    static int[] dy = {0,1,-1,0};
    static int[] dx = {1,0,0,-1};
    static int[][] vis = new int[104][104];
    
    public int solution(int[][] maps) {
        int answer = -1;
        int n = maps.length;
        int m =maps[0].length;
        
        var q = new ArrayDeque<Info>();
        
        // System.out.println(Arrays.deepToString(vis));
        q.add(new Info(0,0));
        vis[0][0]=1;
        
        while(q.size()>0){
            var cur = q.poll();
            var y = cur.y;
            var x = cur.x;
            
            for(int i=0;i<4;++i){
                int ny = y+dy[i];
                int nx = x+dx[i];
                
                if(ny>=n || ny<0 || nx>=m || nx<0) continue;
                if(maps[ny][nx]==0) continue;
                if(vis[ny][nx]>0) continue;
                
                q.add(new Info(ny,nx));
                vis[ny][nx] = vis[y][x]+1;
            }
        }
        
        if (vis[n-1][m-1] > 0) return vis[n-1][m-1];
        return -1;
    }
}