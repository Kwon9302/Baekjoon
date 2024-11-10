import java.util.*;
public class ProgrammersPuzzleGame {
    class Solution {
        public int solution(int[] diffs, int[] times, long limit) {
            int minLevel = 1;
            int maxLevel = 0;
            for (int i = 0; i < diffs.length; i++) {
                maxLevel = Math.max(diffs[i], maxLevel);
            }
            int level = 0;

            while (minLevel < maxLevel) {
                level = (maxLevel + minLevel) / 2;
                long totalTime = 0;

                for (int i = 0; i < diffs.length; i++) {
                    int tryMethod = 0;
                    if (diffs[i] > level) {
                        tryMethod = diffs[i] - level;
                        totalTime += (times[i - 1] + times[i]) * tryMethod + times[i];
                    } else if (diffs[i] <= level) {
                        totalTime += times[i];
                    }
                }

                if (totalTime <= limit) {
                    maxLevel = level;
                } else {
                    minLevel = level + 1;
                }
            }
            return minLevel;
        }
    }
}
