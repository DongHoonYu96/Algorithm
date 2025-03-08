#include<bits/stdc++.h>
using namespace std; 

int t;
int n,m;
vector<int> a,b;
set<int> s;

int main(){
   ios_base::sync_with_stdio(0);
   cin.tie(0); cout.tie(0);


   cin>>n>>m;
   for(int i=0;i<n;++i) {
      int tmp;
      cin>>tmp;
      a.push_back(tmp);
      s.insert(tmp);
   }
   for(int i=0;i<m;++i) {
      int tmp;
      cin>>tmp;
      b.push_back(tmp);
      s.insert(tmp);
   }

   sort(b.begin(),b.end()); //정렬주의!!

   for(int i=0;i<n;++i) {
      if(binary_search(b.begin(),b.end(),a[i])) {
         s.erase(a[i]);
      }
   }
   cout<<s.size();

   
}