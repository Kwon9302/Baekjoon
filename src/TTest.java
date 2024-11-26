import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TTest {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String x = br.readLine();
        int sum=0;

        int count=0;
        String sss=x;
        while(!x.equals(sss)||count==0) {
            if(sss.length()<2) {
                sss = "0" + sss;
            }
            char a = sss.charAt(0);
            char b = sss.charAt(1);
            sum = (a - '0') + (b - '0');
                String ssum = Integer.toString(sum);
                sum = (b - '0') * 10 + (ssum.charAt(ssum.length() - 1) - '0');
            count++;
            sss = Integer.toString(sum);
        }
        System.out.println(count);
    }
}
