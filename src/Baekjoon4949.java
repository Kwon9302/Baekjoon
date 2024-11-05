import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Baekjoon4949 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String x;
        while (true) {
            Stack<String> stack = new Stack<>();
            x = br.readLine();
            if (x.equals(".")) break;

            for (int i = 0; i < x.length(); i++) {
                String a = x.charAt(i) + "";
                if (a.equals("(") || a.equals("[")) {
                    stack.push(a);
                } else if (a.equals(")") || a.equals("]")) {
                    if(stack.isEmpty()){ System.out.println("no1");break;}
                    if(a.equals(")")){
                        if(!stack.pop().equals("(")){
                            System.out.println("no"); break;
                        }
                    } else if (a.equals("]")) {
                        if(!stack.pop().equals("[")){
                            System.out.println("no"); break;
                        }
                    }

                } else if (a.equals(".") && i != x.length() - 1) {
                    System.out.println("no");
                    break;
                }
                if(i==x.length()-1) {
                    if (!stack.isEmpty()) {
                        System.out.println("no");
                    } else {
                        System.out.println("yes");
                    }
                }
            }
        }
    }
}
