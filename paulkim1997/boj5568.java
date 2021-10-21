package com.company.di.week3;

import java.io.*;
import java.util.*;

public class boj5568 {
    static int n, m;
    static String selected[], arr[];
    static boolean isUsed[];
    static HashSet<String> hs = new HashSet<>();

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        arr = new String[n];
        isUsed = new boolean[n];
        selected = new String[m];

        for(int i=0;i<n;i++) {
            arr[i] = br.readLine();
        }

        func(0);

        System.out.println(hs.size());
    }

    public static void func(int k) {
        //재귀 함수 종료 조건
        if(k == m) {
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<m;i++) {
                sb.append(selected[i]);
            }
            String made = sb.toString();
            //System.out.println(made);
            hs.add(made);
            //System.out.println(made);
            return;
        }

        for(int i=0;i<n;i++) {
            if(!isUsed[i]) {
                selected[k] = arr[i];
                isUsed[i] = true;
                func(k+1);
                selected[k] = null;
                isUsed[i] = false;
            }
        }
    }

}