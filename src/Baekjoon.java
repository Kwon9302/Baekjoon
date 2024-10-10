public class Baekjoon {
    public static void main(String[] args) {
        int[] dp = new int[10001];
        dp[0] = dp[1] = 0;

        for (int i = 1; i < 10001; i++) {
            if (dp[i] != 0) {
                continue;
            }
            int ii=i;
            String I = Integer.toString(i);
            for (int j = 0; j < I.length(); j++) {
                ii += I.charAt(j) - '0';
            }
            if(ii>10000){
                continue;
            }
            dp[ii]  = i;
        }
        for (int i = 1; i < 10001; i++) {
            if(dp[i] == 0) {
                System.out.println(i);
            }
        }
    }
}
