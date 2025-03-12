#include<bits/stdc++.h>
using namespace std; 

typedef long long ll;

int len, n;
ll a[1000000+4];
ll lis[1000000+4];
pair<int,int> ans[1000000+4]; // pos,num

int main(){
   ios_base::sync_with_stdio(0);
   cin.tie(0); cout.tie(0);

   fill(a,a+1000000+4,-1000000000-1);
   cin>>n;
   for(int i=0;i<n;++i) {
      cin>>a[i];
   }

   for(int i=0;i<n;++i) {
      int idx = lower_bound(lis,lis+len,a[i])-lis; // a가 아니라 lis가 탐색대상!
      if(idx==len) {
         len++;
      }
      lis[idx]=a[i];
      ans[i].first = idx;
      ans[i].second = a[i];
   }
   cout<<len<<"\n";

   stack<int> s;
   for(int i=n-1;i>=0;--i) {
      if(ans[i].first == len-1) {
         s.push(ans[i].second);
         len--;
      }
   }
   while(s.size()) {
      cout<<s.top()<<" ";
      s.pop();
   }
}