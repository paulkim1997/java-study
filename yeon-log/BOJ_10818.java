import java.util.Arrays;
import java.util.Scanner;

public class BOJ_10818 {
    private static int N;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); // 정수의 개수
        int[] arr = new int[N]; // N개의 정수를 담는 배열
        for (int i = 0; i < N; i++) arr[i] = sc.nextInt();
        sc.close();
        // 오름차순 정렬 -> 첫번째가 최소 마지막이 최대
        Arrays.sort(arr);
        System.out.println(arr[0] + " " + arr[N - 1]);
    }
}
