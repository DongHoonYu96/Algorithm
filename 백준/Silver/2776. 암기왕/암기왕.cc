#include<bits/stdc++.h>
using namespace std; 

typedef long long ll;

ll ret,n,m;

int t;

int main(){
   ios_base::sync_with_stdio(0);
   cin.tie(0); cout.tie(0);

   cin>>t;
   while(t--) {
      cin>>n;
      vector<ll> v1, v2;
      for(int i=0;i<n;++i) {
         int tmp;
         cin>>tmp;
         v1.push_back(tmp);
      }
      cin>>m;
      for(int i=0;i<m;++i) {
         int tmp;
         cin>>tmp;
         v2.push_back(tmp);
      }
      sort(v1.begin(),v1.end());
      for(int i=0;i<m;++i) {
         // cout<<m<<" ";
         if(binary_search(v1.begin(),v1.end(),v2[i])) {
            cout<<1<<"\n";
         }
         else {
            cout<<0<<"\n";
         }
      }
   }
  
   
}