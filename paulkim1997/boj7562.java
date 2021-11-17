import java.util.*;
import java.io.*;

public class boj7562 {
    static int t, n;
    static int board[][];
    static int dis[][];
    static int dx[] = {1,2,2,1,-1,-2,-2,-1};
    static int dy[] = {-2,-1,1,2,2,1,-1,-2};
    static int answer;
    static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        t = Integer.parseInt(br.readLine());
        while(t-- > 0) {
            n = Integer.parseInt(br.readLine());

            board = new int[n][n];
            dis = new int[n][n];
            answer = 0;

            int startX, startY, targetX, targetY;
            StringTokenizer st = new StringTokenizer(br.readLine());
            startX = Integer.parseInt(st.nextToken());
            startY = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            targetX = Integer.parseInt(st.nextToken());
            targetY = Integer.parseInt(st.nextToken());

            board[targetX][targetY] = 2;
            if(startX == targetX && startY == targetY) System.out.println(0);
            else
                bfs(startX, startY);
        }
    }

   public static void bfs(int x, int y){
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(x,y));
        dis[x][y] = 0;

        while(!q.isEmpty()) {
            Pair cur = q.poll();
            for(int dir=0;dir<8;dir++) {
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];

                if(nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                if(dis[nx][ny] > 0) continue;

                if(board[nx][ny] == 2) {
                    System.out.println(dis[cur.x][cur.y] + 1);
                    return;
                }

                dis[nx][ny] = dis[cur.x][cur.y] + 1;
                q.add(new Pair(nx, ny));
            }
        }
    }

    public static class Pair {
        int x;
        int y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
