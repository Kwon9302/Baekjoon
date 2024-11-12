import java.util.*;

public class ProgrammersCollectionWarning {
    public static void main(String[] args) {

        class Solution {
            public int solution(int[][] points, int[][] routes) {
                // 포인트 지점을 저장한다.
                Map<Integer, int[]> pointMap = new HashMap<>();
                for (int i = 0; i < points.length; i++) {
                    // i+1은 번호를 지정하기 위해 설정
                    pointMap.put(i + 1, points[i]);
                }

                Map<String, Integer> locationTimeMap = new HashMap<>();
                int collisionCount = 0;

                // 설정한 경로의 개수만큼 반복문이 돈다.
                for (int i = 0; i < routes.length; i++) {
                    // 경로 가져오기 route = [4,2] , 4번에서 2번으로
                    int[] route = routes[i];
                    // 출발지(4번)의 좌표를 가져옴 [1,4]
                    int[] currentPos = pointMap.get(route[0]).clone();
                    int time = 0;

                    // 출발 위치에서도 충돌 여부 확인
                    String startPosKey = currentPos[0] + "," + currentPos[1] + "," + time;
                    locationTimeMap.put(startPosKey, locationTimeMap.getOrDefault(startPosKey, 0) + 1);
                    if (locationTimeMap.get(startPosKey) == 2) {
                        collisionCount++;
                    }

                    for (int j = 1; j < route.length; j++) {
                        // 2번(다음목적지)의 좌표를 가져옴 [6,4]
                        int[] nextPos = pointMap.get(route[j]);

                        // 좌표 탐색
                        while (currentPos[0] != nextPos[0] || currentPos[1] != nextPos[1]) {
                            time++;
                            if (currentPos[0] < nextPos[0]) currentPos[0]++;
                            else if (currentPos[0] > nextPos[0]) currentPos[0]--;
                            else if (currentPos[1] < nextPos[1]) currentPos[1]++;
                            else if (currentPos[1] > nextPos[1]) currentPos[1]--;
                            // currentPos = [2,4]
                            // posKey = 2,4,0
                            String posKey = currentPos[0] + "," + currentPos[1] + "," + time;
                            //                  2,4,0  ,                 1
                            locationTimeMap.put(posKey, locationTimeMap.getOrDefault(posKey, 0) + 1);

                            if (locationTimeMap.get(posKey) == 2) {
                                collisionCount++;
                                // System.out.println(posKey);
                                // System.out.println(route[j]);
                            }

                        // 요약하자면 그냥 좌표값이랑 시간을 Map에 다 넣어버린다. 그리고 getOrDefault를 사용해서 count한다.
                        //                     그리고 count값이 1이 넘으면 충돌이 되는거임
                        }
                    }
                }
                return collisionCount;
            }
        }
    }
}
