public class ProgrammersNumberExpression {
    class Solution {
        public int solution(int n) {
            int count=0;

            for(int i=1; i<n; i++){
                int sum=i;
                for(int j=i+1; j<=n; j++){
                    sum+=j;
                    if(sum==n){
                        count++;
                        break;
                    } else if(sum>n){
                        break;
                    }
                }
            }
            return count+1;
        }
    }
}
