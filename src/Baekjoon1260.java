import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon1260 {
    static int N;
    static int M;
    static int V;
    static int[][] arr;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
         M = Integer.parseInt(st.nextToken());
         V = Integer.parseInt(st.nextToken());

        arr = new int[N+1][N+1];
        visited = new boolean[N+1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a][b] = 1;
            arr[b][a] = 1;
        }
//        System.out.print(V+" ");
        dfs(V);
        System.out.println();
        visited = new boolean[N+1];
        bfs(V);
    }

    private static void dfs(int a) {
        Stack<Integer> stack = new Stack<>();
        stack.push(a);
        System.out.print(a+" ");
        visited[a] = true;
        while (!stack.isEmpty()) {
            a = stack.pop();
            for (int i = 1; i < N+1; i++) {
                if(arr[a][i] == 1 && !visited[i]){
                    stack.push(i);
//                    System.out.print(" "+ i);
                    visited[i] = true;
                    dfs(i);
                }
            }
        }
    }

    private static void bfs(int a) {
        Queue<Integer> q = new LinkedList<>();
        q.add(a);
        visited[a] = true;
        System.out.print(a);
        while (!q.isEmpty()) {
            a = q.poll();
            for (int i = 0; i < N + 1; i++) {
                if(arr[a][i] == 1 && !visited[i]){
                    q.add(i);
                    System.out.print(" "+i);
                    visited[i] = true;
                }
            }
        }
    }
}
