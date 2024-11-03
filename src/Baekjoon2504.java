import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Baekjoon2504 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        Stack<Character> stack = new Stack<>();
        int sum=0;
        for (int i = 0; i < str.length(); i++) {
            char x = str.charAt(i);
            if(x=='(' || x=='['){
                stack.push(x);
            } else if (x==')') {
                char y = stack.pop();
                if(x!=y){
                    System.out.println(0);
                    return;
                }
            } else if (x==']') {
                char y = stack.pop();
                if(x!=y){
                    System.out.println(0);
                    return;
                }
            }
        }

    }
}
