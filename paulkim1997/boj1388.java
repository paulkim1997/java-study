import java.util.*;
import java.io.*;

public class boj1388 {
    static int n,m;
    static int answer = 0;
    static char board[][];
    static boolean vis[][];
    static int dx1[] = {-1,1};
    static int dy1[] = {0,0};
    static int dx2[] = {0,0};
    static int dy2[] = {-1,1};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new char[n][m];
        vis = new boolean[n][m];

        for(int i=0;i<n;i++) {
            String input = br.readLine();
            for(int j=0;j<m;j++) {
                board[i][j] = input.charAt(j);
            }
        }
        //입력 완료

        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(!vis[i][j]) {
                    if(board[i][j] == '|') {
                        bfs(i,j,1);
                    } else if(board[i][j] == '-') {
                        bfs(i,j,2);
                    }
                }
            }
        }

        System.out.println(answer);
    }

    static void bfs(int a, int b, int flag) {
        // |
        if(flag == 1) {
            Queue<Pair> q = new LinkedList<>();
            q.add(new Pair(a,b));
            vis[a][b] = true;

            while(!q.isEmpty()) {
                Pair cur = q.poll();
                for(int dir = 0;dir < 2; dir++) {
                    int nx = cur.x + dx1[dir];
                    int ny = cur.y + dy1[dir];

                    if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                    if(vis[nx][ny] || board[nx][ny] == '-') continue;

                    q.add(new Pair(nx, ny));
                    vis[nx][ny] = true;
                }
            }
            answer++;
        } // -
        else if(flag == 2) {
            Queue<Pair> q = new LinkedList<>();
            q.add(new Pair(a,b));
            vis[a][b] = true;

            while(!q.isEmpty()) {
                Pair cur = q.poll();
                for(int dir = 0;dir < 2; dir++) {
                    int nx = cur.x + dx2[dir];
                    int ny = cur.y + dy2[dir];

                    if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                    if(vis[nx][ny] || board[nx][ny] == '|') continue;

                    q.add(new Pair(nx, ny));
                    vis[nx][ny] = true;
                }
            }
            answer++;
        }
    }

    static class Pair {
        int x;
        int y;
        public Pair(int x, int y ) {
            this.x = x;
            this.y = y;
        }
    }
}
