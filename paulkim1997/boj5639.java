import java.util.*;
import java.io.*;

public class boj5639 {
    static ArrayList<Integer> preOrder;
    static int n;
    static StringBuilder sb;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        preOrder = new ArrayList<>();

        while(true) {
            String input = br.readLine();
            if(input == null) {
                break;
            }
            preOrder.add(Integer.parseInt(input));
        }

        n = preOrder.size();
        getPostOrder(0, n-1);
        System.out.println(sb);
    }

    //재귀적으로 서브 트리 탐색하며 postOrder 만듬
    static void getPostOrder(int start, int end) {
        if(start > end) return;

        //현재 서브트리에서 첫번째 애는 루트
        int root = preOrder.get(start);

        //오른쪽 원소를 찾기위해 루트 다음 원소부터 탐색
        int right = start+1;
        for(int i=start + 1; i<=end; i++) {
            //루트보다 큰건 오른쪽에 다 있음. 그중 가장 첫번째로 큰게 루트의 오른쪽 자식
            if(root < preOrder.get(i)) {
                right = i;
                break;
            }
        }

        //왼쪽 서브트리에서 재귀
        getPostOrder(start+1, right-1);
        //오른쪽 서브트리에서 재귀
        getPostOrder(right, end);
        //POST ORDER니까 탐색 다 하고 root 추가
        sb.append(root + "\n");
    }
}
