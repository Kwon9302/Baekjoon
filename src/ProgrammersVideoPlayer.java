public class ProgrammersVideoPlayer {
    class Solution {
        public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
            int videoLength = convertToSeconds(video_len);
            int openingStart = convertToSeconds(op_start);
            int openingEnd = convertToSeconds(op_end);

            int currentPos = convertToSeconds(pos);

            // 처음 시작할 때 오프닝 구간에 있으면 오프닝 끝나는 위치로 이동
            if (currentPos >= openingStart && currentPos <= openingEnd) {
                currentPos = openingEnd;
            }

            for (String command : commands) {
                if (command.equals("prev")) {
                    currentPos -= 10;
                    if (currentPos < 0) {
                        currentPos = 0;
                    }
                } else if (command.equals("next")) {
                    currentPos += 10;
                    if (currentPos > videoLength) {
                        currentPos = videoLength;
                    }
                }

                // 명령어 수행 후 오프닝 구간에 있으면 오프닝 끝나는 위치로 이동
                if (currentPos >= openingStart && currentPos <= openingEnd) {
                    currentPos = openingEnd;
                }
            }

            return convertToMMSS(currentPos);
        }

        // "mm:ss" 형식의 시간을 초로 변환
        private int convertToSeconds(String time) {
            String[] parts = time.split(":");
            int minutes = Integer.parseInt(parts[0]);
            int seconds = Integer.parseInt(parts[1]);
            return minutes * 60 + seconds;
        }

        // 초를 "mm:ss" 형식으로 변환
        private String convertToMMSS(int totalSeconds) {
            int minutes = totalSeconds / 60;
            int seconds = totalSeconds % 60;
            return String.format("%02d:%02d", minutes, seconds);
        }
    }
}
