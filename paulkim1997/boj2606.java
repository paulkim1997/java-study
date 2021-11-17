import java.util.*;
import java.io.*;

public class boj2606 {
    static int n, conn;
    static int arr[][];
    static boolean vis[];
    static int answer = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        conn = Integer.parseInt(br.readLine());
        vis = new boolean[n+1];

        arr = new int[n+1][n+1];

        for (int i = 0; i < conn; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[x][y] = 1;
            arr[y][x] = 1;
        }

        dfs(1);

        System.out.println(answer);
    }

    static void dfs(int k) {
        vis[k] = true;

        for(int i=1;i<=n;i++) {
            if(arr[k][i] == 0) continue;
            if(vis[i]) continue;

            dfs(i);
            answer++;
        }
    }
}
