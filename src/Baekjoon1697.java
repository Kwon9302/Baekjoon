import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon1697 {
    static int count = 0;
    static int N;
    static int K;
    static int ans;
    static boolean[] visited = new boolean[100001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        bfs(N);
        System.out.println(ans);
    }

    private static void bfs(int x) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, count});
        visited[x] = true;

        while (!q.isEmpty()) {
            int[] arr = q.poll();
            if (arr[0] == K) {
                ans = arr[1];
                return;
            }

            // 이동 가능한 세 가지 경우
            int[] nextPositions = {arr[0] - 1, arr[0] + 1, arr[0] * 2};
            for (int next : nextPositions) {
                // 범위 내에서 방문하지 않은 위치만 큐에 추가
                if (next >= 0 && next <= 100000 && !visited[next]) {
                    visited[next] = true;
                    q.add(new int[]{next, arr[1] + 1});
                }
            }
        }
    }
}