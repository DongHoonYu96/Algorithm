import java.util.*;

class Solution
{
    public int solution(int n, int a, int b)
    {
        int round = 1;
        
        while(a != b) {
            // 다음 라운드 번호 계산
            a = (a + 1) / 2;  // 올림 나누기 2
            b = (b + 1) / 2;  // 올림 나누기 2
            round++;
        }
        
        return round - 1; // 마지막에 1 빼기 (만나는 라운드)
    }
}