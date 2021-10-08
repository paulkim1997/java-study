package com.company.di;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj10845 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        Queue<Integer> q = new LinkedList<>();
        int back = 0;
        int count = Integer.parseInt(br.readLine());

        for(int i=0;i<count;i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if("push".equals(command)) {
                int num = Integer.parseInt(st.nextToken());
                q.add(num);
                back = num;
            } else if("pop".equals(command)) {
                if(q.isEmpty()) {
                    System.out.println("-1");
                } else {
                    System.out.println(q.remove());
                }
            } else if("size".equals(command)) {
                System.out.println(q.size());
            } else if("empty".equals(command)) {
                if(q.isEmpty()) {
                    System.out.println("1");
                } else {
                    System.out.println("0");
                }
            } else if("front".equals(command)) {
                if(q.isEmpty()) {
                    System.out.println("-1");
                } else {
                    System.out.println(q.peek());
                }
            } else if("back".equals(command)) {
                if(q.isEmpty()) {
                    System.out.println("-1");
                } else {
                    System.out.println(back);
                }
            }
        }
    }
}

//    push X: 정수 X를 큐에 넣는 연산이다.
//        pop: 큐에서 가장 앞에 있는 정수를 빼고, 그 수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
//        size: 큐에 들어있는 정수의 개수를 출력한다.
//        empty: 큐가 비어있으면 1, 아니면 0을 출력한다.
//        front: 큐의 가장 앞에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
//        back: 큐의 가장 뒤에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.