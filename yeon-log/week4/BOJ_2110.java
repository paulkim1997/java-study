import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2110 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 집의 개수
        int C = Integer.parseInt(st.nextToken()); // 공유기의 개수

        int x[] = new int[N]; // 집의 좌표
        for (int i = 0; i < N; i++) x[i] = Integer.parseInt(br.readLine());
        Arrays.sort(x);

        int l = 1, r = x[N - 1] - x[0]; // 최소거리와 최대거리

        // 공유기 설치 기준에 따라 공유기 설치
        while (l <= r) {
            int mid = (l + r) / 2;
            int s = x[0], cnt = 1;
            for (int i = 1; i < N; i++) {
                // 최대거리에 맞춰 공유기 설치가 가능하면 공유기 수를 증가시키고 비교 위치 변경
                if (x[i] - s >= mid) {
                    cnt++;
                    s = x[i];
                }
            }
            //  설치해야 하는 공유기의 수와 비교해서 간격 조정
            if (cnt >= C) l = mid + 1;
             else if (cnt < C) r = mid - 1;
        }
        System.out.println(r);
    }
}
