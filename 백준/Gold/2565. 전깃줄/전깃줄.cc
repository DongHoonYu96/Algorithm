#include<bits/stdc++.h>
using namespace std; 

typedef long long ll;

int n;
int lis[104],len;
vector<pair<int,int>> v;

int main(){
   ios_base::sync_with_stdio(0);
   cin.tie(0); cout.tie(0);

   cin>>n;
   for(int i=0;i<n;++i) {
      int a,b;
      cin>>a>>b;
      v.push_back({a,b});
   }
   sort(v.begin(),v.end());

   for(int i=0;i<n;++i) {
      int idx = lower_bound(lis,lis+len,v[i].second)-lis;
      if(idx==len) {
         len++;
      }
      lis[idx]=v[i].second;
   }

   cout<<n-len;
}