package boj_Q1835;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class boj_Q1835 {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		int num = input.nextInt();
		Deque<Integer> deque = new LinkedList<>();
		
		for(int i=num; i>0; i--) {
			if(deque.isEmpty()) deque.add(i);
			else if(i==1) {
				deque.push(i);
				deque.push(deque.pollLast());
			}
			else {
				deque.push(i);
				deque.add(deque.pop());
			}
		}
		while(deque.size()!=0) {
			if(deque.size()==1) System.out.print(deque.poll());
			else System.out.print(deque.poll() +" ");
		}
		input.close();
	}
}
