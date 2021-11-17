import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14888 {

    static int maxValue = -1000000000, minValue = 1000000000;
    //static int maxValue = Integer.MIN_VALUE, minValue = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 수의 개수
        int[] A = new int[N];
        int[] op = new int[4];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) A[i] = Integer.parseInt(st.nextToken());

        //  합이 N-1인 4개의 정수(차례대로 덧셈, 뺄셈, 곱셈, 나눗셈의 개수)
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) op[i] = Integer.parseInt(st.nextToken());

        solve(A[0], 1, N, A, op);
        // 만들 수 있는 식의 결과의 최댓값과 최소값
        System.out.println(maxValue + "\n" +minValue);
    }
    static void solve(int res, int cnt, int N, int[] A, int[] op) {
        for (int i = 0; i < 4; i++) {
            if (op[i] > 0) {
                op[i]--;
                // 재귀 함수를 돌고 res 와 cnt 는 이전 값으로 복귀(BackTracking)
                if (i == 0) solve(res + A[cnt], cnt + 1, N, A, op);
                else if (i == 1) solve(res - A[cnt], cnt + 1, N, A, op);
                else if (i == 2) solve(res * A[cnt], cnt + 1, N, A, op);
                else if (i == 3) solve(res / A[cnt], cnt + 1, N, A, op);
                op[i]++; // 순서 바꾸어 다시 재귀 돌리기 위해
            }
        }
        if (cnt == N) {
            if (maxValue < res) maxValue = res;
            if (minValue > res) minValue = res;
        }
    }
}
