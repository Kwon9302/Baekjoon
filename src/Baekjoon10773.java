import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Baekjoon10773 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Deque<Integer> dq = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());
            if(x==0){
                dq.removeLast();
            } else {
                dq.addLast(x);
            }
        }
        if(dq.isEmpty()){
            System.out.println(0);
            return;
        }
        int sum = 0;
        while(!dq.isEmpty()){
            sum+= dq.removeLast();
        }
        System.out.println(sum);
    }
}
