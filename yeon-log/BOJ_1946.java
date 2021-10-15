import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ_1946 {
    private static int[][] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            arr = new int[N][2];

            for (int j = 0; j < arr.length; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                arr[j][0] = Integer.parseInt(st.nextToken()); // 서류심사 성적
                arr[j][1] = Integer.parseInt(st.nextToken()); // 면접 성적
            }

            // 동석차가 없으므로 이렇게 정렬가능
            Arrays.sort(arr, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[0] - o2[0];
                }
            });

            int judge = arr[0][1]; // 서류 1등을 기준
            int cnt = 1;

            for (int j = 1; j < arr.length; j++) {
                if (arr[j][1] < judge) {
                    cnt++; judge = arr[j][1];
                }
            }
            System.out.println(cnt);
        }
    }
}
