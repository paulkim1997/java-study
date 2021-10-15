package com.company.di.week2;

import java.util.*;
import java.io.*;

public class boj2750 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int arr[] = new int[n];

        for(int i=0;i<n;i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        for(int i : arr) {
            System.out.println(i);
        }

    }
}
