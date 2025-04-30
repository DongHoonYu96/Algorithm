import java.util.*;

public class Main {

    static int n, tc;
    static ArrayList<Integer> v = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        tc = sc.nextInt();
        while(tc>0){
            int x1,y1,r1,x2,y2,r2;
            x1 = sc.nextInt();
            y1= sc.nextInt();
            r1= sc.nextInt();
            x2= sc.nextInt();
            y2= sc.nextInt();
            r2= sc.nextInt();
            double d = Math.pow(x1-x2,2)+Math.pow(y1-y2,2);

            if (x1 == x2 && y1 == y2 && r1 == r2) {
                sb.append("-1\n");
            }
            else if(Math.pow(r1+r2,2)<d){
                sb.append("0\n");
            }
            else if(Math.pow(r1+r2,2)==d){
                sb.append("1\n");
            }
            else if(Math.pow(Math.abs(r1-r2),2)<d && Math.pow(r1+r2,2)>d){
                sb.append("2\n");
            }
            else if(Math.pow(Math.abs(r1-r2),2)==d){
                sb.append("1\n");
            }
            else if (Math.pow(Math.abs(r1-r2),2)>d){
                sb.append("0\n");
            }
            else{
                sb.append("-1\n");
            }
            tc--;
        }
        System.out.println(sb);
    }
}