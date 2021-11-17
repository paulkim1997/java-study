import java.util.*;
import java.io.*;

public class boj5567 {
    static int n, conn, answer=0;
    static int board[][];
    static int dis[];

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        conn = Integer.parseInt(br.readLine());

        board = new int [n+1][n+1];
        dis = new int[n+1];

        Arrays.fill(dis, -1);

        for(int i=0;i<conn;i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            board[x][y] = 1;
            board[y][x] = 1;
        }

        bfs(1);

        for(int a : dis) {
            if(a>0 && a<=2) answer++;
        }

        System.out.println(answer);
    }

    public static void bfs(int k) {
        Queue<Integer> q = new LinkedList<>();

        q.add(k);
        dis[k] = 0;
        int depth = 0;
        while(!q.isEmpty()) {
            int cur = q.poll();
            for(int i=1;i<=n;i++) {
                if(board[cur][i] == 0) continue;
                if(dis[i] > -1) continue;
                q.add(i);
                dis[i] = dis[cur] + 1;
            }
        }
    }
}
