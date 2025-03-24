#include<bits/stdc++.h>
using namespace std; 

typedef long long ll;

int n,k,ret;
int arr[5000000+4];
map<int,int> m;

int main() {
   ios_base::sync_with_stdio(0);
   cin.tie(0); cout.tie(0);

   cin>>n>>k;

   for(int i=0;i<n;++i) {
      cin>>arr[i];
   }
   sort(arr,arr+n);

   cout<<arr[k-1];
  
   

   return 0;
}