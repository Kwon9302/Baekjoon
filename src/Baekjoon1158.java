import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Baekjoon1158 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Deque<Integer> stack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            stack.addLast(i);
        }
        sb.append("<");
        while (stack.size()!=1) {
            for (int i = 0; i < K; i++) {
                int a = stack.removeFirst();
                stack.addLast(a);
            }
            sb.append(stack.removeLast()).append(", ");
        }

        sb.append(stack.removeLast()).append(">");
        System.out.println(sb.toString());
    }
}
