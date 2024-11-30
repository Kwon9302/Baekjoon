import java.util.Scanner;

public class Baekjoon2447 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt(); // 패턴의 전체 크기
        char[][] pattern = new char[size][size];

        // 초기화
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                pattern[i][j] = '*';
            }
        }

        // 패턴 생성
        generatePattern(pattern, 0, 0, size);

        // 패턴 출력
        printPattern(pattern);
    }

    // 재귀적으로 패턴을 생성하는 메서드
    public static void generatePattern(char[][] pattern, int x, int y, int size) {
        if (size == 1) {
            return; // 최소 크기에서는 더 이상 분할하지 않음
        }

        int subSize = size / 3; // 현재 크기를 3으로 나눔

        // 가운데 부분 비우기
        for (int i = x + subSize; i < x + 2 * subSize; i++) {
            for (int j = y + subSize; j < y + 2 * subSize; j++) {
                pattern[i][j] = ' ';
            }
        }

        // 나머지 8개의 구역에 대해 재귀 호출
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                // 가운데는 이미 비웠으므로 재귀 호출하지 않음
                if (i == 1 && j == 1) {
                    continue;
                }
                generatePattern(pattern, x + i * subSize, y + j * subSize, subSize);
            }
        }
    }

    // 패턴 출력 메서드
    public static void printPattern(char[][] pattern) {
        for (char[] row : pattern) {
            for (char ch : row) {
                System.out.print(ch);
            }
            System.out.println();
        }
    }
}
