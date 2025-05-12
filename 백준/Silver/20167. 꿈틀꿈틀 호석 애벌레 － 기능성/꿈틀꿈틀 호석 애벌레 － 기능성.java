import java.io.*;
import java.util.*;

public class Main {

    static long ret, n, k;
    static long[] dp = new long[100000+4];
    static ArrayList<Long> arr = new ArrayList<>();

    // 축척된에너지, 얻은탈피에너지
    static void dfs(int idx, long acc, long tal, boolean flag) {
        if(acc >=k){
            tal += acc-k;
            acc=0;
            flag=false;
        }

        if(idx==n){
            ret=Math.max(ret,tal);
            return;
        }

        dfs(idx+1,acc + arr.get(idx), tal,true); //선택
        if(!flag)
            dfs(idx+1,acc, tal,false); //미선택
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        Arrays.fill(dp,-1);
        n = sc.nextInt();
        k = sc.nextInt();
        for(int i=0;i<n;++i){
            int tmp = sc.nextInt();
            arr.add((long) tmp);
        }
        dfs(0,0,0,false);
        dfs(0,0,0,true);
        System.out.println(ret);
    }
}