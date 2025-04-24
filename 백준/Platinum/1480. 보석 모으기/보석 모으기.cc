#include<bits/stdc++.h>
using namespace std; 

typedef long long ll;

ll n,m,c;
ll a[24];
ll dp[14][24][1<<14];

//(가방인덱스, 남은용량, 현재까지담은보석집합)
ll dfs(ll idx, int cap , int yam) {
    if(idx==m) {
        return 0;
    }

    ll & ret = dp[idx][cap][yam];
    if(ret!=-1) return ret;

    //현재가방에 보석을 안담는 경우
    ret = max(ret,dfs(idx+1,c,yam)); 

    //담는경우
    for(int i=0;i<n;++i) { //보석하나씩 탐색
        int isBeforeYam = (1<<i) & yam; //이전에 넣었던 가방인가
        int isYam = (cap - a[i]) >=0 ; //넣을수있는 보석인가(용량내)
        if(!isBeforeYam && isYam) {
            ret = max(ret, dfs(idx,cap-a[i],yam | (1<<i))+1); //주의 : idx+1하면안됨
        }
    }
    return ret;
}

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0); cout.tie(0);
    
    memset(dp,-1,sizeof(dp));
    cin>>n>>m>>c;
    for(int i=0;i<n;++i) {
        cin>>a[i];
    }

    cout<<dfs(0,c,0);
    
    return 0;
}