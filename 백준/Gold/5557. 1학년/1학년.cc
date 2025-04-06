#include<bits/stdc++.h>
using namespace std; 

typedef long long ll;

int n;
int arr[104];
ll dp[104][24]; //(idx, num) : 그떄 경우의수

ll dfs(int idx, int num) {
    if(num <0 || num >20) {
        return 0;
    }
    
    if(idx==n-1) {
        if(num==arr[idx]) {
            // cout<<idx<<" "<<num<<"\n"; 
            return 1;
        }
        return 0;
    }
    
    ll & ret = dp[idx][num];

    if(ret!=-1) {
        return ret;
    }

    ret=0;
    ret+=dfs(idx+1,num+arr[idx]);
    ret+=dfs(idx+1,num-arr[idx]);
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
    
    // cout<<dfs(0,0);
    // 안되는 이유 : 첫숫자를 2번사용하게됨.?

    cout << dfs(1, arr[0]);
    
    return 0;
}