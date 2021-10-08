package com.company.di;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class boj11279 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
        int num = Integer.parseInt(br.readLine());

        for(int i=0;i<num;i++) {
            int cmd = Integer.parseInt(br.readLine());

            if(cmd == 0) {
                if(pq.isEmpty()) {
                    System.out.println("0");
                } else {
                    System.out.println(pq.remove());
                }
            } else {
                pq.add(cmd);
            }
        }
    }
}