public class ProgrammersTtangttameokgi {
    class Solution {
        public int solution(int[][] land) {
            int n = land.length;

            // DP 배열을 이용하지 않고 land 자체를 업데이트
            for (int i = 1; i < n; i++) {
                // 각 열에 대해 이전 행의 최대 값을 더함
                land[i][0] += Math.max(Math.max(land[i-1][1], land[i-1][2]), land[i-1][3]);
                land[i][1] += Math.max(Math.max(land[i-1][0], land[i-1][2]), land[i-1][3]);
                land[i][2] += Math.max(Math.max(land[i-1][0], land[i-1][1]), land[i-1][3]);
                land[i][3] += Math.max(Math.max(land[i-1][0], land[i-1][1]), land[i-1][2]);
            }

            // 마지막 행에서 최대 값을 반환
            return Math.max(Math.max(land[n-1][0], land[n-1][1]),
                    Math.max(land[n-1][2], land[n-1][3]));
        }
    }
}
