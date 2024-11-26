import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon4179 {
    static int[] J = new int[2];
    static int[] F = new int[2];
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static int X;
    static int Y;
    static String[][] arr;
    static int count=0;
    static PriorityQueue<Integer> ansq = new PriorityQueue<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());

        arr =new String[X][Y];

        // 배열 넣기
        for (int i = 0; i < X; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            String a = st1.nextToken();

            for (int j = 0; j < Y; j++) {
                arr[i][j] = a.charAt(j)+"";
                if (arr[i][j].equals("J")) {
                    J[0]=i;
                    J[1]=j;
                } else if (arr[i][j].equals("F")) {
                    F[0]=i;
                    F[1]=j;
                }
            }
        }
//        for (int i = 0; i < X; i++) {
//            for (int j = 0; j < Y; j++) {
//                System.out.print(arr[i][j]);
//            }
//            System.out.println();
//        }
//        System.out.println(J[0]);
//        System.out.println(J[1]);
//        System.out.println(F[0]);
//        System.out.println(F[1]);
        bfs(J[0],J[1],F[0],F[1]);
        if(ansq.isEmpty()){
            System.out.println("IMPOSSIBLE");

        } else {
            System.out.println(ansq.poll());
        }

    }

    private static void bfs(int jix, int jiy, int fx, int fy) {
        Queue<int[]> fire = new LinkedList<>();
        Queue<int[]> ji = new LinkedList<>();
        ji.add(new int[]{jix, jiy,count});
        fire.add(new int[]{fx, fy});
// 모든 불의 초기 위치를 큐에 추가
        for (int i = 0; i < X; i++) {
            for (int j = 0; j < Y; j++) {
                if (arr[i][j].equals("F")) {
                    fire.add(new int[]{i, j});
                }
            }
        }
        while (!ji.isEmpty()) {
            int fireSize = fire.size();
            for (int k = 0; k < fireSize; k++) {
            int[] f = fire.poll();
            int fxx = f[0];
            int fyy = f[1];

            for (int i = 0; i < 4; i++) {
                int x = dx[i] + fxx;
                int y = dy[i] + fyy;

                if (x >= 0 && y >= 0 && x < X && y < Y) {
                    if (arr[x][y].equals(".") || arr[x][y].equals("J")) {
                        arr[x][y] = "F";
                        fire.add(new int[]{x, y});
                    }
                }
            }
        }
            int jiSize = ji.size();
            for (int k = 0; k < jiSize; k++) {
            int[] jii = ji.poll();
            int jxx = jii[0];
            int jyy = jii[1];
            int ct = jii[2];

            for (int i = 0; i < 4; i++) {
                int x = dx[i] + jxx;
                int y = dy[i] + jyy;

                if (x < 0 || y < 0 || x >= X || y >= Y) {
                    ansq.add(ct + 1);
                    return; // 탈출 즉시 종료
                }

                if (x >= 0 && y >= 0 && x < X && y < Y) {
                    if (arr[x][y].equals(".")) {
                        arr[x][y] = "J";
                        ji.add(new int[]{x, y, ct + 1});
                    }
                }
            }
            }
        }
    }
}
