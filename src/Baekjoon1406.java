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
        ListIterator<String> cursorIndex = arr.listIterator(arr.size()); // 커서의 시작 위치르 맨 뒤로 초기화

        for (int i = 0; i < m; i++) {
            StringTokenizer x = new StringTokenizer(br.readLine());
            String ch = x.nextToken();
            if(ch.equals("L")){
                if(cursorIndex.hasPrevious()){
                    cursorIndex.previous(); // 커서 위치 왼쪽으로 이
                }
            } else if(ch.equals("D")){
                if(cursorIndex.hasNext()){
                    cursorIndex.next(); // 커서를 우측으로 이동
                }
            } else if(ch.equals("P")){
                String xx = x.nextToken();
                cursorIndex.add(xx); // add는 커서 왼쪽에 글자를 추가함}
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
