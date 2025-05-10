class Solution {
    
    static long MOD = 20170805;
    static long dp[][][] = new long [504][504][4];
    static int n,m;
    static int cityMap[][] = new int[504][504];
    static boolean vis[][] = new boolean[504][504];
    static int dy[]={0,1}; //우, 아, 좌, 위 
    static int dx[]={1,0}; // 주의 : <-, 위로가는거 안됨!
    
    long dfs(int y , int x , int dir){
        if(y==m-1 && x==n-1){
            return 1;
        }
        long ret = dp[y][x][dir];
        if(ret!=-1) return ret;
        
        ret=0;
        vis[y][x]=true;
        for(int i=0;i<2;++i){
            int ny=y+dy[i];
            int nx=x+dx[i];
            if(ny<0 || nx<0 || ny>=m || nx>=n) continue;
            if(vis[ny][nx]) continue;
            if(cityMap[ny][nx]==1) continue;
            
            if(cityMap[y][x]==2){
                //왼쪽에서 오던차(->)는 직진만(->)?
                if(dir==0){
                    if(i==0){
                        ret+=dfs(ny,nx,i);
                    }
                    continue;
                }
                
                //위에서 오던차(|)는 아래로만(|)
                if(dir==1){
                    if(i==1){
                        ret+=dfs(ny,nx,i);
                    }
                    continue;
                }
                continue;    
            }
            
            //그외
            ret += dfs(ny,nx,i)%MOD;
            
            
        }
        vis[y][x]=false;
        
        dp[y][x][dir]=ret%MOD;
        return ret%MOD;
    }
    
    public int solution(int _m, int _n, int[][] _cityMap) {
        for(int i=0;i<504;++i){
            for(int j=0;j<504;++j){
                for(int k=0;k<4;++k){
                    dp[i][j][k]=-1;
                }
            }
        }
        n=_n;
        m=_m;
        cityMap=_cityMap;
        
        return (int)(dfs(0,0,0)%MOD) ;
        
        // return (int)(dfs(0,0,0)%MOD + dfs(0,0,1)%MOD);
    }
}