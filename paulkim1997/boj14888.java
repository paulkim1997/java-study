import java.util.*;
import java.io.*;

public class boj14888 {
    static int n;
    static int arr[];
    static int op[];
    static boolean isUsed[];
    static int max = Integer.MAX_VALUE;
    static int min = Integer.MIN_VALUE;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        op = new int[4];
        isUsed = new boolean[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0;i<n;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<4;i++) {
            int count = Integer.parseInt(st.nextToken());
            for(int j=0;j<count;j++) {
                op[i]++;
            }
        }

        func(0);
    }

    static void func(int k) {
        //연산자는 n-1개
        if(k == n-1) {

        }

        for(int i=0;i<n-1;i++) {
            if(!isUsed[i]) {

            }
        }
    }
}
