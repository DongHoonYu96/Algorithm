#include <bits/stdc++.h>

using namespace std;
typedef long long ll;

int m, n; 
vector<vector<int>> puddles;
ll mod = 1000000007;
ll ret;
ll dp[104][104], a[104][104];

ll dfs(int y, int x){
    if(y<0 || x<0 || y>n || x>m){
        return 0;
    }
    if(a[y][x]==-1){
        return 0;
    }
    if(y==n && x==m){
        return 1;
    }
    
    ll & ret=dp[y][x];
    if(ret!=-1){
        return ret;
    }
    
    ret = 0;
    ret = (dfs(y+1,x) + dfs(y,x+1))%mod;
    
    return ret;
}

int solution(int _m, int _n, vector<vector<int>> _puddles) {
    m=_m;
    n=_n;
    puddles=_puddles;
    memset(dp,-1,sizeof(dp));
    //1-idx 임
    for(auto puddle : puddles){
        a[puddle[1]][puddle[0]]=-1; //물 표시
    }
    return dfs(1,1);
}