import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        System.out.println(calculateValue(str));
    }

    public static int calculateValue(String input) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);

            if (ch == '(' || ch == '[') {
                stack.push((ch == '(') ? -2 : -3); // -2 for '(', -3 for '['
            } else {
                if (stack.isEmpty()) return 0; // 올바르지 않은 경우

                int sum = 0;
                while (!stack.isEmpty() && stack.peek() > 0) {
                    sum += stack.pop(); // 스택의 숫자를 합산
                }

                if (stack.isEmpty()) return 0; // 괄호 짝이 맞지 않음

                int top = stack.pop();

                // 괄호 짝이 맞는지 확인
                if ((ch == ')' && top != -2) || (ch == ']' && top != -3)) {
                    return 0; // 잘못된 괄호
                }

                // 값 계산
                int value = (ch == ')') ? 2 : 3;
                stack.push((sum == 0) ? value : value * sum);
            }
        }

        // 최종 계산
        int result = 0;
        while (!stack.isEmpty()) {
            if (stack.peek() < 0) return 0; // 남아 있는 괄호가 있을 경우
            result += stack.pop();
        }

        return result;
    }
}