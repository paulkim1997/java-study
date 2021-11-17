import java.util.*;
import java.io.*;

public class boj7576 {
    static int n,m;
    static int board[][];
    static int dis[][];
    static int dx[] = {1,0,-1,0};
    static int dy[] = {0,1,0,-1};
    static int answer = Integer.MIN_VALUE;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Queue<Pair> q = new LinkedList<>();

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        board = new int[n][m];
        dis = new int[n][m];

        for(int a[] : dis) {
            Arrays.fill(a, -1);
        }

        for(int i=0;i<n;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++) {
                int num = Integer.parseInt(st.nextToken());
                board[i][j] = num;
                if(num == 1) {
                    q.add(new Pair(i,j));
                    dis[i][j] = 0;
                }
            }
        }

        //BFS 시작
        while(!q.isEmpty()) {
            Pair cur = q.poll();
            for(int dir=0;dir<4;dir++) {
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];

                if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if(board[nx][ny] == -1 || dis[nx][ny] > -1) continue;

                dis[nx][ny] = dis[cur.x][cur.y] + 1;
                q.add(new Pair(nx, ny));
            }
        }
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(board[i][j] == 0 && dis[i][j] == -1) {
                    System.out.println(-1);
                    return;
                }
                if(dis[i][j] > answer)
                    answer = dis[i][j];
            }
        }

        System.out.println(answer);
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
