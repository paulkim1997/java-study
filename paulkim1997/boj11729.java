import java.util.*;
import java.io.*;

public class boj11729 {
    static int n;
    static StringBuilder sb;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        sb = new StringBuilder();
        System.out.println((int) Math.pow(2,n)-1);
        func(n,1,2,3);
        System.out.println(sb);
    }

    static void func(int n, int start, int mid, int end) {
        if(n == 1) {
            sb.append(start + " " + end + "\n");
        } else {
            //n-1 개를 1-> 2
            func(n-1,start,end,mid);
            //1개를 1-> 3
            sb.append(start + " " + end + "\n");
            //n-1개를 2->3
            func(n-1, mid, start, end);
        }
    }
}
