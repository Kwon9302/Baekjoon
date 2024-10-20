import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon2579 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[] scores = new int[N + 1];
        int[] dp = new int[N + 1];
        dp[0] = 0;
        for (int i = 1; i <= N; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st2.nextToken());
            scores[i] = M;
        }

        dp[1] = scores[1];
        if (N==1){
            System.out.println(dp[1]);
            return;
        }
        dp[2] = scores[2] + scores[1];
        int result = 0;
        if(N==2){
            System.out.println(dp[2]);
            return;
        }

        for (int i = 3; i <= N; i++) {
            dp[i] = Math.max(dp[i - 2] , dp[i - 3] + scores[i - 1]) + scores[i];
        }
        System.out.println(dp[N]);
    }
}
