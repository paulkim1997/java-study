import java.util.*;
import java.io.*;

public class boj15649 {
    static int n,m;
    static int arr[];
    static boolean isUsed[];
    static StringBuilder sb;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[m+1];
        isUsed = new boolean[n+1];
        func(0);
        System.out.println(sb);
    }

    public static void func(int k) {
        if(k == m) {
            for(int i=0;i<m;i++) {
                sb.append(arr[i] + " ");
            }
            sb.append("\n");
            return;
        }

        for(int i=1;i<=n;i++) {
            if(!isUsed[i]) {
                arr[k] = i;
                isUsed[i] = true;
                func(k+1);
                isUsed[i] = false;
            }
        }
    }
}
