import java.io.*;
import java.util.*;

public class Baekjoon1406 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String a = br.readLine();// 문자열 입력
        int m = Integer.parseInt(br.readLine()); // 명령어 반복횟수

        LinkedList<String> arr = new LinkedList<>();

        for (int i = 0; i < a.length(); i++) {
            arr.add(a.charAt(i)+"");
        }
        ListIterator<String> cursorIndex = arr.listIterator(arr.size());

        for (int i = 0; i < m; i++) {
            StringTokenizer x = new StringTokenizer(br.readLine());
            String ch = x.nextToken();
            if(ch.equals("L")){
                if(cursorIndex.hasPrevious()){
                    cursorIndex.previous();
                }
            } else if(ch.equals("D")){
                if(cursorIndex.hasNext()){
                    cursorIndex.next();
                }
            } else if(ch.equals("P")){
                String xx = x.nextToken();
                cursorIndex.add(xx);
            } else if(ch.equals("B")){
                if(cursorIndex.hasPrevious()){
                    cursorIndex.previous();
                    cursorIndex.remove();
                }
            }
        }
        for (int i = 0; i < arr.size(); i++) {
            bw.write(arr.get(i));
        }
        bw.flush();
        bw.close();

    }
}
