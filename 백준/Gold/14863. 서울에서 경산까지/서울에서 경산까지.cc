#include<bits/stdc++.h>
using namespace std; 

typedef long long ll;

struct A {
    int a,b,c,d;
};

int n,k,ret;
ll dp[104][100000+4]; //(idx, num) : 그떄 경우의수
vector<A> v;

ll dfs(int idx, int cnt) {
    if(cnt < 0 ) {
        return -987654321; //배제
    }
    if(idx==n) {
        return 0;
    }

    // cout<<idx<<" "<<cnt<<"\n";
    
    ll & ret = dp[idx][cnt];

    if(ret!=-1) {
        return ret;
    }

    //초기화 : !!!불가능한값!!!!
    ret=-987654321;
    ret=max(ret,dfs(idx+1,cnt-v[idx].a) + v[idx].b);
    ret=max(ret,dfs(idx+1,cnt-v[idx].c) + v[idx].d);
    return ret;
}

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0); cout.tie(0);

    memset(dp,-1,sizeof(dp));

    cin>>n>>k;
    for(int i=0;i<n;++i) {
        int a,b,c,d;
        cin>>a>>b>>c>>d;
        v.push_back({a,b,c,d});
    }

    cout << dfs(0,k);
    // cout << max(dfs(0, k-v[0].a)+v[0].b,dfs(0,k-v[0].c)+v[0].d);
    
    return 0;
}