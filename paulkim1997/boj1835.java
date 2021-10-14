package com.company.di.week1;

public class boj1835 {
    public static void main(String[] args) throws Exception {
        boolean arr[] = new boolean[10001];

        for(int i=1;i<10001;i++)  {
            int selfNumber = i;
            int num = i;
            while(num != 0 ) {
                int temp = num % 10;
                selfNumber += temp;
                num /= 10;
            }
            if(selfNumber < 10001)
                arr[selfNumber] = true;
        }

        for(int i=1;i<10001;i++) {
            if(arr[i] == false) {
                System.out.println(i);
            }
        }
    }
}
