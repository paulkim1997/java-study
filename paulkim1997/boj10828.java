package com.company.di;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class boj10828 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> s = new Stack<>();
        int count = Integer.parseInt(br.readLine());

        for(int i=0;i<count;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            if("push".equals(command)) {
                int num = Integer.parseInt(st.nextToken());
                s.push(num);
            } else if("pop".equals(command)) {
                if(s.empty()) {
                    System.out.println("-1");
                } else {
                    System.out.println(s.pop());
                }
            } else if("size".equals(command)) {
                System.out.println(s.size());
            } else if("empty".equals(command)) {
                if(s.empty()) {
                    System.out.println("1");
                } else {
                    System.out.println("0");
                }
            } else if("top".equals(command)) {
                if(s.empty()) {
                    System.out.println("-1");
                } else {
                    System.out.println(s.peek());
                }
            }
        }
    }
}
