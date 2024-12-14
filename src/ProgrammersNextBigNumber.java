import java.util.*;
public class ProgrammersNextBigNumber {

    class Solution {
        public int solution(int n) {
            String change = Integer.toString(n,2); // 2진수 변환

            // 1의 개수 세기
            int count1=0;
            for(int i=0; i < change.length(); i++){
                if('1'==change.charAt(i)){
                    count1++;
                }
            }

            int count2=0;
            int ans=0;
            while(true){
                n++;
                String change2 = Integer.toString(n,2);
                for(int i=0; i < change2.length(); i++){
                    if('1'==change2.charAt(i)){
                        count2++;
                    }
                }
                if(count2==count1){
                    ans=n;
                    break;
                }
                count2=0;
            }
            return ans;
        }
    }
}
