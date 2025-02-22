#include<bits/stdc++.h>
using namespace std; 

int n,m,target,ret;
int a[2004], b[2004], pa[2004],pb[2004];
map<int,int> ma, mb; // <숫자, 횟수>

int main(){
   ios_base::sync_with_stdio(0);
   cin.tie(0); cout.tie(0);
   cin>>target>>m>>n;

   for(int i=1;i<=m;++i) {
      cin>>a[i];
   }
   for(int i=1;i<=n;++i) {
      cin>>b[i];
   }

   //2배로 붙이기
   for(int i=m+1;i<=m*2;++i) {
      a[i] = a[i-m];
   }
   for(int i=n+1;i<=n*2;++i) {
      b[i] = b[i-n];
   }

   //누적합계산
   pa[1]=a[1]; pb[1]=b[1];
   for(int i=2;i<=m*2;++i) {
      pa[i] = pa[i-1] + a[i];
   }
   for(int i=2;i<=n*2;++i) {
      pb[i] = pb[i-1] + b[i];
   }

   // for(int i=0;i<=m*2;++i) {
   //    cout<<pa[i]<<" ";
   // }cout<<"\n";

   //구간크기별로 가능한 합 횟수 세기
   for(int interval = 1 ; interval <= m ; ++interval) {
      for(int start = interval ; start <= m + interval - 1 ; ++start) {
         int sum = pa[start] - pa[start - interval];
         ma[sum]++;
         if(interval == m) break; //전체 구간대상인경우, 원형탐색 불가능 (본배열 1회만 탐색)
      }
   }
   //구간크기별로 가능한 합 횟수 세기
   for(int interval = 1 ; interval <= n ; ++interval) {
      for(int start = interval ; start <= n + interval - 1 ; ++start) {
         int sum = pb[start] - pb[start - interval];
         mb[sum]++;
         if(interval == n) break; //전체 구간대상인경우, 원형탐색 불가능 (본배열 1회만 탐색)
      }
   }

   //결과세기
   //1. 각각 단독으로 target이 되는경우의수
   ret+=ma[target];
   ret+=mb[target];
   //2. 두개 합쳐서 target
   for(int i=1;i<target;++i) {
      ret+=ma[i] * mb[abs(i-target)];
   }
   
   cout<<ret;
}