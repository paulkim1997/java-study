package com.company.di.week3;

import java.io.*;
import java.util.*;

class Pair {
    int x, y;
    public Pair(int x, int y) {
        super();
        this.x = x;
        this.y = y;
    }
}

public class boj17086 {
    static int n, m;
    static int board[][];
    static int dist[][];
    static int dx[] = {-1,-1,0,1,1,1,0,-1};
    static int dy[] = {0,1,1,1,0,-1,-1,-1};

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Queue<Pair> q = new LinkedList<>();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new int[n+1][m+1];
        dist = new int[n+1][m+1];

        for(int a[] : dist) {
            Arrays.fill(a, Integer.MAX_VALUE);
        }

        for(int i=0;i<n;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++) {
                int num = Integer.parseInt(st.nextToken());
                board[i][j] = num;
                if(num == 1){
                    q.add(new Pair(i,j));
                    dist[i][j] = 0;
                }
            }
        }

        int answer = Integer.MIN_VALUE;

        while(!q.isEmpty()) {
            Pair cur = q.remove();
            //System.out.println(pair.x + " " + pair.y);
            for(int dir=0;dir<8;dir++) {
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;

                if(dist[nx][ny] > dist[cur.x][cur.y] +1 ) {
                    dist[nx][ny] = dist[cur.x][cur.y] + 1;
                    q.add(new Pair(nx,ny));
                    if(answer < dist[nx][ny])
                        answer = dist[nx][ny];
                }
            }
        }

        //dist 배열 출력
//        for(int i=0;i<n;i++) {
//            for(int j=0;j<m;j++) {
//                System.out.print(dist[i][j] + " ");
//            }
//            System.out.println();
//        }
        System.out.println(answer);
    }
}
