import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon5397 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String a = br.readLine();

            // 두 개의 Deque 사용
            Deque<Character> leftDeque = new ArrayDeque<>();
            Deque<Character> rightDeque = new ArrayDeque<>();

            for (int j = 0; j < a.length(); j++) {
                char ch = a.charAt(j);

                if (ch == '<') {
                    if (!leftDeque.isEmpty()) {
                        // 왼쪽 Deque에서 오른쪽 Deque로 이동
                        rightDeque.addFirst(leftDeque.pollLast());
                    }
                } else if (ch == '>') {
                    if (!rightDeque.isEmpty()) {
                        // 오른쪽 Deque에서 왼쪽 Deque로 이동
                        leftDeque.addLast(rightDeque.pollFirst());
                    }
                } else if (ch == '-') {
                    if (!leftDeque.isEmpty()) {
                        // 왼쪽 Deque에서 삭제
                        leftDeque.pollLast();
                    }
                } else {
                    // 왼쪽 Deque에 추가
                    leftDeque.addLast(ch);
                }
            }

            // 결과를 합쳐서 출력
            StringBuilder sb = new StringBuilder();
            for (char ch : leftDeque) {
                sb.append(ch);
            }
            for (char ch : rightDeque) {
                sb.append(ch);
            }
            System.out.println(sb);
        }
    }
}