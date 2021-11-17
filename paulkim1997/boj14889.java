import java.util.*;
import java.io.*;

public class boj14889 {
    static int n;
    static int board[][];
    static int team1[], team2[];
    static boolean isUsed[];
    static int res = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        board = new int[n][n];
        team1 = new int[n/2];
        team2 = new int[n/2];
        isUsed = new boolean[n];
        StringTokenizer st;

        for(int i=0;i<n;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++)  {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //n개 중 n/2개 뽑아보자 (중복 X, 순서 O)
        //한팀의 i번째 멤버 고르는 함수
        func(0);
        System.out.println(res);
    }

    static void func(int k) {
        // n/2 명 골랐으면!
        if(k == n/2) {
//            for(int a : team1) {
//                System.out.print(a + " ");
//            }
//            System.out.println();
            //점수 계산
            calculate();
            return;
        }

        for(int i=0;i<n;i++) {
            if(!isUsed[i]) {
                if(k==0 || team1[k-1] < i+1) {
                    team1[k] = i+1;
                    isUsed[i] = true;
                    func(k+1);
                    isUsed[i] = false;
                }
            }
        }
    }

    static void calculate() {
        int aScore =0, bScore = 0;
        int a[] = new int[n/2];
        int b[] = new int[n/2];
        int aIndex =0 , bIndex = 0;

        for(int i=0;i<n;i++) {
            if(isUsed[i]) {
                a[aIndex++] = i;
            } else {
                b[bIndex++] = i;
            }
        }

        for(int i=0;i<a.length;i++) {
            for(int j=i+1;j<a.length;j++) {
                aScore += board[a[i]][a[j]] + board[a[j]][a[i]];
            }
        }

        for(int i=0;i<b.length;i++) {
            for(int j=i+1;j<b.length;j++) {
                bScore += board[b[i]][b[j]] + board[b[j]][b[i]];
            }
        }

        int answer = Math.abs(aScore - bScore);
        if(answer < res)
            res = answer;
    }
}
