#include <queue>
#include <iostream>

using namespace std;

int main()
{
	int t,n, m;
	
	cin >> t;
	for (int test = 0; test < t; ++test)
	{
		queue<pair<int, int>> q;	//큐에 인덱스,중요도 동시에 저장!
		priority_queue<int> pq;	//pq => 최대값뽑기

		cin >> n >> m;

		for (int index = 0; index < n; ++index)
		{
			int important;
			cin >> important;
			q.push({ index,important });
			pq.push(important);
		}
		//입력끝

		int cnt = 0;	//인쇄된 갯수저장
		while (!q.empty())
		{
			int i, imp;
			i = q.front().first;	//인덱스, 중요도 저장, 큐에서뽑기
			imp = q.front().second;
			q.pop();

			
			if (imp == pq.top())	//그 중요도가 최대값인경우 -> 인쇄가능
			{
				pq.pop();	//최대값아웃
				cnt++;	//인쇄카운트
				if (i == m)	//그리고 내가원하는 인덱스인경우 -> 그냥끝내면됨.
				{
					cout << cnt << endl;
					break;
				}

			}
			else     //그 중요도가 최대값이 아닌경우 -> 다시큐에 집어넣기.
			{
				q.push({ i,imp });
			}

		}
		

	}
}
