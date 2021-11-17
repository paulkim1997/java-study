import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import static java.lang.Math.abs;

public class BOJ_2470 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 전체 용액의 수
        int[] value = new int[N]; // 용액의 특성값을 나타내는 정수

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) value[i] = Integer.parseInt(st.nextToken());

        int l = 0, r = N - 1;
        Arrays.sort(value);

        int res1 = 0, res2 = 0, temp = Integer.MAX_VALUE;

        while (l < r) {
            // 수의 차이가 0에 가까울수록 res 값 갱신
            int sum = abs(value[l] + value[r]);
            if (sum < temp) {
                temp = sum;
                res1 = value[l]; res2 = value[r];
            }
            // 0에 가깝도록 위치 조정
            if (value[l] + value[r] > 0) r--;
            else l++;
        }
        System.out.print(res1 + " " + res2);
    }
}
