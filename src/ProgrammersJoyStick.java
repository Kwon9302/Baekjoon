import java.io.*;
import java.util.*;

class Solution {
    public int solution(String name) {
        int length = name.length();
        int answer = 0;

        // 각 문자 변경 비용(상하 이동) 합계
        for (int i = 0; i < length; i++) {
            char ch = name.charAt(i);
            int upDown = Math.min(ch - 'A', 'Z' - ch + 1);
            answer += upDown;
        }

        // 좌우 이동 최소 횟수 계산
        // 처음엔 그냥 오른쪽으로 쭉 가는 경우를 가정
        int move = length - 1;

        for (int i = 0; i < length; i++) {
            int next = i + 1;

            // 다음 문자부터 연속된 'A'들의 구간을 찾음
            while (next < length && name.charAt(next) == 'A') {
                next++;
            }

            // i번째까지 처리한 후, 뒤로 돌아가거나 앞으로 가는 모든 경우 중 최소값을 구함
            // 방법1: 오른쪽으로 i까지 갔다가 다시 왼쪽으로 돌아가 next 지점까지 이동
            // 방법2: 왼쪽으로 i칸 이동 후, 다시 오른쪽으로 이동하는 경우도 고려 가능
            move = Math.min(move, i * 2 + (length - next));
            // 반대 방향 먼저 가는 경우(왼쪽으로 돌았다가 오른쪽으로)
            move = Math.min(move, (length - next) * 2 + i);
        }

        answer += move;
        return answer;
    }
}

public class ProgrammersJoyStick {
    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.solution("BAAAAAC")); // 기대값: 56
        System.out.println(solution.solution("JAN"));    // 기대값: 23
    }
}