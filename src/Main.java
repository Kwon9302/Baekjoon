import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        // 1874
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        // 4 3 6 8 7 5 2 1

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int a = Integer.parseInt(br.readLine());
            stack.push(a);
        }
        int count=0;
        for (int i = 1; i <= n; i++) {
            if(stack.peek()==i && count==0){
                stack.pop();
                System.out.println("+");
            } else if (stack.peek() != i) {
                System.out.println("+");
                count++;
            } else if(stack.peek()==i && count!=0){
                for (int j = 0; j < count; j++) {
                    System.out.println("-");
                }
                count=0;
                System.out.println("+");
            }
        }



    }
}
