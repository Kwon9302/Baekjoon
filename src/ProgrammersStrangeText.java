public class ProgrammersStrangeText {
    class Solution {
        public String solution(String s) {
            StringBuilder res = new StringBuilder();
            boolean isEven = true; // 단어별로 짝수/홀수 인덱스를 추적

            for (int i = 0; i < s.length(); i++) {
                char x = s.charAt(i);

                if (x == ' ') {
                    res.append(" ");
                    isEven = true; // 공백 이후에는 새로운 단어가 시작되므로 짝수로 초기화
                } else {
                    if (isEven && x >= 'a' && x <= 'z') {
                        res.append((char)(x - 32)); // 소문자를 대문자로 변환
                    } else if (!isEven && x >= 'A' && x <= 'Z') {
                        res.append((char)(x + 32)); // 대문자를 소문자로 변환
                    } else {
                        res.append(x); // 변환할 필요 없는 경우 그대로 추가
                    }
                    isEven = !isEven; // 인덱스 변경
                }
            }

            return res.toString();
        }
    }
}
