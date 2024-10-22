import java.util.ArrayDeque;
import java.util.Deque;

public class Test {
    public static void main(String[] args) {
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < 10; i++) {
            stack.push(i);
        }
        System.out.println(stack.pollLast());
    }
}
