#include <bits/stdc++.h>

using namespace std;

vector<vector<int>> key, loc, origin;
int arr[64][64];

vector<vector<int>> rot(vector<vector<int>> origin){
    vector<vector<int>> ret(24, vector<int>(24, 0));
    // int ret[24][24];
    for(int i=0;i<key.size();++i){
        for(int j=0;j<key[0].size();++j){
            ret[i][j]=origin[key.size()-j-1][i];
        }
    }
    return ret;
}

// lock의 모든좌표에서 v 배열로 덮어지는지
// void go(int y, int x, vector<vector<int>>& v){
//     for(int i=0;i<lock.size();++i){
//         for(int j=0;j<lock[0].size();++j){
//             dfs(i,j);
//         }
//     }
// }

//전부 채워졌는지
int check(vector<vector<int>>& lock){
    for(int i=0;i<lock.size();++i){
        for(int j=0;j<lock[0].size();++j){
            if(lock[i][j]==0) return 0;
        }
    }
    return 1;
}

//y,x 에 자물쇠(v)를 대보기
int dfs(int y, int x, vector<vector<int>>& v){
    //원복
    loc = origin;
    for(int i=0;i<key.size();++i){
        for(int j=0;j<key[0].size();++j){
            //범위쳌
            if(y+i >= loc.size() || x+i >= loc[0].size()){
                continue;
            }
            //겹치는건 안됨
            if(loc[y+i][x+j]==1 && v[i][j]==1){
                return 0;
            }
            if(loc[y+i][x+j]==0 && v[i][j]==1){
                loc[y+i][x+j]=1;
            }
        }
    }
    
    for(int i=0;i<loc.size();++i){
        for(int j=0;j<loc[0].size();++j){
            cout<<loc[i][j]<<" ";
        }cout<<"\n";
    }
    
    if(check(loc)){
        return 1;
    }
    return 0;
}

bool solution(vector<vector<int>> _key, vector<vector<int>> _lock) {
    key=_key;
    loc=_lock;
    origin = _lock;
    int n=_lock.size();
    int m= key.size();
    bool answer = true;
    
    vector<vector<int>> tmp1 = rot(key);
    vector<vector<int>> tmp2 = rot(tmp1);
    vector<vector<int>> tmp3 = rot(tmp2);
    
//     for(int i=0;i<key.size();++i){
//         for(int j=0;j<key[0].size();++j){
//             cout<<tmp1[i][j]<<" ";
//         }cout<<"\n";
//     }
    
//     for(int i=0;i<key.size();++i){
//         for(int j=0;j<key[0].size();++j){
//             cout<<tmp2[i][j]<<" ";
//         }cout<<"\n";
//     }
    
//     for(int i=0;i<key.size();++i){
//         for(int j=0;j<key[0].size();++j){
//             cout<<tmp3[i][j]<<" ";
//         }cout<<"\n";
//     }
    
    // for(int i=0;i<loc.size();++i){
    //     for(int j=0;j<loc[0].size();++j){
    //         if(dfs(i,j, tmp1)){
    //             return 1;
    //         }
    //         if(dfs(i,j, tmp2)){
    //             return 1;
    //         }
    //         if(dfs(i,j, tmp3)){
    //             return 1;
    //         }
    //         if(dfs(i,j, key)){
    //             return 1;
    //         }
    //     }
    // }
    
    int offset = m-1;
    for(int y=0;y<offset + n;++y){
        for(int x=0;x<offset + n;++x){
            for(int k=0;k<4;++k){ //for 회전
                memset(arr,0,sizeof(arr)); //초기화
                vector<vector<int>> key;
                if(k==0){
                    key = _key;
                }
                else if(k==1){
                    key = tmp1;
                }
                else if(k==2){
                    key = tmp2;
                }
                else if(k==3){
                    key = tmp3;
                }
                //arr중앙에 lock을 복사
                for(int i=0;i<n;++i){
                    for(int j=0;j<n;++j){
                        arr[i+offset][j+offset]=_lock[i][j];
                    }
                }

                //채우기 (덧셈이용)
                for(int i=0;i<m;++i){
                    for(int j=0;j<m;++j){
                        arr[y+i][x+j]+=key[i][j];
                    }
                }

                int allOne=1;
                //arr 중앙에 lock부분이 모두 1이면 ok
                for(int i=0;i<n;++i){
                    for(int j=0;j<n;++j){
                        if(arr[i+offset][j+offset]!=1){
                            allOne=0;
                            break;
                        }
                    }
                }
                if(allOne) return 1;
                // key = rot(key);
            }
            // key = rot(key); //360도 원복
        }
    }
    
    // dfs(1,1,tmp1);
    
    return 0;
}