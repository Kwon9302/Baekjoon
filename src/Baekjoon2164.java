import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Baekjoon2164 {
    public static void main(String[] args) throws IOException {
        // 2164번
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Deque<Integer> dq = new ArrayDeque<>();

        int N = Integer.parseInt(st.nextToken());
        for (int i = 1; i <= N; i++) {
            dq.addLast(i);
        }
        while(dq.size()!=1) {
            dq.pollFirst();
            if(dq.size()==1){
                System.out.println(dq.pop());
                return;
            }
            int a = dq.pollFirst();
            dq.addLast(a);
        }
        System.out.println(dq.pop());
    }
}
