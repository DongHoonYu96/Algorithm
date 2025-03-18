#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
ll ret;
int n;

// mid 시간 동안 모든 심사관이 처리할 수 있는 사람 수가 n 이상인지 확인
bool isPossible(ll mid, vector<int> &times) {
    ll cnt = 0;
    for (auto time : times) {
        cnt += mid / time; // 각 심사관이 mid 시간 동안 처리할 수 있는 사람 수
        if (cnt >= n) return true; // 일찍 종료 가능한 최적화
    }
    return cnt >= n;
}

long long solution(int _n, vector<int> times) {
    n = _n;
    
    sort(times.begin(), times.end());
    
    ll st = 1;
    // 최악의 경우: 가장 느린 심사관이 혼자 모든 사람을 처리하는 경우
    ll en = (ll)times.back() * n; 
    
    while (st <= en) {
        ll mid = (st + en) / 2;
        if (isPossible(mid, times)) {
            ret = mid;
            en = mid - 1;
        } else {
            st = mid + 1;
        }
    }
    
    return ret;
}