import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Baekjoon11501 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine()); //3

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine()); // 3
            int sum = 0;

            StringTokenizer st = new StringTokenizer(br.readLine()); // 10, 7, 6
            Stack<Integer> stack = new Stack();

            for (int j = 0; j < N; j++) {
                int x = Integer.parseInt(st.nextToken());
                stack.push(x);
            }
            int temp = stack.pop();

            while (!stack.isEmpty()) {
                int n = stack.pop();
                if (n > temp) {
                    temp = n;
                } else {
                    sum += temp - n;
                }
            }
            sb.append(sum).append("\n");
        }
        System.out.println(sb.toString());
    }
}

