import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// 18428. 감시 피하기 / 골드 5 / 31분
class BOJ_18428 extends FI1 {
    static boolean check;
    static int n;
    static int[]dy={-1,1,0,0};
    static int[]dx={0,0,-1,1};
    static char[][] arr;
    static List<int[]> empty;
    static List<int[]> students;
    static List<int[]> teachers;

    public static void main(String[] args) throws IOException {
        initFI();
        n=nextInt();
        arr=new char[n][n];
        empty=new ArrayList<>();
        students=new ArrayList<>();
        teachers=new ArrayList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                arr[i][j]=next().charAt(0);
                if(arr[i][j]=='X')empty.add(new int[]{i,j});
                if(arr[i][j]=='S')students.add(new int[]{i,j});
                if(arr[i][j]=='T')teachers.add(new int[]{i,j});
            }
        }
        /*
        1. 빈곳 3개 골라서 벽으로 만들기
        2. 선생님들 이동 시뮬레이션
        3. 학생들중 한명이라도 방문체크가된다면 다음 벽 3개만들기 조합
        4. 시뮬레이션 끝났는데 학생들 다 방문체크 안돼있다면 yes
         */
        play();
        System.out.println(check?"YES":"NO");
    }

    private static void play(){
        int size=empty.size();
        for(int i=0;i<size;i++){
            for(int j=i+1;j<size;j++){
                for(int k=j+1;k<size;k++){
                    int[] a=empty.get(i);
                    int[] b=empty.get(j);
                    int[] c=empty.get(k);
                    arr[a[0]][a[1]]='#';
                    arr[b[0]][b[1]]='#';
                    arr[c[0]][c[1]]='#';
                    move();
                    arr[a[0]][a[1]]='X';
                    arr[b[0]][b[1]]='X';
                    arr[c[0]][c[1]]='X';
                }
            }
        }
    }

    private static void move() {
        boolean[][] visited=new boolean[n][n];

        // 감시로직
        for(int[]t:teachers){
            visited[t[0]][t[1]]=true;
            //상
            int y=t[0],x=t[1],d=0;
            while(true){
                int ny=y+dy[d],nx=x+dx[d];
                if(ny<0||nx<0||ny>=n||nx>=n||arr[ny][nx]=='#')break;
                visited[ny][nx]=true;
                y=ny;x=nx;
            }
            //하
            y=t[0];x=t[1];d=1;
            while(true){
                int ny=y+dy[d],nx=x+dx[d];
                if(ny<0||nx<0||ny>=n||nx>=n||arr[ny][nx]=='#')break;
                visited[ny][nx]=true;
                y=ny;x=nx;

            }
            //좌
            y=t[0];x=t[1];d=2;
            while(true){
                int ny=y+dy[d],nx=x+dx[d];
                if(ny<0||nx<0||ny>=n||nx>=n||arr[ny][nx]=='#')break;
                visited[ny][nx]=true;
                y=ny;x=nx;

            }
            //우
            y=t[0];x=t[1];d=3;
            while(true){
                int ny=y+dy[d],nx=x+dx[d];
                if(ny<0||nx<0||ny>=n||nx>=n||arr[ny][nx]=='#')break;
                visited[ny][nx]=true;
                y=ny;x=nx;
            }
        }

        for(int[] s:students){
            if(visited[s[0]][s[1]])return;
        }
        check=true;
    }
}