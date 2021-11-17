import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import static java.lang.Math.abs;
import static java.lang.Math.min;

public class BOJ_14889 {

    static int N, res = Integer.MAX_VALUE;
    static int[][] S;
    static boolean[] check;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); // N 명의 선수
        S = new int[N][N];
        check = new boolean[N];

        for (int i = 0; i < N; i++) { // 선수들의 능력치
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) S[i][j] = Integer.parseInt(st.nextToken());
        }
        split(0, 0); // 팀 나누기
        System.out.println(res); // 스티트와 링크 팀 능력치 차이 최소값 출력
    }

    static void split(int idx, int count){
        // nCn/2: n명중 n/2명을 뽑는다.
        if (count == N / 2) {
            skill();
            return;
        }
        // combination
        for (int i = idx; i < N; i++) {
            if (check[i]) continue;
            check[i] = true;
            split(i + 1, count + 1);
            check[i] = false;
        }
    }

    // 두 팀의 능력치 차이를 계산하는 함수
    static void skill() {
        int start = 0, link = 0;
        // 스타트와 링크 팀 능력치 합 구하기
        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (check[i] && check[j]) {
                    start += S[i][j]; start += S[j][i];
                }
                else if (!check[i] && !check[j]) {
                    link += S[i][j]; link += S[j][i];
                }
            }
        }
        // 두 팀의 점수 차이 최솟값 갱신
        int comp = abs(start - link);
        res = min(comp, res);
    }
}
