package com.company.di.week2;

import java.io.*;
import java.util.*;

public class boj1946 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());

        for(int i=0;i<t;i++) {
            int n = Integer.parseInt(br.readLine());
            int answer = 1;
            int arr[][] = new int[n][2];

            for(int j=0;j<n;j++) {
                st = new StringTokenizer(br.readLine());

                arr[j][0] = Integer.parseInt(st.nextToken());
                arr[j][1] = Integer.parseInt(st.nextToken());

            }

            //서류 기준으로 먼저 정렬
            Arrays.sort(arr, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[0] - o2[0];
                }
            });

            //정렬 잘 됐나?
//            for(int j=0;j<n;j++) {
//                System.out.println(arr[j][0] + " " + arr[j][1]);
//            }

            //첫번째 지원자의 면접 점수가 기준
            int min = arr[0][1];
            for(int j=1;j<n;j++) {
                if(arr[j][1] < min) {
                    min = arr[j][1];
                    answer++;
                }
            }

            System.out.println(answer);
        }
    }
}
