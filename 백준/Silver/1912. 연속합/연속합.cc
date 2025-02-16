#include <bits/stdc++.h>
using namespace std;

long long d[100004], a[100004],n;
//d[i]: i자리까지 연속합중 최대값 

int main() {
	ios_base::sync_with_stdio(0);
	cin.tie(0);

	cin >> n;
	for (int i = 1; i <= n; ++i) {
		cin >> a[i];
		d[i] = a[i];
	}

	d[1] = a[1];

	for (int i = 2; i <= n; ++i) {
		d[i] = max(a[i], d[i - 1] + a[i]);
		//d[i]=max(현재값[새로시작], 이전값+현재값)
	}

	//각각 i자리까지의 최대값이 저장됨
	//d[n]이 최대값 보장이아님 -> 최대값찾으면됨.
	cout << *max_element(d + 1, d + n + 1);
}