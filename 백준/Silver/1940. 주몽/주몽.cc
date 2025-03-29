#include<bits/stdc++.h>
using namespace std; 

typedef long long ll;

ll n,m,ret;
vector<int> v;

int main() {
   ios_base::sync_with_stdio(0);
   cin.tie(0); cout.tie(0);

   cin>>n>>m;
   for(int i=0;i<n;++i) {
      int tmp;
      cin>>tmp;
      v.push_back(tmp);
   }
   sort(v.begin(),v.end());
   
   for(int i=0;i<n;++i) {
      if(binary_search(v.begin()+i+1,v.end(),abs(m-v[i]))) {
         ret++;
      }
   }
   cout<<ret;
   
   return 0;
}