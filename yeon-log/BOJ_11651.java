import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11651 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 점의 개수
        int[][] arr = new int[N][2]; // 점의 개수행, 2(y,x)열

        StringTokenizer st;
        for(int i = 0; i < N; i++) {
            // y 기준으로 먼저이므로
            st = new StringTokenizer(br.readLine());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][0] = Integer.parseInt(st.nextToken());
        }

        /* Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {} });
            아래와 같은 로직, 아래는 람다식으로 표현 */

        Arrays.sort(arr, (e1, e2) -> {
            // 두번째 원소(y)가 같다면 첫번째 원소(x)로 비교
            if(e1[0] == e2[0]) return e1[1] - e2[1];
             else return e1[0] - e2[0];
        });

        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i< N ; i++) sb.append(arr[i][1] + " " + arr[i][0]).append('\n');
        System.out.println(sb);
    }
}
