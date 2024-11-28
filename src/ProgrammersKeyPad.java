    import java.util.*;
public class ProgrammersKeyPad {

    class Solution {
        public String solution(int[] numbers, String hand) {
            String answer="";
            int r = 12;
            int l = 10;

            for(int i=0; i<numbers.length; i++){
                int number = numbers[i];
                if(number==0){
                    number=11;
                }

                if(number%3==1){
                    answer+="L";
                    l = number;
                }

                else if(number%3==0){
                    answer+="R";
                    r = number;
                }

                else if(number%3==2){
                    int x = calculateDistance(l, number);
                    int y = calculateDistance(r, number);

                    if(x > y){
                        answer+="R";
                        r=number;
                    } else if(x == y){
                        if(hand.equals("right")){
                            answer+="R";
                            r=number;
                        } else {
                            answer+="L";
                            l=number;
                        }
                    } else {
                        answer+="L";
                        l=number;
                    }
                }
            }
            return answer;
        }
        private int calculateDistance(int from, int to) {
            return Math.abs((from - 1) / 3 - (to - 1) / 3) + Math.abs((from - 1) % 3 - (to - 1) % 3);
        }
    }
}
