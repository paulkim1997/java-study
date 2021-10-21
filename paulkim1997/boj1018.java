package com.company.di.week3;
//완전 탐색인건 알겠는데, 로직 고민된다
//완성된 체스판이 2가지 경운데 그걸 만들어놓고 비교를할까?

import java.io.*;
import java.util.*;

public class boj1018 {

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        String board[] = new String[n];

        String board1[] = {
                "BWBWBWBW",
                "WBWBWBWB",
                "BWBWBWBW",
                "WBWBWBWB",
                "BWBWBWBW",
                "WBWBWBWB",
                "BWBWBWBW",
                "WBWBWBWB",
        };
        String board2[] = {
                "WBWBWBWB",
                "BWBWBWBW",
                "WBWBWBWB",
                "BWBWBWBW",
                "WBWBWBWB",
                "BWBWBWBW",
                "WBWBWBWB",
                "BWBWBWBW",
        };

        //판 입력 받음
        for(int i=0;i<n;i++) {
            board[i] = br.readLine();
        }

        //정답 최대값으로
        int answer = Integer.MAX_VALUE;

        //모든 경우의 수 확인
        for(int i=0;i<=n-8;i++) {
            for(int j=0;j<=m-8;j++) {
                int ans1 = 0;
                int ans2 = 0;
                for(int k=0;k<8;k++) {
                    for(int l=0;l<8;l++) {
                        if(board[i+k].charAt(j+l) != board1[k].charAt(l)) {
                            ans1++;
                        }

                        if(board[i+k].charAt(j+l) != board2[k].charAt(l)) {
                            ans2++;
                        }
                    }
                }
                if(answer > ans1) {
                    answer = ans1;
                }
                if(answer > ans2) {
                    answer = ans2;
                }
            }
        }

        System.out.println(answer);
    }
}
