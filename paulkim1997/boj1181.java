package com.company.di.week2;

import java.util.*;
import java.io.*;

public class boj1181 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String arr[] = new String[n];
        for(int i=0;i<n;i++) {
            arr[i] = br.readLine();
        }

        //중복 제거 위해 set에 넣었다가 다시 배열로
        HashSet<String> hashSet = new HashSet<>(Arrays.asList(arr));
        arr = hashSet.toArray(new String[0]);

        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length() == o2.length()) {
                    return o1.compareTo(o2);
                } else {
                    return o1.length() - o2.length();
                }
            }
        });


        for(String s : arr) {
            System.out.println(s);
        }
    }
}
