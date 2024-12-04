import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Baekjoon11650 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<int[]> arr = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x=  Integer.parseInt(st.nextToken());
            int y=  Integer.parseInt(st.nextToken());

            arr.add(new int[]{x, y});
        }

        // x를 기준으로 정렬하고, x가 같으면 y를 기준으로 정렬
        Collections.sort(arr, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1]; // x가 같으면 y로 정렬
            } else {
                return o1[0] - o2[0]; // x 기준으로 정렬
            }
        });

        for (int i = 0; i < N; i++) {
            System.out.print(arr.get(i)[0] + " " + arr.get(i)[1]);
            System.out.println();
        }
    }
}