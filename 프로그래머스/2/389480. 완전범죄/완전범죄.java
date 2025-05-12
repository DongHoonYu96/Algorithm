import java.util.*;
class Solution {
    public static int len;
    public static int answer=Integer.MAX_VALUE;
    public static Set<String> visited = new HashSet<>();
    public int solution(int[][] info, int n, int m) {
        // Arrays.sort(info, (a, b) -> (b[0] + b[1]) - (a[0] + a[1]));
        // for(int [] i: info){
        //     System.out.println(i[0]+" "+i[1]);
        // }
        len=info.length;
        dfs(info,n,m,0,0,0);
        if(answer==Integer.MAX_VALUE){
            return -1;
        }
        return answer;
        //dfs인데 이미 기존의 최솟값보다 커진 경우 BREAK
        //만약 이미 sumA가 크거나 같다면 

    }
    public void dfs(int [][] info, int n, int m, int sumA, int sumB, int depth){
        if(sumA>=n || sumB >=m || sumA >=answer){
            return;
        }
        if(depth==len){
            //calc
            answer=Math.min(answer,sumA);
            return;
        }

        String state = sumA + "," + sumB + "," + depth;
        if (visited.contains(state)) return;

        visited.add(state);
        //a가 포함하는 경우
        dfs(info,n,m, sumA+info[depth][0], sumB, depth+1);
        //b가 포함하는 경우
        dfs(info,n,m, sumA, sumB+info[depth][1], depth+1);

    }
}