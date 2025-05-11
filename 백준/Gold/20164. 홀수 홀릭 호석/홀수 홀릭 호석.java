import java.util.*;

public class Main {

    static int ret1=987654321,ret2; // 최소값, 최대값
    static ArrayList<Integer> v = new ArrayList<>();

    //num의 홀수갯수 세기
    static int calc(int num){
        int ret=0;
        while(num>0){
            int tmp = num%10;
            if(tmp%2==1) ret++;
            num=num/10;
        }
        return ret;
    }

    static void dfs(String s, int cnt){
//        System.out.println(s);

        cnt+=calc(Integer.parseInt(s));

        if(s.length() == 1){
//            if(Integer.parseInt(s) %2 ==1){
//                cnt++;
//            }
            ret1 = Math.min(ret1, cnt);
            ret2 = Math.max(ret2, cnt);
            return;
        }
        if(s.length()==2){
            int n = Integer.parseInt(s);
            int a = n%10;
            int b = n/10;
//            if(a%2==1) cnt++;
//            if(b%2==1) cnt++;
            dfs(Integer.toString(a+b),cnt);
        }
        else{
            for(int i=1;i<s.length();++i){
                for(int j=i+1;j<s.length();++j){
                    int a = Integer.parseInt(s.substring(0,i));
                    int b = Integer.parseInt(s.substring(i,j));
                    int c = Integer.parseInt(s.substring(j)); //j부터 끝까지
                    int d = a+b+c;
//                    cnt+=calc(d);
                    dfs(Integer.toString(d),cnt);
                }
            }
        }
    }



    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        dfs(Integer.toString(n),0);
        System.out.println(ret1);
        System.out.println(ret2);
    }
}