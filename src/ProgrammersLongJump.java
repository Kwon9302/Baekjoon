public class ProgrammersLongJump {
    class Solution {
        public long solution(int n) {
            long[] dp = new long[2000+1];
            dp[1]=1% 1234567;
            dp[2]=2% 1234567;

            for(int i=3; i < 2001; i++){
                dp[i] = (dp[i-2] + dp[i-1])% 1234567;
            }

            return dp[n] ;
        }
    }
}
