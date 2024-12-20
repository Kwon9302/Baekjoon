    import java.util.*;
public class Programmers2Bit {

    class Solution {
        public long[] solution(long[] numbers) {
            long[] ans = new long[numbers.length];

            for (int i = 0; i < numbers.length; i++) {
                long x = numbers[i];

                // 조건을 만족하는 다음 숫자 찾기
                if (x % 2 == 0) {
                    // 짝수의 경우, 가장 작은 비트(맨 끝)가 항상 0이므로 +1을 하면 비트가 하나만 다르게 됨
                    ans[i] = x + 1;
                } else {
                    // 홀수의 경우, 가장 낮은 0비트를 찾아 1로 바꾸고,
                    // 그보다 오른쪽의 첫 번째 1 비트를 0으로 바꿔야 함
                    long bit = 1;
                    while ((x & bit) != 0) {
                        bit <<= 1; // 오른쪽으로 비트 이동
                    }
                    ans[i] = x + bit - (bit >> 1);
                }
            }

            return ans;
        }
    }
}
