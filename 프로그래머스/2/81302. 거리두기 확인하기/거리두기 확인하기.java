import java.util.*;

class A{
    int y,x,dist;
    A(int y, int x, int dist){
        this.y=y;
        this.x=x;
        this.dist=dist;
    }
}

class Solution {
    
    static int[] dy={0,1,-1,0};
    static int[] dx={1,0,0,-1};
    
    void dfs(int y, int x, String[] place){
        if(y<0 || x<0 || y>=5 || x>=5){
            return;
        }
        
        if(place[y].charAt(x)=='X'){
            
        }
    }
    
    boolean bfs(int yy, int xx, String[] place){
        Queue<A> q = new LinkedList<>();
        q.offer(new A(yy,xx,0));
        boolean[][] vis = new boolean[5][5];
        vis[yy][xx]=true;
        
        while(q.size()>0){
            A a = q.poll();
            int y = a.y;
            int x = a.x;
            int dist = a.dist;
            vis[y][x]=true;
            
            if(dist>2) continue;
            if(dist!=0 && place[y].charAt(x)=='P') return false;
            
            for(int i=0;i<4;++i){
                int ny=y+dy[i];
                int nx = x+dx[i];
                if(ny<0 || nx<0 || ny>=5 || nx>=5) continue;
                if(vis[ny][nx]) continue;
                if(place[ny].charAt(nx)=='X') continue;
                // if(place[ny].charAt(nx)=='P') return false;
                q.offer(new A(ny,nx,dist+1));
            }
        }
        return true;
    }
    
    boolean go(String[] place){
        for(int i=0;i<5;++i){
            for(int j=0;j<5;++j){
                if(place[i].charAt(j)=='P'){
                    if(!bfs(i,j,place)){
                        return false;
                    }
                }
            }
        }
        return true;
    }
    
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        
        // System.out.println(places[0][1]);
        
        int idx=0;
        for(String[] place : places){
            // System.out.println(place[0]);
            if(go(place)){
                answer[idx]=1;   
            }
            idx++;
        }
        return answer;
    }
}