public class ProgrammersParkWalk {
    class Solution {
        public int[] solution(String[] park, String[] routes) {
            int[] position = new int[2];

            // 1. 시작 위치 찾기
            for (int i = 0; i < park.length; i++) {
                int col = park[i].indexOf('S');
                if (col != -1) {
                    position[0] = i;
                    position[1] = col;
                    break;
                }
            }

            // 2. 명령 처리
            for (String route : routes) {
                char direction = route.charAt(0); // 방향
                int distance = Integer.parseInt(route.substring(2)); // 이동 거리
                int tempX = position[0];
                int tempY = position[1];
                boolean isBlocked = false;

                // 거리만큼 이동하면서 장애물 체크
                for (int i = 1; i <= distance; i++) {
                    if (direction == 'E') tempY++;
                    else if (direction == 'W') tempY--;
                    else if (direction == 'S') tempX++;
                    else if (direction == 'N') tempX--;

                    // 맵 경계를 넘어가거나 장애물에 부딪히는 경우 이동 중단
                    if (tempX < 0 || tempX >= park.length || tempY < 0 || tempY >= park[0].length()
                            || park[tempX].charAt(tempY) == 'X') {
                        isBlocked = true;
                        break;
                    }
                }

                // 장애물이 없으면 이동 완료
                if (!isBlocked) {
                    position[0] = tempX;
                    position[1] = tempY;
                }
            }

            // 3. 최종 위치 반환
            return position;
        }
    }
}
