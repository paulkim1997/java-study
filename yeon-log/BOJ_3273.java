import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_3273 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 수열의 크기
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0; i<n; i++) arr[i]=Integer.parseInt(st.nextToken());

        Arrays.sort(arr);

        int s = 0, e = n-1; // 시작과 끝
        int x = Integer.parseInt(br.readLine());
        int cnt = 0;

        // 투포인터로 ai + aj = x 를 만족하는 쌍의 개수 구하기
        while(s < e){
            if(arr[s]+arr[e] == x) { cnt++; e--; }
            else if(arr[s]+arr[e] > x) e--;
            else if(arr[s]+arr[e] < x) s++;
        }
        System.out.print(cnt);
    }
}
