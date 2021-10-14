package com.company.di.week2;

import java.util.*;
import java.io.*;

public class boj10814 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        String arr[][] = new String[n][2];

        for(int i=0;i<n;i++) {
            st = new StringTokenizer(br.readLine(), " " );

            arr[i][0] = st.nextToken();
            arr[i][1] = st.nextToken();
        }

        Arrays.sort(arr, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                return Integer.parseInt(o1[0]) - Integer.parseInt(o2[0]);
            }
        });

        for(int i=0;i<n;i++) {
            System.out.println(arr[i][0] + " " + arr[i][1]);
        }
    }
}
