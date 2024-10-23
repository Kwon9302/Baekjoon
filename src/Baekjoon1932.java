import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.StringTokenizer;

public class Baekjoon1932 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N];
        int[] temp = new int[N];
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        dp[0] = Integer.parseInt(st1.nextToken());
        int result =dp[0];
        for (int i = 1; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int count = st.countTokens();
            for (int j = 0; j < count; j++) {
                int x = Integer.parseInt(st.nextToken());
                if (j == 0) {
                    temp[j] = dp[0] + x;
                } else {
                    temp[j] = Math.max(dp[j-1]+x, dp[j]+x);
                }
            }
            for (int j = 0; j < N; j++) {
                if(temp[j]==0) {
                    continue;
                } else {
                    dp[j] = temp[j];
                }
            }
        }
        for (int i = 0; i < N; i++) {
            result = Math.max(result, dp[i]);
        }
        System.out.println(result);
    }
}
