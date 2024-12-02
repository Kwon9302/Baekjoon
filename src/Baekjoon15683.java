import java.io.*;
import java.util.*;

public class Baekjoon15683 {
    static int N, M;
    static int[][] map;
    static List<CCTV> cctvs = new ArrayList<>();
    static int minBlindSpot = Integer.MAX_VALUE;

    static int[][][] directions = {
            {}, // 0은 사용하지 않음
            {{0}, {1}, {2}, {3}}, // 1번 CCTV
            {{0, 2}, {1, 3}}, // 2번 CCTV
            {{0, 3}, {3, 2}, {2, 1}, {1, 0}}, // 3번 CCTV
            {{0, 1, 3}, {0, 1, 2}, {1, 2, 3}, {0, 2, 3}}, // 4번 CCTV
            {{0, 1, 2, 3}} // 5번 CCTV
    };

    static int[] dx = {-1, 0, 1, 0}; // 상, 우, 하, 좌
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] >= 1 && map[i][j] <= 5) {
                    cctvs.add(new CCTV(i, j, map[i][j]));
                }
            }
        }

        dfs(0, map);
        System.out.println(minBlindSpot);
    }

    static void dfs(int depth, int[][] currentMap) {
        if (depth == cctvs.size()) {
            minBlindSpot = Math.min(minBlindSpot, countBlindSpots(currentMap));
            return;
        }

        CCTV cctv = cctvs.get(depth);
        int type = cctv.type;

        for (int[] direction : directions[type]) {
            int[][] tempMap = copyMap(currentMap); // 복사 시점이 중요
            monitor(tempMap, cctv.x, cctv.y, direction);
            dfs(depth + 1, tempMap);
        }
    }

    static void monitor(int[][] map, int x, int y, int[] direction) {
        for (int dir : direction) {
            int nx = x;
            int ny = y;

            while (true) {
                nx += dx[dir];
                ny += dy[dir];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M || map[nx][ny] == 6) break; // 벽
                if (map[nx][ny] == 0) map[nx][ny] = -1; // 감시 표시
            }
        }
    }

    static int countBlindSpots(int[][] map) {
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) count++; // 빈칸
            }
        }
        return count;
    }

    static int[][] copyMap(int[][] map) {
        int[][] newMap = new int[N][M];
        for (int i = 0; i < N; i++) {
            newMap[i] = map[i].clone();
        }
        return newMap;
    }

    static class CCTV {
        int x, y, type;

        public CCTV(int x, int y, int type) {
            this.x = x;
            this.y = y;
            this.type = type;
        }
    }
}