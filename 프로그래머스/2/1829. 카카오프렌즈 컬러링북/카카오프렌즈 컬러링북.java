import java.util.*;

class Solution {
    
    static boolean vis[][] = new boolean[104][104];
    static int ret1,ret2,m,n;
    static int dy[] = {1,0,-1,0};
    static int dx[] = {0,1,0,-1};
    static int picture[][];
    
    int dfs(int y, int x, int cnt, int val){
        vis[y][x]=true;
        
        int ret=1;
        for(int i=0;i<4;++i){
            int ny=y+dy[i];
            int nx=x+dx[i];
            if(ny<0 || nx<0 || ny>=m || nx>=n) continue;
            if(picture[ny][nx]!=val) continue;
            if(vis[ny][nx]) continue;
            
            ret+=dfs(ny,nx,cnt+1,val);
        }
        
        return ret;
        
    }
    
    public int[] solution(int _m, int _n, int[][] _picture) {
        picture = _picture;
        m=_m;
        n=_n;
        ret1=0;
        ret2=0;
        dy = new int[] {1,0,-1,0};
        dx = new int[] {0,1,0,-1};
        
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                vis[i][j] = false;
            }
        }
        
        for(int i=0;i<m;++i){
            for(int j=0;j<n;++j){
                if(picture[i][j]==0) continue;
                if(vis[i][j]) continue;
                ret2 = Math.max(ret2,dfs(i,j,0,picture[i][j]));
                ret1++;
            }
        }

        int[] answer = new int[2];
        answer[0] = ret1;
        answer[1] = ret2;
        return answer;
    }
}