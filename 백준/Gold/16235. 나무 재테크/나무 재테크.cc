#include<bits/stdc++.h>
using namespace std; 

typedef long long ll;

int n,m,k; //맵크기, 나무수, k년
int A[14][14]; // 겨울에 줄 양분
int yangbun[14][14]; //현재양분
vector<int> arr[14][14]; //해당좌표에 있는 나무들의 나이!
const int dx[] = { -1, -1, -1, 0, 0, 1, 1, 1 };
const int dy[] = { -1, 0, 1, -1, 1, -1, 0, 1 };

void springSummer() {
   for(int i=0;i<n;++i) {
      for(int j=0;j<n;++j) {
         if(arr[i][j].size()==0) continue;

         int die_cnt=0; //더해줄양분 그때그때 계산 , 누적 !
         vector<int> tmp; //살아있는 나무들로 갱신용!!
         sort(arr[i][j].begin(), arr[i][j].end());
         for(auto age : arr[i][j]) {
            if(yangbun[i][j] < age) { //양분부족 -> die
               die_cnt+=age/2;
            }
            else {
               yangbun[i][j]-=age; // 양분 = 양분 - 나이
               tmp.push_back(age+1); //나이1살 더해야함
            }
            
         }
         //삭제보다, 초기화후 살아있는것 다시 대입!!
         arr[i][j].clear(); 
         arr[i][j]=tmp;
         yangbun[i][j]+=die_cnt;
         
      }
   }
}

void fall() {
   for(int i=0;i<n;++i) {
      for(int j=0;j<n;++j) {
         for(auto age : arr[i][j]) {
            if(age%5!=0) continue;
            for(int k=0;k<8;++k) {
               int ny = i+dy[k];
               int nx = j+dx[k];
               if(ny < 0 || nx <0 || ny>=n || nx>=n) continue;
               arr[ny][nx].push_back(1);
            }
         }
      }
   }
}

void winter() {
   for(int i=0;i<n;++i) {
      for(int j=0;j<n;++j) {
         yangbun[i][j]+=A[i][j];
      }
   }
}

int main(){
   ios_base::sync_with_stdio(0);
   cin.tie(0); cout.tie(0);

   cin>>n>>m>>k;
   for(int i=0;i<n;++i) {
      for(int j=0;j<n;++j) {
         cin>>A[i][j];
         yangbun[i][j]=5;
      }
   }

   for(int i=0;i<m;++i) {
      int a,b,c;
      cin>>a>>b>>c;
      a--; b--; // 0-idx로
      //주의! 나이는 빼면안됨
      arr[a][b].push_back(c); //(a,b)좌표에 나이c 나무가 살고있어요
   }

   for(int i=0;i<k;++i) {
      springSummer();
      fall();
      winter();
   }

   ll ret=0;
   for(int i=0;i<n;++i) {
      for(int j=0;j<n;++j) {
         ret+=arr[i][j].size();
      }
   }
   cout<<ret;
}