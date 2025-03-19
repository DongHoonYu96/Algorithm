import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long k = sc.nextLong();
        
        // k는 1 이상이라고 가정 (문제 조건에 따라)
        // 1자리 럭키 수의 개수는 2개
        int len = 1;
        long cnt = 2; // 1자리 그룹의 개수: "4", "7"
        
        // k가 현재 그룹(cnt)보다 크면, 앞 그룹의 개수를 빼고 다음 그룹으로 넘어감
        while (k > cnt) {
            k -= cnt;
            cnt *= 2; // 다음 자릿수 그룹은 2배의 개수
            len++;
        }
        
        long idx = k - 1; // 현재 그룹 내 0-based index
        
        // len자리의 럭키 수를 구성합니다.
        StringBuilder ret = new StringBuilder();
        for (int i = 0; i < len; i++) {
            // 가장 왼쪽 자리가 가장 높은 비트가 되도록 구성
            if ((idx & (1L << (len - 1 - i))) != 0) {
                ret.append("7");
            } else {
                ret.append("4");
            }
        }
        
        System.out.println(ret.toString());
    }
}
