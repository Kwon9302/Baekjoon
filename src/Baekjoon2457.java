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
            int endDay = Integer.parseInt(st.nextToken())-1;

            arr.add(new int[]{startMonth * 100 + startDay, endMonth * 100 + endDay});
        }

        // 시작 날짜 오름차순, 시작 날짜가 같으면 종료 날짜 내림차순 정렬
        Collections.sort(arr, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o2[1] - o1[1];
            } else {
                return o1[0] - o2[0];
            }
        });

        int start = 301; // 목표 시작일
        int end = 1130;  // 목표 종료일
        int lastEnd = 0; // 가장 멀리 갈 수 있는 날짜
        int count = 0;   // 선택한 구간의 수
        int idx = 0;     // 현재 탐색할 구간의 인덱스

        while (start <= end) {
            boolean found = false;

            // 현재 시작 날짜(start)를 덮을 수 있는 구간 중 가장 멀리 갈 수 있는 구간 선택
            while (idx < N && arr.get(idx)[0] <= start) {
                lastEnd = Math.max(lastEnd, arr.get(idx)[1]);
                idx++;
                found = true;
            }

            if (!found) { // 더 이상 덮을 수 있는 구간이 없으면 실패
                System.out.println(0);
                return;
            }

            count++;       // 구간 선택
            start = lastEnd + 1; // 다음 탐색 시작 날짜를 갱신
        }

        System.out.println(count);
    }
}