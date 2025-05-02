import java.util.*;

class Solution {
    static int ret,k;
    static int[] arr;
    
    //x명이 건널수있는가
    boolean go2(int x){
        int cnt=0;
        for(int i=0;i<arr.length;++i){
            if(cnt>=k){
                return false;
            }
            if(arr[i]-x < 0){
                cnt++;
                continue;
            }
            cnt=0;
        }
        return true;
    }
    
    boolean go(int x){
        int cnt=0;
        for(int i=0;i<arr.length;++i){
            if(arr[i]-x < 0){
                cnt++;
                if(cnt>=k){
                    return false;
                }
            } else {
                cnt=0;
            }
        }
        return true;
    }
    
    public int solution(int[] stones, int _k) {
//         int mi = Arrays.stream(stones).min().getAsInt();
//         System.out.println(mi);
//         ret+=mi;
        
//         for(int i=0;i<stones.length;++i){
//             stones[i] -= mi;
//         }
        
        k=_k;
        arr=new int[stones.length];
        arr=stones;
        
        int st=1;
        int en=200000000;
        while(st<=en){
            int mid = (st+en)/2;
            if(go(mid)){
                st=mid+1;
                ret=mid;
            }
            else{
                en=mid-1;
            }
        }
        
//         while(true){
//             int cnt=0; //연속된 0의갯수
//             boolean flag=true; //건널수있는지
//             for(int i=0;i<stones.length;++i){
//                 if(cnt>=k){
//                     flag=false;
//                     break;
//                 }
//                 if(stones[i]==0){
//                     cnt++;
//                     continue;
//                 }
//                 stones[i]--;
//                 cnt=0;
//             }
            
//             if(flag)
//                 ret++;
//             else
//                 break;
//         }
        
        return ret;
    }
}