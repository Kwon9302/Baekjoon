import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon2805 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); //나무의 개수
        int M = Integer.parseInt(st.nextToken()); // 나무의 길이
        int[] dp = new int[N];
        int maxH=0;
        int minH=0;
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(st1.nextToken());
            dp[i] = x;
            maxH = Math.max(maxH, dp[i]);
            minH = Math.min(minH, dp[i]);
        }

        int sum=0;
        int height=(maxH-minH)/2;
        while(true){
            for (int i = 0; i < N; i++) {
                if(dp[i] <= height){
                    continue;
                } else {
                    sum+=dp[i]-height;
                }
            }
            if(sum>M){
                height-=1;
            } else if(sum<M) {
                height++;
            } else {
                break;
            }
        }
        System.out.println(height);
    }
}
