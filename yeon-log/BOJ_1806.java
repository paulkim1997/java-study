import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1806 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) arr[i] = Integer.parseInt(st.nextToken());

        int s=0, e=1, sum=arr[s], res=Integer.MAX_VALUE;

        while(true){ // 수열의 끝이 아닐동안 반복
            if(sum >= S){
                res = res > e - s ? e - s : res;
                sum -= arr[s++];
            }
            else if(e==N) break;
            else sum+=arr[e++];
        }
        // 합을 만드는 것이 가능할 경우 최소 길이 출력
        if(res==Integer.MAX_VALUE) res = 0;
        System.out.print(res);
    }
}