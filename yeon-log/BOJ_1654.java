import java.io.*;
import java.util.StringTokenizer;

public class BOJ_1654 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken()); // 랜선의 개수
        int N = Integer.parseInt(st.nextToken()); // 만들고자 하는 랜선 개수

        int arr[] = new int[K];

        long min = 0, max = 0;

        for (int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            if(max < arr[i]) max = arr[i];
        }
        max++; // mid 가 0으로 나눠지는 문제 막기위해
        while (min < max) {
            // 만들고자하는 랜선 개수(N)과 만들어진 cnt 를 비교하여
            // 최대길이와 최소 길이 조정
            long mid = (min + max) / 2, cnt = 0;
            for (int i = 0; i < arr.length; i++) cnt += (arr[i] / mid);
            if (cnt >= N) min = mid + 1;
            else if (cnt < N) max = mid;
        }
        System.out.println(min-1);
    }
}