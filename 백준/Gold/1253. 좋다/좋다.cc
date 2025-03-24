#include<bits/stdc++.h>
using namespace std; 

typedef long long ll;

int n,ret;
int arr[2004], vis[2004];
map<int,int> m;

int main() {
   ios_base::sync_with_stdio(0);
   cin.tie(0); cout.tie(0);

   cin>>n;

   for(int i=0;i<n;++i) {
      cin>>arr[i];
   }
   sort(arr,arr+n);

  
   for(int k=0;k<n;++k) {
      int s=0;
      int e=n-1;
      
      while(s<e) {
         int sum = arr[s]+arr[e];
         if(sum == arr[k]) {
            //자기자신은 안됨!
            if(s!=k && e!=k) {
               ret++;
               break;
            }
            if(s==k) {
               s++;
            }
            else if(e==k) {
               e--;
            }
            
         }
         else if( sum > arr[k]) {
            e--;
         }
         else {
            s++;
         }
      }
   }
   
   cout<<ret;

   return 0;
}