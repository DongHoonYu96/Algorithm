#include<bits/stdc++.h>
using namespace std; 

typedef long long ll;

map<ll,ll> dp;
ll n,p,q;

ll go(ll idx) {
    if(idx==0) return 1;
    if(dp[idx]) return dp[idx];
    dp[idx] = go(idx/p) + go(idx/q); 
    return dp[idx];
}

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0); cout.tie(0);

    cin>>n>>p>>q;
    cout<<go(n);
    
    return 0;
}