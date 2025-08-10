import java.util.*;

class Solution {
    static class Info{
        int y, x;
        Info(int y, int x){
            this.y=y;
            this.x=x;
        }
    }
    static char[][] arr = new char[104][104];
    static int[][] vis = new int[104][104];
    static int[] dy = {0,1,0,-1};
    static int[] dx = {1,0,-1,0};
    
    public int solution(String[] maps) {
        int answer = 0;
        
        int idx=0;
        for(var map : maps){
            var m = map.toCharArray();
            arr[idx]=m;
            // System.out.println((m));
            ++idx;
        }
        int n = maps.length;
        int m = maps[0].length();
        
        int sy=0;
        int sx=0;
        int ly=0;
        int lx=0;
        int ey=0;
        int ex=0;
        for(int i=0;i<n;++i){
            for(int j=0;j<m;++j){
                if(arr[i][j]=='S'){
                    sy=i;
                    sx=j;
                    
                }
                if(arr[i][j]=='L'){
                    ly=i;
                    lx=j;
                    
                }
                if(arr[i][j]=='E'){
                    ey=i;
                    ex=j;
                }
            }
        }
        
        ArrayDeque<Info> q = new ArrayDeque<>();
        q.add(new Info(sy,sx));
        vis[sy][sx]=1;
        // System.out.println(sy+" "+sx);
        
        //s -> 레버 -> e로 가는 최단경로 구하기
        boolean reachableLever = false;
        while(q.size()>0){
            var cur = q.poll();
            var y = cur.y;
            var x = cur.x;
            if(arr[y][x]=='L'){
                answer+= vis[y][x]-1;
                reachableLever=true;
                break;
            }
            
            for(int i=0;i<4;++i){
                int ny=y+dy[i];
                int nx = x+dx[i];
                if(ny>=n || ny<0 || nx>=m || nx<0) continue;
                if(vis[ny][nx]>0) continue;
                if(arr[ny][nx]=='X') continue;
                
                q.add(new Info(ny,nx));
                vis[ny][nx] = vis[y][x]+1;
            }
        }
        
        if(reachableLever==false) return -1;
        
        q.clear();
        q.add(new Info(ly,lx));
        Arrays.stream(vis).forEach(e -> Arrays.fill(e,0));
        vis[ly][lx]=1;
        boolean reachableExit=false;
        while(q.size()>0){
            var cur = q.poll();
            var y = cur.y;
            var x = cur.x;
            if(arr[y][x]=='E'){
                answer+= vis[y][x]-1;
                reachableExit=true;
                break;
            }
            
            for(int i=0;i<4;++i){
                int ny=y+dy[i];
                int nx = x+dx[i];
                if(ny>=n || ny<0 || nx>=m || nx<0) continue;
                if(vis[ny][nx]>0) continue;
                if(arr[ny][nx]=='X') continue;
                
                q.add(new Info(ny,nx));
                vis[ny][nx] = vis[y][x]+1;
            }
        }
        
        // System.out.println(Arrays.deepToString(arr));
        return reachableExit==true? answer : -1;
    }
}