#include<bits/stdc++.h>
using namespace std; 

const int INF = 987654321;
// 게임에 필요한 전역 변수들
int a[14];    // 주사위 값을 저장하는 배열
int mal[4];   // 4개의 말의 현재 위치를 저장하는 배열
int n = 10;   // 총 주사위 던지는 횟수
int v[104];   // 각 칸의 점수를 저장하는 배열
vector<int> adj[54];  // 게임판의 연결 상태 (인접 리스트)

// 현재 위치(here)에서 주사위 값(cnt)만큼 이동했을 때의 도착 위치를 반환
int move(int here, int cnt){  
   if(here==100) return 100; //이미 도착점임

   //특수 위치인경우
   if(adj[here].size()>=2) {
      here = adj[here][1]; // 이동시켜
      cnt--;
   }
   if(cnt<=0) return here; //특수위치이동후, 이동횟수없는경우 특수 이동시킨위치 리턴

   queue<int> q;
   q.push(here);
   int there;
   while(q.size()) {
      int x = q.front(); q.pop();
      there = adj[x][0];
      if(there == 100) break;
      q.push(there);
      cnt--; //이동횟수 감소!
      if(cnt<=0) break;
   }
   return there;
}

// 말이 겹치는지 확인하는 함수(도착할위치, 나자신 )
bool isMal(int nxt, int idx){
   if(nxt == 100) return false;
   for(int i=0;i<4;++i) {
      if(idx==i) continue; // 탐색대상에서 나 자신은 제외
      if(mal[i] == nxt) return true; // 다른말의 위치 == 도착할위치인경우, 겹침
   }
   return false;
}

// 게임판에 간선 추가하는 함수
void add(int here, int there){
   adj[here].push_back(there); 
}

// 게임판 초기화 함수
void setMap(){
   // 빨간색 화살표 경로 설정 (0~19)
   for(int i = 0; i <= 19; i++) add(i, i + 1); 
   
   // 파란색 화살표 경로 설정
   // 5번 칸에서 시작하는 경로
   add(5, 21); add(21, 22); add(22, 23); add(23, 24); 
   // 15번 칸에서 시작하는 경로
   add(15, 29); add(29, 30); add(30, 31); add(31, 24); 
   // 10번 칸에서 시작하는 경로
   add(10, 27); add(27, 28); add(28, 24); 
   // 공통 경로
   add(24, 25); add(25, 26); add(26, 20); add(20, 100);  
   
   // 각 칸의 점수 설정
   v[1] = 2; v[2] = 4;  v[3] = 6; v[4] = 8; v[5] = 10; 
   v[6] = 12; v[7] = 14; v[8] = 16; v[9] = 18; v[10] = 20; 
   v[11] = 22; v[12] = 24; v[13] = 26; v[14] = 28; v[15] = 30; 
   v[16] = 32; v[17] = 34; v[18] = 36; v[19] = 38; v[20] = 40; 
   v[21] = 13; v[22] = 16; v[23] = 19; v[24] = 25; 
   v[27] = 22; v[28] = 24; v[25] = 30; v[26] = 35; 
   v[29] = 28; v[30] = 27; v[31] = 26; 
}

// DFS로 최대 점수를 찾는 함수
// depth : 트리의 depth, 주사위의 index
int go(int depth, int sum){ 
   if(depth == n) return sum;   // 모든 주사위를 다 던졌으면 종료
   
   int ret = 0;  // 현재 상태에서의 최대 점수
   for(int i = 0; i < 4; i++){    // 4개의 말에 대해 시도
      int tmp_idx = mal[i]; // 원복용 값저장
      int nxt = move(mal[i], a[depth]); // 도착할 위치
      if(isMal(nxt,i)) continue; // 도착할위치에 다른말이 있는경우

      mal[i] = nxt; //말 이동
      ret = max(ret, go(depth+1, sum+v[nxt]));
      mal[i] = tmp_idx; //원복
   } 
   return ret;  // 최대 점수 반환
}

int main(){
   ios_base::sync_with_stdio(false);
   cin.tie(NULL); cout.tie(NULL);
   
   setMap();   // 게임판 초기화
   for(int i = 0; i < n; i++) cin >> a[i];   // 주사위 값 입력
   cout << go(0,0) << "\n";   // 최대 점수 계산 및 출력
   return 0;
}