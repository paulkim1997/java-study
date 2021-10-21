import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import static java.lang.Math.min;

public class BOJ_1018 {

    private static boolean[][] board;
    private static int res = 64;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        board = new boolean[N][M]; // N*M 크기의 보드

        // 보드의 흰색 검은색 부분을 체크
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++)
                if (s.charAt(j) == 'W') board[i][j] = true;
                else board[i][j] = false;
        }

        for (int i = 0; i < N - 7; i++)
            for (int j = 0; j < M - 7; j++)
                check(i, j);
        System.out.println(res); // 다시 칠해야하는 정사각형 개수
    }

    public static void check(int x, int y) {
        int cnt = 0;
        boolean flag = board[x][y];

        for (int i = x; i < x + 8; i++) {
            for (int j = y; j < y + 8; j++) {
                if (board[i][j] != flag) cnt++;
                flag = !flag;
            } flag = !flag;
        }
        cnt = min(cnt, 64 - cnt);
        res = min(res, cnt);
    }
}
