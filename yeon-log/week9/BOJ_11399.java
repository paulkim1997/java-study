import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11399 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 사람의 수
        int[] P = new int[N]; // 인출하는 데 걸리는 시간
        int sum = 0, minSum = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) P[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(P);
        for (int i = 0; i < N; i++) {
            sum += P[i];
            minSum += sum;
        }
        System.out.print(minSum); // 각 사람이 돈을 인출하는데 필요한 시간의 합의 최솟값
    }
}
