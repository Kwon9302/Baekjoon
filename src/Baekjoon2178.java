import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon2178 {
    static int N;
    static int M;
    static String[][] arr;
    static int[][] visited;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new String[N][M];
        visited = new int[N][M];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            String x = st.nextToken();
            for(int j=0; j<M; j++){
                String xx = x.charAt(j) + "";
                arr[i][j] = xx;
            }
        }
        System.out.println(bfs(0,0));
//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < M; j++) {
//                System.out.print(arr[i][j]+" ");
//            }
//            System.out.println();
//        }
    }

    public static int bfs(int a, int b){
        int count=1;
        Queue<int[]> q =new LinkedList<>();
        q.add(new int[]{a,b,count});
        visited[a][b] = 1;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            if(cur[0]==N-1 && cur[1]==M-1){
                return cur[2];
            }

            for(int i=0; i<4; i++){
                int x = dx[i] + cur[0];
                int y = dy[i] + cur[1];

                if (x >= 0 && y >= 0 && x < N && y < M && visited[x][y] == 0 && arr[x][y].equals("1")) {
                    visited[x][y] = 1;
                    arr[x][y] = (cur[2]+1)+"";
                    q.add(new int[]{x,y,cur[2]+1});
                }
            }
        }
        return count;
    }
}
