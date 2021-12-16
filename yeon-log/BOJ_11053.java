import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import static java.lang.Math.max;

public class BOJ_11053 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 수열의 크기
        int A[] = new int[N];
        int dp[] = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            A[i] = Integer.parseInt(st.nextToken());

        int res = 0;
        for (int i = 0; i < N; i++) {
            dp[i] = 1; // 수열이 만들어지지 않아도 해당 길이는 1
            for (int j = 0; j < i; j++) {
                // 증가하기 위한 수열의 조건을 만족하는지: A[i] > A[j]
                // 이미 더 긴 LIS 를 찾아 갱신하지 않았는지: dp[j] >= dp[i]
                if (A[i] > A[j] && dp[j] >= dp[i])
                    dp[i] = dp[j] + 1;
            }
            // 가장 긴 증가하는 부분 수열의 길이 갱신
            if (res < dp[i]) res = dp[i];
        }
        System.out.print(res);
    }
}