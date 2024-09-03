import java.io.*;
import java.util.*;
 
public class Main {
    static int atoi(String str) {
        return Integer.parseInt(str);
    }
    static int N, M;
    static ArrayList<Node> A = new ArrayList<>();
    static int start, end, max = Integer.MIN_VALUE;
    static int [] parent;
    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
 
    static void pro() {
        Collections.sort(A, (o1, o2)->{
            return o2.wei - o1.wei;
        });
 
        for (Node n : A) {
            union(n.from, n.to);
            if(find(start) == find(end)){
                System.out.println(n.wei);
                return;
            }
        }
    }
 
    static void union(int u, int v) {
        u = find(u);
        v = find(v);
 
        if(u == v) return;
 
        if(u > v){
            parent[u] = v;
        }
        else{
            parent[v] = u;
        }
    }
 
    static int find(int v) {
        if(v == parent[v]) return v;
 
        parent[v] = find(parent[v]);
        return parent[v];
    }
 
 
    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
 
        N = atoi(st.nextToken());
        M = atoi(st.nextToken());
 
        parent = new int[N+1];
        for(int i = 1; i <= N; i++) parent[i] = i;
 
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = atoi(st.nextToken());
            int to = atoi(st.nextToken());
            int wei = atoi(st.nextToken());
 
            A.add(new Node(from, to, wei));
        }
 
        st = new StringTokenizer(br.readLine());
        start = atoi(st.nextToken());
        end = atoi(st.nextToken());
    }
 
    static class Node {
        int from, to, wei;
 
        public Node(int from, int to, int wei) {
            this.from = from;
            this.to = to;
            this.wei = wei;
        }
    }
}