import java.util.*;
import java.io.*;

//생각해 낸 방법 : m개를 뽑아서 하는건데...
//판 입력받을때 치킨집이면 배열에 저장 시켜두자

public class boj15686 {
    static int n, m, totalChicken;
    static int board[][];
    static boolean isUsed[];
    static Pair selected[];
    static ArrayList<Pair> chicken;
    static int dx[] = {1,0,-1,0};
    static int dy[] = {0,-1,0,1};

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        chicken = new ArrayList<>();
        board = new int[n+1][n+1];
        totalChicken = 0;
        selected = new Pair[m];
        for(int i=0;i<n;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++) {
                int num = Integer.parseInt(st.nextToken());
                board[i][j] = num;
                //치킨집이면 좌표 저장
                if(num == 2) {
                    totalChicken++;
                    chicken.add(new Pair(i,j));
                }
            }
        }

        isUsed = new boolean[totalChicken];

        dfs(0);


    }

    public static void dfs(int k) {
        //재귀함수 종료 조건
        if(k == m) {
            Queue<Pair> q = new LinkedList<>();
            //bfs 시작
            for(int i=0;i<m;i++) {
                q.add(selected[i]);
            }
            while(!q.isEmpty()) {
                Pair cur = q.remove();
                for(int dir=0;dir<4;dir++) {
                    int nx = cur.x + dx[dir];
                    int ny = cur.y + dy[dir];

                    if(nx < 0 || nx >= n || ny < 0 || ny >= n) continue;


                }
            }
        }

        for(int i=0;i<totalChicken;i++) {
            if(!isUsed[i]) {
                selected[i] = chicken.get(i);
                isUsed[i] = true;
                dfs(i+1);
                isUsed[i] = false;
            }
        }
    }

    public static class Pair {
        int x, y;
        public Pair(int x, int y) {
            super();
            this.x = x;
            this.y = y;
        }
    }
}