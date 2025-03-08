#include<bits/stdc++.h>
using namespace std; 

int t;
int n,m;
int a[20004], b[20004];

int main(){
   ios_base::sync_with_stdio(0);
   cin.tie(0); cout.tie(0);


   cin>>t;
   while(t--) {
      cin>>n>>m;
      memset(a,0,sizeof(a));
      memset(b,0,sizeof(b));
      for(int i=0;i<n;++i) {
         cin>>a[i];
      }
      
      for(int i=0;i<m;++i) {
         cin>>b[i];
      }
      sort(a,a+n);
      sort(b,b+m);
      int ret=0;
      for(int i=0;i<n;++i) {
         for(int j=0;j<m;++j) {
            if(a[i]>b[j]) {
               // cout<<a[i]<<" "<<b[j]<<"\n";
               ret++;
            }
            else {
               break;
            }
         }
      }
      cout<<ret<<"\n";
   }

}