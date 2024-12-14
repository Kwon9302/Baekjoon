import java.util.*;
public class ProgrammersFailedPercent {

    class Solution {
        public int[] solution(int N, int[] stages) {
            int[] solved = new int[N+2]; // index번 문제를 몇명이 풀었나

            for(int i=0; i<stages.length; i++){
                solved[stages[i]]++;
            }

            int student = stages.length; // 유저 수
            ArrayList<double[]> arr = new ArrayList<>(); // [푼문제, 실패율]

            for(int i=1; i<N+1; i++){
                if(student==0){
                    arr.add(new double[]{i,0.0});
                    continue;
                }
                int failedMan = solved[i];

                double failPercent = (double)failedMan/ student;
                arr.add(new double[]{i,failPercent});
                student-=failedMan;
            }

            Collections.sort(arr, (o1, o2)->{
                if(o2[1]==o1[1]){
                    return (int)(o1[0] - o2[0]);
                }
                return Double.compare(o2[1] ,o1[1]);
            });

            int[] ans = new int[arr.size()];

            for(int i=0; i<arr.size(); i++){
                ans[i] = (int) arr.get(i)[0];
            }

            return ans;
        }
    }
}
