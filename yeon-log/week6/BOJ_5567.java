import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_5567 {
    static private int n, list;
    static private boolean[] check;
    static private boolean[][] friend;
    static private int cnt = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine()); // 상근이의 동기의 수
        list = Integer.parseInt(br.readLine()); // 리스트의 길이

        check = new boolean[n +1];
        friend = new boolean[n +1][n +1];

        for (int i = 0; i < list; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            friend[a][b] = true; friend[b][a] = true; // a와 b가 친구
        }
        invite();
        System.out.print(cnt);
    }

    static void invite() {
        for (int i = 2; i <= n; i++) {
            if (friend[1][i]) {
                if (!check[i]) { // 상근이 친구 초대
                    check[i] = true;
                    cnt++;
                }
                // 상근이 친구의 친구 초대
                for (int next = 2; next <= n; next++) {
                    if (!friend[i][next] || check[next]) continue;
                    check[next] = true;
                    cnt++;
                }
            }
        }
    }
}
