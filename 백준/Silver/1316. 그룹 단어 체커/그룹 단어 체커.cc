#include<bits/stdc++.h>
using namespace std; 

typedef long long ll;

ll n,ret;
ll vis[204];

int go(string s) {
    memset(vis,0,sizeof(vis));
    char prev = s[0];
    vis[prev-'a']=1;
    for(int i=1;i<s.size();++i) {
        if(prev==s[i]) {
            
        }
        else if(vis[s[i]-'a']){
            return 0;
        }
        else {
            vis[s[i]-'a']=1;
            prev=s[i];
        }
    }
    return 1;
}

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0); cout.tie(0);
    
    cin>>n;
    for(int i=0;i<n;++i) {
        string str;
        cin>>str;
        if(go(str)) {
            // cout<<str<<"\n";
            ret++;
        }
    }
    cout<<ret;
    
    return 0;
}