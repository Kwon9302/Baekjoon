import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] arr = {1, 2, 3, 4};
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {

    printArray(0,0);
        System.out.println(sb.toString());

    }

    public static void printArray(int sum, int index) {
        if(index == arr.length-1) {
            sum+=arr[index];
            sb.append(sum).append(" ");
            return;
        }

        sum+=arr[index];
        printArray(sum, index+1);

    }
}
