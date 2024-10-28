import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon1654 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken()); // 1 ~ 10,000
        int N = Integer.parseInt(st.nextToken()); // 1 ~ 1,000,000
        int[] dp = new int[K];
        long max = 0;
        long min = 1;

        for (int i = 0; i < K; i++) {
            dp[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, dp[i]);
        }
        long result =0;

        while(min <= max){
            long x = (max + min) / 2;
            long count=0;

            for (int i = 0; i < K; i++) {
                count += dp[i] / x;
            }
            if(N>count){
                max = x-1;
            } else {
                result = x;
                min = x+1;
            }
        }
        System.out.println(result);
    }
}