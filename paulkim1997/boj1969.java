package com.company.di.week3;

import java.util.*;
import java.io.*;

public class boj1969 {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        String arr[] = new String[n];

        for(int i=0;i<n;i++) {
            arr[i] = br.readLine();
        }

        //사전 순 이니까 A C G T 순으로 저장 하자
        for(int i=0;i<m;i++) {
            int temp[] = new int[5];
            for(int j=0;j<n;j++) {
                switch(arr[j].charAt(i)) {
                    case 'A':
                        temp[0]++;
                        break;
                    case 'C':
                        temp[1]++;
                        break;
                    case 'G':
                        temp[2]++;
                        break;
                    case 'T' :
                        temp[3]++;
                        break;
                    default:
                        break;
                }
            }
            int max = Integer.MIN_VALUE;
            int maxIndex = 0;
            if(temp[0] == temp[1] &&
                temp[1] == temp[2] &&
                    temp[2] == temp[3]) {
                maxIndex = 0;
            } else {
                for(int j=0;j<4;j++) {
                    if(temp[j] > max) {
                        max = temp[j];
                        maxIndex = j;
                    }
                }
            }
            switch(maxIndex) {
                case 0:
                    sb.append("A");
                    break;
                case 1:
                    sb.append("C");
                    break;
                case 2:
                    sb.append("G");
                    break;
                case 3:
                    sb.append("T");
                    break;
                default:
                    break;
            }
        }
        //S 출력함
        System.out.println(sb.toString());
        int count = 0;
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(arr[i].charAt(j) != sb.toString().charAt(j))
                    count++;
            }
        }
        System.out.println(count);
    }
}
