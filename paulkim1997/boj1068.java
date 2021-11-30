import java.util.*;
import java.io.*;

public class boj1068 {
    static int n, root, erased;
    static ArrayList<Integer>[] childs;
    static int[] leaf;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        childs = new ArrayList[n];
        leaf = new int[n];
        for(int i=0;i<n;i++) {
            childs[i] = new ArrayList<>();
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++) {
            int parent = Integer.parseInt(st.nextToken());
            if(parent == -1) {
                root = i;
                continue;
            }
            childs[parent].add(i);
        }

        erased = Integer.parseInt(br.readLine());

        //삭제 해줌
        for(int i=0;i<n;i++) {
            if(childs[i].contains(erased)) {
                childs[i].remove(childs[i].indexOf(erased));
            }
        }
        if(root != erased) {
            dfs(root);
        }
        System.out.println(leaf[root]);
    }

    static void dfs(int x) {
        if(childs[x].isEmpty()) {
            leaf[x] = 1;
        }
        for(int y : childs[x]) {
            dfs(y);
            leaf[x] += leaf[y];
        }
    }
}
