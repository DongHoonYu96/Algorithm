#include <iostream>
#include <vector>
using namespace std;
int solution(int n, vector<int> stations, int w)
{
    int answer = 0;
    
    int prev = 0; // 마지막으로 커버된 아파트의 위치
    for(auto station : stations){
        // 커버되지 않은 구간 계산 (음수 방지)
        int start = max(1, station - w);
        int uncovered = start - prev - 1;
        
        // 필요한 기지국 수 계산
        if(uncovered > 0) {
            answer += (uncovered + (2*w+1) - 1) / (2*w+1); // 올림 나눗셈
        }
        
        prev = station + w;
    }
    
    // 마지막 기지국 이후의 커버되지 않은 아파트 처리
    if(prev < n) {
        int uncovered = n - prev;
        answer += (uncovered + (2*w+1) - 1) / (2*w+1); // 올림 나눗셈
    }
    
    return answer;
}