import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import static java.lang.Math.abs;

public class BOJ_16234 {

    static int N, L, R, num;
    static int A[][], check[][];
    static int[] sum; // 연합의 인구수 합
    static int[] cnt; // 연합의 수
    static int[] dx = {-1, 0, 1, 0}, dy = {0, -1, 0, 1};

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // N*N 크기의 땅
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        A = new int[N][N]; check = new int[N][N];
        sum = new int[N * N + 1]; cnt = new int[N * N + 1];

        // 각 나라의 인구수
        for (int r = 0; r < N; r++) {
            StringTokenizer s = new StringTokenizer(br.readLine());
            for (int c = 0; c < N; c++)
                A[r][c] = Integer.parseInt(s.nextToken());
        }
        solve();
    }

    static void solve() {
        int days = 0, flag = 0;
        while (flag != 1) {
            flag = 0; num = 1;
            Arrays.fill(sum, 0);
            Arrays.fill(cnt, 0);
            for (int i = 0; i < N; i++) Arrays.fill(check[i], 0);
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (check[i][j] != 0) continue;
                    dfs(i, j);
                    // 국가가 하나일때는 연합이 만들어지지 않음
                    if (flag < cnt[num]) flag = cnt[num];
                    num++;
                }
            }

            /* 조건) 국경선이 열려있어 인접한 칸만을 이용해 이동할 수 있으면,
                그 나라를 오늘 하루 동안은 연합!
                연합을 이루고 있는 각 칸의 인구수는 (연합의 인구수) / (연합을 이루고 있는 칸의 개수)
                편의상 소수점은 버림 */

            // 연합이 발생 했을 때, 인구이동을 시작
            if (flag != 1) {
                for (int i = 0; i < N; i++)
                    for (int j = 0; j < N; j++)
                        A[i][j] = sum[check[i][j]] / cnt[check[i][j]];
                days++; // 인구이동 날짜
            }
        }
        System.out.print(days); // 인구 이동이 며칠 동안 발생하는지 출력
    }

    static void dfs(int x, int y) {
        check[x][y] = num; // 기록
        sum[num] += A[x][y]; // 연합 인구수 증가
        cnt[num]++; // 연합의 수 증가

        /* 조건) 국경선을 공유하는 두 나라의 인구 차이가 L명 이상, R명 이하라면,
           두 나라가 공유하는 국경선을 오늘 하루 동안 연다. */
        for (int k = 0; k < 4; k++) {
            int nx = x + dx[k], ny = y + dy[k];
            if (nx < 0 || ny < 0 || nx > N - 1 || ny > N - 1) continue;
            if (check[nx][ny] == 0
                    && (abs(A[x][y] - A[nx][ny]) >= L
                    && abs(A[x][y] - A[nx][ny]) <= R)) dfs(nx, ny);
        }
    }
}
