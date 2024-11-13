import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon1074 {
    static int count=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int size = (int) Math.pow(2, N);

        block(size, r ,c);
        // 배열 췍
//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < N; j++) {
//                System.out.print(arr[i][j]);
//            }
//            System.out.println();
//        }
        System.out.println(count);
    }

    public static void block(int size, int r, int c){
        if(size==1){
            return;
        }
        if (r >= size/2 && c >= size/2) {
            count += size*size/4 *3;
            block(size/2, r - size/2, c - size/2);
        } else if (r >= size/2 && c < size/2) {
            count += size*size/2 *2;
            block(size/2, r - size/2, c);
        } else if (r < size/2 && c >= size/2) {
            count += size*size/2 *1;
            block(size/2, r, c - size/2);
        } else {
            block(size/2, r, c);
        }

    }
}
