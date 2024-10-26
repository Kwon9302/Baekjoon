import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon2805 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 나무의 개수
        int M = Integer.parseInt(st.nextToken()); // 필요한 나무의 길이
        int[] dp = new int[N];

        int maxH = 0;  // 최대 높이
        int minH = 0;  // 최소 높이

        // 나무의 높이 입력 및 최대 높이 계산
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            dp[i] = Integer.parseInt(st1.nextToken());
            maxH = Math.max(maxH, dp[i]);
        }

        int result = 0;  // 최적의 절단 높이 저장

        // 이진 탐색 수행
        while (minH <= maxH) { // 최대 높이값을 구해야 하기 때문에 계속해서 while문이 실행되어야 한다.
            int height = (maxH + minH) / 2;  // 중간값 계산
            long sum = 0;  // 잘린 나무의 총 길이

            // 현재 높이에서 잘린 나무 길이 계산
            for (int i = 0; i < N; i++) {
                if (dp[i] > height) {
                    sum += dp[i] - height;
                }
            }

            if (sum >= M) {  // 필요한 나무를 충족하는 경우
                result = height;  // 결과값 갱신
                minH = height + 1;  // 더 높은 절단 높이 탐색
            } else {
                maxH = height - 1;  // 절단 높이 낮추기
            }
        }

        // 최적의 절단 높이 출력
        System.out.println(result);
    }
}