import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;
import java.util.StringTokenizer;

public class Baekjoon21170 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<int[]> arr = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr.add(new int[]{x, y});
        }

        Collections.sort(arr, (o1, o2) -> {
            if(o1[0] == o2[0]){
                return o1[1] - o2[1];
            } else {
                return o1[0] - o2[0];
            }
        });

        Stack<int[]> stack = new Stack<>();
        stack.push(arr.get(0));
        int length = 0;
        for (int i = 1; i < arr.size(); i++) {
            int[] temp = stack.pop();
            int x = temp[0];
            int y = temp[1];

            int[] line = arr.get(i);
            int lineX = line[0];
            int lineY = line[1];

            if(x <= lineX && lineX< y && y <= lineY){
                stack.push(new int[]{x,lineY});
            }
//            else if(x <= lineX && x<lineY && y >= lineY){
//                stack.push(new int[]{x,y});
//            }
            else if(y <= lineX){
                length += y-x;
                stack.push(new int[]{lineX, lineY});
            } else {
                stack.push(new int[]{x,y});
            }

        }
        int[] last = stack.pop();
        length += last[1]-last[0];
        System.out.println(length);
    }
}

