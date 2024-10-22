import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Baekjoon11866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            dq.addLast(i);
        }
        int count=1;
        while(dq.size()!=1) {
            int x = dq.pollFirst();
            if (count % K == 0) {
                sb.append(x).append(", ");
                count=1;
                continue;
            }
            dq.addLast(x);
            count++;
        }
        sb.append(dq.poll()).append(">");
        System.out.println(sb.toString());
    }
}
