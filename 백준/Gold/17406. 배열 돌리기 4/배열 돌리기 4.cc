#include<bits/stdc++.h>
using namespace std;  
#define s second
#define f first
// 최댓값 설정 (최솟값을 찾기 위한 초기값)
const int INF = 987654321;
// 방향 배열 (우, 하, 좌, 상)
const int dy[] = {0, 1, 0, -1}; 
const int dx[] = {1, 0, -1, 0};

// 전역 변수 선언
int n, m, k;              // n: 배열 세로크기, m: 배열 가로크기, k: 회전 연산의 개수
int a[104][104];         // 원본 배열
int b[104][104];         // 회전 연산을 수행할 임시 배열
int ret = INF;           // 결과값 (각 행의 합 중 최솟값)
int r, c, s;             // r,c: 회전의 중심점, s: 회전의 크기
int visited[104][104];   // 방문 체크 배열
int dir;                 // 현재 진행 방향
int sy, sx, ey, ex;      // 현재 회전할 영역의 시작점(sy,sx)과 끝점(ey,ex)

// 회전 연산 좌표를 저장할 벡터
vector<pair<int, int>> vv;
// 회전 연산의 순서를 저장할 벡터
vector<int> v_idx;     

// 회전 연산 정보를 저장할 구조체
struct A{
    int y, x, cnt; // y,x: 중심점, cnt: 회전 크기
}; 
vector<A> v; 

// 회전을 수행하는 재귀 함수 (회전 대상 좌표들을 vv에 넣기)
void go(int y, int x, int first){
    //모서리라면 방향을 바꿔야함
    if(!first && y==sy && x==ex) dir++; // 우측위모서리
    if(!first && y==ey && x==ex) dir++; // 우측아래 모서리
    if(!first && y==ey && x==sx) dir++; //좌측아래 모서리
    if(!first && y==sy && x==sx) dir++; //좌측위 모서리

    int ny=y+dy[dir];
    int nx=x+dx[dir];

    if(visited[ny][nx]) return; // 맨 마지막에 다시 시작점으로 돌아오면 종료

    visited[ny][nx]=1; //방문처리 빼먹!!!!!!!!!!!
    vv.push_back({ny,nx});
    go(ny,nx,0);
}

// 주어진 좌표에서 회전을 수행하는 함수
void rotateAll(int y, int x, int cnt){
    //중심점(y,x)로부터 start(왼위), end(오아) 구하기, 중심으로부터 점차 밖으로 확장해나감
    for(int i=1;i<=cnt;++i) {
        sy=y - 1*i;
        sx=x - 1*i; //[틀림] start, end는 전역변수임에 주의!!
        ey=y + 1*i; // 지역변수로해서 모서리 방향 바꾸긱 에러남
        ex=x + 1*i;

        // 초기화들
        vv.clear();
        dir=0; //!!!!!빼먹!!!!!!!!!!!!
        memset(visited,0,sizeof(visited)); // 초기화 여기? ㅇㅇ

        
        visited[sy][sx]=1;
        vv.push_back({sy,sx}); //시작점 담기
        go(sy,sx,1);

        vector<int> vvv; // 체크된 값들을 저장
        for(auto p : vv) { //vv에는 체크된 좌표들이 담겨있음
            vvv.push_back(b[p.first][p.second]);
        }

        //[틀림] 값을 뒤로밀기!!!!!!!!!! (좌표아님!!)
        rotate(vvv.begin(), vvv.begin()+vvv.size()-1,vvv.end()); 
        for(int i=0;i<vv.size();++i) { //vv에는 체크된 좌표들이 담겨있음(한칸 회전후)
            b[vv[i].first][vv[i].second] = vvv[i]; //이동된 좌표에 원본값을 넣기
        }
    }
}

// 현재 순열에 대해 회전 연산을 수행하고 결과를 반환하는 함수
int solve(){
    // 현재 순열 순서대로 회전 연산 수행
    for(auto i : v_idx) {
        rotateAll(v[i].y,v[i].x,v[i].cnt);
    }
    
    // 각 행의 합 중 최솟값 계산
    int _ret = INF;
    for(int i = 0; i < n; i++){
        int cnt = 0;
        for(int j = 0; j < m; j++) cnt += b[i][j];
        _ret = min(_ret, cnt);
    }
    return _ret; 
}

int main(){
    // 입력
    cin >> n >> m >> k; 
    for(int i = 0; i < n; i++){
        for(int j = 0; j < m; j++){
            cin >> a[i][j]; 
        }
    }
    
    // 회전 연산 정보 입력
    for(int i = 0; i < k; i++){
        cin >> r >> c >> s; 
        r--; c--;  // 0-based 인덱스로 변환
        v.push_back({r, c, s}); 
        v_idx.push_back(i);
    } 

    // 모든 가능한 회전 연산 순서에 대해 시도
    do{
        // 원본 배열 복사
        memcpy(b,a,sizeof(a)); //a를 b에 복사
        // 현재 순열에 대한 결과와 비교하여 최솟값 갱신
        ret = min(ret, solve());
    }while(next_permutation(v_idx.begin(), v_idx.end())); 

    // 결과 출력
    cout << ret << "\n";
    return 0;
}