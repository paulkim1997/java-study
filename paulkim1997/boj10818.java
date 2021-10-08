package com.company.di;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj10818 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pq = new PriorityQueue<>(((o1, o2) -> o2 - o1));
        int min = 1000001;

        int count = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for(int i=0;i<count;i++) {
            int num = Integer.parseInt(st.nextToken());
            pq.add(num);
            if(num < min) {
                min = num;
            }
        }
        System.out.println(min + " " + pq.peek());
    }
}