import java.util.*;

public class Main {

    static int n;
    static ArrayList<Integer> v = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        n = sc.nextInt();
        for(int i = 0; i < n; i++) {
            v.add(sc.nextInt());
        }
        Collections.sort(v);
        for(int i : v) {
            sb.append(i).append("\n");
        }
        System.out.println(sb);
    }
}