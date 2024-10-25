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

        // 나무 높이 입력받기 및 최대 높이 구하기
        int maxH = 0;
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            dp[i] = Integer.parseInt(st1.nextToken());
            maxH = Math.max(maxH, dp[i]);
        }

        // 이진 탐색
        int minH = 0;  // 최소 높이는 0부터 시작
        int result = 0; // 최적의 절단 높이 저장

        while (minH <= maxH) {
            int height = (minH + maxH) / 2;  // 중간값
            long sum = 0;  // 이번 높이에서 잘린 나무 길이 합

            // 잘린 나무 길이 계산
            for (int i = 0; i < N; i++) {
                if (dp[i] > height) {
                    sum += dp[i] - height;
                }
            }

            // 조건에 따라 이진 탐색 범위 조정
            if (sum >= M) {  // 필요한 나무 길이를 만족할 때
                result = height;  // 일단 현재 높이를 저장
                minH = height + 1;  // 더 높은 절단 높이를 탐색
            } else {  // 필요한 나무 길이를 만족하지 못할 때
                maxH = height - 1;  // 절단 높이를 낮춤
            }
        }

        // 최적의 절단 높이 출력
        System.out.println(result);
    }
}