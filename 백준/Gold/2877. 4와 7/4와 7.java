import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long k = sc.nextLong();

        int len = 1;
        long cnt = 2;

        while (k > cnt) {
            k -= cnt;
            cnt *= 2;
            len++;
        }

        long idx = k - 1;

        StringBuilder ret = new StringBuilder();
        for (int i = 0; i < len; i++) {
            if ((idx & (1L << i)) != 0) {
                ret.insert(0, "7");
            } else {
                ret.insert(0, "4");
            }
        }

        System.out.println(ret.toString());
    }
}