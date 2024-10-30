import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon11279 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());


        for (int i = 0; i < N; i++) {
            int a = Integer.parseInt(br.readLine());
            // 비어있는 상태에서 0이 나올때
            if(a==0 && pq.isEmpty()){
                System.out.println(0);
                continue;
            }
            if(a==0){
                System.out.println(pq.poll());
            }
            pq.add(a);

        }
    }
}
