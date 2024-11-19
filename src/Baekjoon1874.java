import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Baekjoon1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();

        int current = 1; // 1부터 N까지 스택에 넣을 숫자
        boolean possible = true; // 수열 생성 가능 여부

        for (int i = 0; i < N; i++) {
            int target = Integer.parseInt(br.readLine());

            // 스택에 target까지 숫자를 push
            while (current <= target) {
                stack.push(current++);
                sb.append("+\n");
            }

            // 스택의 최상단이 target과 같다면 pop
            if (!stack.isEmpty() && stack.peek() == target) {
                stack.pop();
                sb.append("-\n");
            } else {
                // 스택의 최상단이 target과 다르면 불가능
                possible = false;
                break;
            }
        }

        // 결과 출력
        if (possible) {
            System.out.println(sb.toString());
        } else {
            System.out.println("NO");
        }
    }
}