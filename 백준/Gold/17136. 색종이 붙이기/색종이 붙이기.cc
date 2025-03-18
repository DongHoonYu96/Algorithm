#include<bits/stdc++.h>
using namespace std; 

typedef long long ll;

int ret=987654321; //맵크기, 나무수, k년
int a[14][14];
int n=10;
map<int,int> m; //<색종이번호, 사용한횟수>

//좌표에 sz의 색종이를 놓을수 있는지
int check(int y, int x, int sz) {
   //범위쳌
   //n인경우는 dfs에서검사함 -> 제외
   if(y+sz>n || x+sz>n) return 0;
   for(int i=y;i<y+sz;++i) {
      for(int j=x;j<x+sz;++j) {
         if(a[i][j]==0) return 0; //금지칸이있다? 불가
      }
   }
   return 1;
}

// val 0 : 색종이로 칠한후 표시 -> 덮어쓰기 자동으로 불가체크 됨
// val 1 : 원복
void draw(int y, int x, int sz, int val) {
   for(int i=y;i<y+sz;++i) {
      for(int j=x;j<x+sz;++j) {
         a[i][j]=val;
      }
   }
}

//사용한 색종이 갯수
void dfs(int y, int x, int cnt) {
   //예외처리
   if(x==n) {
      dfs(y+1,0,cnt);
      return;
   }
   //모두 탐색완료
   if(y==n) {
      ret=min(ret,cnt);
      return;
   }
   // 현재 위치가 0이면(이미 색종이가 놓여있거나 원래 빈 칸, 금지칸) 다음 위치로 이동
   if(a[y][x]==0) {
      dfs(y,x+1,cnt);
      return;
   }

   for(int sz=5;sz>=1;sz--) {
      if(m[sz]==5) continue;

      if(check(y,x,sz)) {
         m[sz]++;
         draw(y,x,sz,0);
         dfs(y,x+sz,cnt+1);
         draw(y,x,sz,1); //원복
         m[sz]--;
      }
   }
   return;
}

int main(){
   ios_base::sync_with_stdio(0);
   cin.tie(0); cout.tie(0);
   
   for(int i=0;i<10;++i) {
      for(int j=0;j<10;++j) {
         cin>>a[i][j];
      }
   }

   dfs(0,0,0);

   if(ret==987654321) cout<<-1;
   else cout<<ret;
}