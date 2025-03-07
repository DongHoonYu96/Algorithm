#include <iostream>
#include <algorithm>
#include <numeric>
using namespace std;

int n, m;
int a[100000 + 4];

// Blu-ray 용량 x로 강의를 m개 이하로 담을 수 있는지 검사하는 함수
bool go(int x) {
    // 모든 강의가 x 이하인지 확인 (강의 하나가 x보다 크면 무조건 실패)
    for (int i = 0; i < n; i++){
        if (a[i] > x)
            return false;
    }

    int temp = x;  // Blu-ray의 전체 용량
    int cnt = 0;   // 사용한 Blu-ray 수

    for (int i = 0; i < n; i++){
        if (x - a[i] < 0) {  // 현재 Blu-ray에 담을 수 없으면
            x = temp;        // 새 Blu-ray 시작
            cnt++;           // Blu-ray 1장 추가
        }
        x -= a[i];           // 현재 Blu-ray에 강의 할당
    }
    if (x != temp)  // 마지막 Blu-ray에 일부라도 강의가 할당되었다면
        cnt++;

    return cnt <= m;
}

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);

    cin >> n >> m;
    for (int i = 0; i < n; ++i) {
        cin >> a[i];
    }

    // 이진 탐색의 하한은 강의 중 최대 길이, 상한은 강의 길이의 총합으로 설정
    int low = *max_element(a, a + n);
    int high = accumulate(a, a + n, 0);
    int ret = high;  // 가능한 최소 용량 (정답 후보)

    while (low <= high) {
        int mid = (low + high) / 2;
        if (go(mid)) {  // mid 용량으로 m개 이하로 담을 수 있다면
            ret = mid;      // 정답 후보 업데이트
            high = mid - 1; // 더 작은 용량이 가능한지 탐색
        }
        else {
            low = mid + 1;  // 현재 용량으로는 불가능하므로 더 큰 용량 탐색
        }
    }

    cout << ret; // 최소 Blu-ray 용량 출력
    return 0;
}
