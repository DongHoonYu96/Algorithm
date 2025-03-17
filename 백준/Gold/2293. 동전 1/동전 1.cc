#include <bits/stdc++.h>
using namespace std;
typedef long long ll;

int d[10000 + 1]; //d[i] : i원을 만드는 경우의 수
int n, k, coin;

int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);

	cin >> n >> k;
	d[0] = 1;

	//d: 0  1 2 3 4 5 6 7 8 9 10 을
	//여러번(동전갯수n만큼) 왕복하면서 갱신!
	//
	//d[4]=d[4](이전경우의수) + d[2==4-2(coin)]
	for (int i = 0; i < n; ++i) {
		cin >> coin;
		for (int j = coin; j <= k; ++j) {
			d[j] += d[j - coin];
		}
	}
	
	cout << d[k];

	return 0;
}
