#include<bits/stdc++.h>
using namespace std; 

typedef long long ll;

ll n;
ll dp[10004][4];
ll arr[10004];

//인덱스, 연속선택카운트
ll dfs(int idx, int cnt) {
    


    if(cnt>=3) {
        return -987654321; //배제
    }

    if(idx==n) {
        return 0;
    }

    ll & ret = dp[idx][cnt];
    if(ret!=-1) return ret;
    
    //선택
    ret=max(ret,dfs(idx+1,cnt+1)+arr[idx]);

    //안선택
    ret=max(ret,dfs(idx+1,0));

    return ret;
}

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0); cout.tie(0);

    memset(dp,-1,sizeof(dp));
    
    cin>>n;
    for(int i=0;i<n;++i) {
        cin>>arr[i];
    }
    cout<<dfs(0,0);
    
    return 0;
}