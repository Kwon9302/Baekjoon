import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Baekjoon2457 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        ArrayList<int[]> arr = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int startMonth = Integer.parseInt(st.nextToken());
            int startDay = Integer.parseInt(st.nextToken());

            int endMonth = Integer.parseInt(st.nextToken());
            int endDay = Integer.parseInt(st.nextToken());

            arr.add(new int[]{startMonth * 100 + startDay, endMonth * 100 + endDay});
        }
            Collections.sort(arr, (o1, o2) -> {
                if (o1[0] == o2[0]) {
                    return o2[1] - o1[1];
                } else {
                    return o2[0] - o1[0];
                }
            });

        for (int i = 0; i < arr.size(); i++) {
            int[] time = arr.get(i);

        }
    }
}
