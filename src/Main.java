import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            queue.add(Integer.parseInt(st.nextToken()));
        }

        Queue<Integer> answer = new LinkedList<>();
        int sum=0;
        while (!queue.isEmpty()) {
            sum+=queue.poll();
            answer.add(sum);
        }
        int res = 0;
        while (!answer.isEmpty()) {
            res += answer.poll();
        }
        System.out.println(res);
    }
}
