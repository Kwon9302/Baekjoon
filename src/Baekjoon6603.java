import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon6603 {
    static boolean[] visited;
    static StringBuilder sb;
    static int k;
    static int[] numbers;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> map = new HashMap<>();
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());
            visited = new boolean[k];
            // 종료 조건
            if(k==0){
                break;
            }
            numbers = new int[k];
            sb = new StringBuilder();
            for (int i = 0; i < k; i++) {
                numbers[i] = Integer.parseInt(st.nextToken());
            }

            checking(0,0);
            System.out.println(sb.toString());
        }
    }
    public static void checking(int start, int depth){
        if(depth==6){
            for (int i = 0; i < k; i++) {
                if(visited[i]) sb.append(numbers[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = start; i < numbers.length; i++) {
            visited[i]=true;
            checking(i+1,depth+1);
            visited[i]=false;
        }
    }
}
