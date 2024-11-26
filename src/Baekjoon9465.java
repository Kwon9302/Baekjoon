import java.util.Scanner;

public class Baekjoon9465 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 테스트 케이스 개수 입력
        int t = sc.nextInt();

        // 결과 저장 배열
        int[] results = new int[t];

        for (int testCase = 0; testCase < t; testCase++) {
            // 열의 개수 n 입력
            int n = sc.nextInt();

            // 스티커 점수 배열 입력
            int[][] sticker = new int[2][n];
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < n; j++) {
                    sticker[i][j] = sc.nextInt();
                }
            }

            // DP 배열 생성
            int[][] dp = new int[2][n];

            // 초기값 설정
            dp[0][0] = sticker[0][0];
            dp[1][0] = sticker[1][0];
            if (n > 1) {
                dp[0][1] = sticker[0][1] + dp[1][0];
                dp[1][1] = sticker[1][1] + dp[0][0];
            }

            // 점화식 계산
            for (int i = 2; i < n; i++) {
                dp[0][i] = Math.max(dp[1][i - 1], dp[1][i - 2]) + sticker[0][i];
                dp[1][i] = Math.max(dp[0][i - 1], dp[0][i - 2]) + sticker[1][i];
            }

            // 최댓값 결과 저장
            results[testCase] = Math.max(dp[0][n - 1], dp[1][n - 1]);
        }

        // 결과 출력
        for (int result : results) {
            System.out.println(result);
        }

        sc.close();
    }
}