#include<bits/stdc++.h>
using namespace std; 

int n, m;
int a[100000+4];

bool go(int x) { // 블루레이의 크기가 x일때, 가능한지 확인
   // 예외처리: 어떤 강의든 블루레이 크기보다 클 수 없음
   for(int i = 0; i < n; i++){
      if(a[i] > x){
         return false;
      }
   }

   // 블루레이 크기가 x일 때 필요한 블루레이 개수 계산
   int temp = x; // 현재 블루레이의 남은 공간
   int cnt = 1;  // 블루레이 개수 (처음부터 1개로 시작)
   
   for(int i = 0; i < n; i++){
      if(temp - a[i] < 0){ // 현재 블루레이에 더 담을 수 없을 때
         temp = x;         // 새 블루레이 사용
         cnt++;            // 블루레이 개수 증가
      }
      temp -= a[i];        // 현재 블루레이에 강의 추가
   }
   
   return cnt <= m;  // m개 이하의 블루레이로 가능한지 반환
}

int main(){
   ios_base::sync_with_stdio(0);
   cin.tie(0); cout.tie(0);

   cin >> n >> m;
   
   int sum = 0;
   int max_lecture = 0;
   
   for(int i = 0; i < n; i++) {
      cin >> a[i];
      sum += a[i];
      max_lecture = max(max_lecture, a[i]);
   }

   int st = 0;  // 최소 크기는 가장 큰 강의 길이
   int en = sum;          // 최대 크기는 모든 강의 길이의 합
   int ret = 0;
   
   while(st <= en) {
      int mid = (st + en) / 2;
      
      if(go(mid)) {
         ret = mid;       // 가능한 경우 결과 저장
         en = mid - 1;    // 더 작은 크기 시도
      } else {
         st = mid + 1;    // 더 큰 크기 필요
      }
   }
   
   cout << ret;           // 가능한 최소 크기 출력
}