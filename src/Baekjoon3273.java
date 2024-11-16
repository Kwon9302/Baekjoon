import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Baekjoon3273 {
    static Deque<Integer> dq = new ArrayDeque<>();
    static int x;
    static int result=0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        if(n==1){
            System.out.println(0);
            return;
        }
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        for (int i = 0; i < n; i++) {
            dq.addLast(arr[i]);
        }
        x = Integer.parseInt(br.readLine());
        int a = dq.pollFirst();
        int b = dq.pollLast();
        findgogo(a, b);
        System.out.println(result);
    }
        public static void findgogo(int a, int b){
        if (dq.isEmpty()){
            if(a+b==x){
                result++;
            }
            return;
        }
            if (a + b > x) {
                findgogo(a, dq.pollLast());
            } else if (a + b < x) {
                findgogo(dq.pollFirst(), b);
            } else {
                result++;
                if(dq.size()<=1){
                    return;
                }
                    findgogo(dq.pollFirst(), dq.pollLast());
            }
        }
    }
