import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Empoty{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        // 입력값을 BigInteger로 변환
        BigInteger n = new BigInteger(input[0]);
        BigInteger m = new BigInteger(input[1]);

        // 몫 계산
        BigInteger quotient = n.divide(m);
        // 나머지 계산
        BigInteger remainder = n.remainder(m);

        // 결과 출력
        System.out.println(quotient);
        System.out.println(remainder);
    }
}

