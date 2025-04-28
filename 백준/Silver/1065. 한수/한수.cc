#include<bits/stdc++.h>
using namespace std; 

typedef long long ll;

ll n,ret;
ll vis[204];

int go(int x) {
    if(x==1000) return 0;
    
    string s = to_string(x);
    if(s.size()==1 || s.size()==2) return 1;

    // int d = (s[0]-'0')-(s[1]-'0');
    // for(int i=1;i<s.size()-1;++i) {
    //     int gab = (s[i]-'0')-(s[i+1]='0');
    //     cout<<gab<<"\n";
    //     if(d!=gab) return 0;
    // }
    if(s.size()==3) {
        int a = x/100;
        int b = (x-a*100)/10;
        int c = x%10;
        if(a-b == b-c) return 1;
        return 0;
    }
}

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0); cout.tie(0);
    
    cin>>n;
    for(int i=1;i<=n;++i) {
        if(go(i)) ret++;
    }
    cout<<ret;
    
    return 0;
}