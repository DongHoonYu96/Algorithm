import java.util.*;

public class Main {

    static int ret,n,m,r;
    static int[][] arr = new int[104][104];
    static int[][] backup = new int[104][104];
    static boolean[][] vis = new boolean[104][104];

    //remain : 넘어져야할 도미노의 갯수
    //cnt : 넘어뜨린 도미노의 수
    static void dfs(int y, int x, char dir, int cnt, int remain){
//        System.out.println(y+" "+x+" "+dir+" "+cnt+" "+remain);
        if(y<=0 || x<=0 || y>n || x>m){
            ret+=cnt;
            return;
        }
//        if(arr[y][x] == 0 ){
//            return;
//        }
        if(remain ==0){
            ret+=cnt;
            return;
        }

        remain = Math.max(remain-1,arr[y][x]-1);

        if(arr[y][x]>0){
            cnt++;
            arr[y][x]=0;
        }

        if(dir=='E'){
//            for(int i=0;i<arr[y][x];++i){
//                if(arr[y][x+i] > 0){
//                    cnt++;
//                    arr[y][x+i]=0;
//                }
//            }

            dfs(y,x+1,dir,cnt, remain);

        }
        else if(dir=='N'){
//            for(int i=0;i<arr[y][x];++i){
//                if(arr2[y-i][x]=='S'){
//                    cnt++;
//                    arr2[y-i][x]='F';
//                }
//            }
            dfs(y-1,x,dir,cnt,remain);

        }
        else if(dir=='W'){
//            for(int i=0;i<arr[y][x];++i){
//                if(arr2[y][x-i]=='S'){
//                    cnt++;
//                    arr2[y][x-i]='F';
//                }
//            }
            dfs(y,x-1,dir,cnt,remain);
        }
        else if(dir=='S'){
//            for(int i=0;i<arr[y][x];++i){
//                if(arr2[y+i][x]=='S'){
//                    cnt++;
//                    arr2[y+i][x]='F';
//                }
//            }
            dfs(y+1,x,dir,cnt,remain);
        }
    }

    static void attack(int y, int x, char dir){
        if(arr[y][x]==0){
            return;
        }

        int dy=0,dx=0;
        if(dir=='E') dx=1;
        else if(dir=='W') dx=-1;
        else if(dir=='N') dy=-1;
        else if(dir=='S') dy=1;

        int cnt = arr[y][x]; // 넘어뜨릴수 있는 도미노 갯수
        while(true){
            if(x<=0 || y<=0 || y>n || x>m) break;
            if(cnt<1) break;

            System.out.println(y+" "+x+" "+cnt);

            cnt = Math.max(cnt-1,arr[y][x]-1);

            if(arr[y][x]>0) ret++;
            arr[y][x]=0; //넘어뜨리기
            x+=dx;
            y+=dy;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        r = sc.nextInt();
        for(int i=1;i<=n;++i){ //1-idx
            for(int j=1;j<=m;++j){
                int tmp = sc.nextInt();
                arr[i][j]=tmp;
                backup[i][j]=tmp;
            }
        }

        for(int i=0;i<r;++i){
            int y1 = sc.nextInt();
            int x1 = sc.nextInt();
            char c = sc.next().charAt(0);
            int y2 = sc.nextInt();
            int x2 = sc.nextInt();

//            attack(y1,x1,c);
            dfs(y1,x1,c,0,arr[y1][x1]);

            arr[y2][x2]= backup[y2][x2]; //세우기
        }
        System.out.println(ret);
        for(int i=1;i<=n;++i){
            for(int j=1;j<=m;++j){
                if(arr[i][j]>0){
                    System.out.print("S ");
                }
                else{
                    System.out.print("F ");
                }
            }
            System.out.println();
        }
    }
}