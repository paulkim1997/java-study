package com.company.di.week3;

import java.util.*;
import java.io.*;

public class boj7568 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int input[][] = new int[n][2];
        for(int i=0;i<n;i++) {
            st = new StringTokenizer(br.readLine());
            input[i][0] = Integer.parseInt(st.nextToken());
            input[i][1] = Integer.parseInt(st.nextToken());
        }

        //입력이 최대 50명이기 때문에 모두 탐색해도됨 50 x 50 해봤자 2500번 탐색
        for(int i=0;i<n;i++) {
            int count = 1;
            for(int j=0;j<n;j++) {
                if(input[i][0] < input[j][0] && input[i][1] < input[j][1]) {
                    count++;
                }
            }
            sb.append(count).append(" ");
        }

        System.out.println(sb.toString());
    }
}
