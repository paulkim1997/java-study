package com.company.di;

import java.io.*;
import java.util.*;

public class boj1427 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();
        List<Integer> arr = new ArrayList<>();

        for(int i=0;i<input.length();i++) {
            arr.add(input.charAt(i)-'0');
        }

        arr.sort(Collections.reverseOrder());

        for(Integer num : arr) {
            bw.append(num.toString());
        }

        bw.flush();
        bw.close();
    }
}
