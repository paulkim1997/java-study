import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Num_15686 { // 클래스 시작
	// n -> 도시의 정보, m -> 치킨집 개수의 최솟값, ans -> 정답
    static int n, m, ans = Integer.MAX_VALUE;
    static boolean[] check; // 
    static List<int[]> h, ck;// h -> 집의 좌표, ck -> 치킨 집의 좌표
    
	public static void main(String[] args) { // 메인 클래스 시작
		// TODO Auto-generated method stub
	    
	    Scanner sc = new Scanner(System.in);
	    
        n = sc.nextInt(); // 도시 정보 (n x n)
        m = sc.nextInt(); // 치킨집 개수의 최솟값

        h = new ArrayList<>(); // 집의 위치
        ck = new ArrayList<>(); // 치킨집의 위치

        for (int i = 0; i < n; i++) { // for문 시작
            for (int j = 0; j < n; j++)
                switch (sc.nextInt()) { // switch 문 시작
                    case 1:
                        h.add(new int[]{i, j});
                        break;
                    case 2:
                        ck.add(new int[]{i, j});
                        break;
                } // switch 문 끝 
        } // for문 끝
        
        check = new boolean[ck.size()];
        
        comb(-1, 0);

        System.out.println(ans); // 정답 출력
    } // 메인 클래스 끝

    static void comb(int idx, int cnt) { // comb Class 시작
        if (cnt == m) {
            int dist = 0; // 

            for (int[] a : h) {
                int tmp = Integer.MAX_VALUE;
                for (int i = 0; i < check.length; i++) {
                    if (check[i])
                        tmp = Math.min(tmp, Math.abs(a[0] - ck.get(i)[0]) + Math.abs(a[1] - ck.get(i)[1]));
                }
                dist += tmp;
            }
            ans = Math.min(ans, dist);
            return;
        }

        for (int i = idx + 1; i < check.length; i++) { // for문 시작
        	check[i] = true;
            
            comb(i, cnt + 1);
            
            check[i] = false;
        } // for문 끝
	} // combo Class 끝
} // 클래스 끝
