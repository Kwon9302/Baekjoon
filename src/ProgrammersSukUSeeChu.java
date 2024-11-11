    import java.util.*;
public class ProgrammersSukUSeeChu {

    public class Solution {
        static int[] dx = {-1, 1, 0, 0}; // 상하좌우 이동
        static int[] dy = {0, 0, -1, 1};
        static int n, m;
        static int[][] land;
        static boolean[][] visited;
        static Map<Integer, Integer> oilChunks = new HashMap<>();
        static int currentID = 1;

        public int solution(int[][] landInput) {
            land = landInput;
            n = land.length;
            m = land[0].length;
            visited = new boolean[n][m];

            // 1. Flood Fill로 각 석유 덩어리 식별 및 크기 계산
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (land[i][j] == 1 && !visited[i][j]) {
                        int oilSize = bfs(i, j, currentID);
                        oilChunks.put(currentID++, oilSize);  // 덩어리 ID와 크기 저장
                    }
                }
            }

            // 2. 각 열에 대해 최대 석유량 계산
            int maxOil = 0;
            for (int col = 0; col < m; col++) {
                Set<Integer> seenChunks = new HashSet<>();
                int columnOil = 0;

                for (int row = 0; row < n; row++) {
                    if (land[row][col] > 0) {  // 석유 덩어리가 있는 경우
                        int chunkID = land[row][col];
                        if (!seenChunks.contains(chunkID)) {
                            columnOil += oilChunks.get(chunkID);  // 덩어리 크기 합산
                            seenChunks.add(chunkID);
                        }
                    }
                }
                maxOil = Math.max(maxOil, columnOil);  // 최대 석유량 업데이트
            }

            return maxOil;
        }

        // BFS를 이용한 Flood Fill, 덩어리 크기 계산
        private int bfs(int startX, int startY, int id) {
            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[]{startX, startY});
            visited[startX][startY] = true;
            land[startX][startY] = id;  // 현재 덩어리에 ID 할당
            int size = 1;

            while (!queue.isEmpty()) {
                int[] pos = queue.poll();
                int x = pos[0];
                int y = pos[1];

                for (int d = 0; d < 4; d++) {
                    int nx = x + dx[d];
                    int ny = y + dy[d];
                    if (nx >= 0 && nx < n && ny >= 0 && ny < m && land[nx][ny] == 1 && !visited[nx][ny]) {
                        queue.add(new int[]{nx, ny});
                        visited[nx][ny] = true;
                        land[nx][ny] = id;  // 같은 덩어리로 ID 할당
                        size++;
                    }
                }
            }
            return size;
        }
    }
}
