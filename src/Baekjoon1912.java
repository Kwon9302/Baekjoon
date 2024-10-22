import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon1912 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] dp = new int[n + 1];
        dp[0]=0;
        dp[1] = Integer.parseInt(st.nextToken());
        int result = dp[1];
        for (int i = 2; i <= n; i++) {
            int a = Integer.parseInt(st.nextToken());
            dp[i] = Math.max(dp[i-1]+a, a);
            result = Math.max(result, dp[i]);
        }
        System.out.println(result);
    }
}
