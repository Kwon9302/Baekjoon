import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Baekjoon2108 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arg = new int[N];
        double avg = 0;
        int mid = 0;
        int maxNum = Integer.MIN_VALUE;
        int minNum = Integer.MAX_VALUE;

        // 입력 받기
        for (int i = 0; i < N; i++) {
            int a = Integer.parseInt(br.readLine());
            arg[i] = a;
        }

        Arrays.sort(arg); // 정렬

        Map<Integer, Integer> frequencyMap = new HashMap<>();
        int count = 1;

        // 빈도수 계산
        for (int i = 1; i < N; i++) {
            if (arg[i] == arg[i - 1]) {
                count++;
            } else {
                frequencyMap.put(arg[i - 1], count);
                count = 1;
            }
        }
        frequencyMap.put(arg[N - 1], count); // 마지막 요소 추가

        // 평균
        avg = Arrays.stream(arg).sum() / (double) N;
        System.out.println(Math.round(avg)); // 산술평균 출력

        // 중앙값
        System.out.println(arg[N / 2]); // 중앙값 출력

        // 최빈값 찾기
        int maxFrequency = Collections.max(frequencyMap.values()); // 최빈도 값 찾기

        // 최빈값 중 두 번째로 작은 값 찾기
        List<Integer> modeList = frequencyMap.entrySet().stream()
                .filter(entry -> entry.getValue() == maxFrequency) // 최빈도와 같은 값만 필터링
                .map(Map.Entry::getKey) // Key(숫자)만 추출
                .sorted() // 오름차순 정렬
                .collect(Collectors.toList());

        int mode = (modeList.size() > 1) ? modeList.get(1) : modeList.get(0); // 두 번째 최빈값 선택
        System.out.println(mode); // 최빈값 출력

        // 범위 출력
        System.out.println(arg[N - 1] - arg[0]);
    }
}