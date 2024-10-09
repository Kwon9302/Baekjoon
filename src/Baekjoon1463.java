import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon1463 {
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(br.readLine());
        // 메모이제이션
        dp = new int[X + 1];
        dp[0] = dp[1] = dp[2] = dp[3] = 1;
        System.out.println(ref(X));
    }

    public static int ref(int x) {
        if (dp[x] == 0) {
            if (x % 6 == 0) {
                dp[x] = Math.min(ref(x - 1), Math.min(ref(x / 2), ref(x/3))) + 1;
            } else if (x % 3 == 0) {
                dp[x] = Math.min(ref(x / 3), ref(x - 1))+1;
            } else if (x % 2 == 0) {
                dp[x] = Math.min(ref(x / 2), ref(x - 1))+1;
            } else {
                dp[x] = ref(x - 1)+1;
            }
        }
        return dp[x];
    }
}
