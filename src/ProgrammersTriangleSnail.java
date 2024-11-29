    import java.util.*;
public class ProgrammersTriangleSnail {
    class Solution {
        public int[] solution(int n) {

            int[][] arr = new int[n][n];
            int[] dx = {1,0,-1};
            int[] dy = {0,1,-1};

            int x=0;
            int y=0;
            int dir=0; //아래0 우측1 왼쪽위대각2
            int num=1;
            int count=0; // 총 블럭개수
            for(int i=1; i<=n; i++){
                count+=i;
            }

            int[] ans= new int[count];
            int ro=0;
            while(ro!=count){
                arr[x][y]=num; // 배열에 숫자 기입

                num++; // 숫자 증가
                int checkX = x+dx[dir]; // 다음 배열 위치 확인
                int checkY = y+dy[dir];
                if(dir==0){
                    if(checkX>= n || arr[checkX][checkY]!=0){
                        dir=1;
                        x+=dx[dir];
                        y+=dy[dir];
                    } else {
                        x+=dx[dir];
                        y+=dy[dir];
                    }
                } else if(dir==1){
                    if(checkY>=n || arr[checkX][checkY]!=0){
                        dir=2;
                        x+=dx[dir];
                        y+=dy[dir];
                    }else {
                        x+=dx[dir];
                        y+=dy[dir];
                    }
                } else if(dir==2){
                    if(arr[checkX][checkY]!=0){
                        dir=0;
                        x+=dx[dir];
                        y+=dy[dir];
                    }else {
                        x+=dx[dir];
                        y+=dy[dir];
                    }
                }
                ro++;
            }

            int c=0;
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    if(arr[i][j]!=0){
                        ans[c]=arr[i][j];
                        c++;
                    } else {
                        break;
                    }
                }
            }
            return ans;
        }
    }
}
