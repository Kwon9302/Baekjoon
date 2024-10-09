import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
//          5 6
//          1
//        5 1 1
//        1 2 2
//        1 3 3
//        2 3 4
//        2 4 5
//        3 4 6
public class Program {
    static int V, E, start;
    static ArrayList<ArrayList<Node>> graph;

    static class Node {// 다음 노드의 인덱스와, 그 노드로 가는데 필요한 비용을 담고 있다.
        int idx, cost;

        Node(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(br.readLine());
        graph = new ArrayList<ArrayList<Node>>();
        for (int i = 0; i < V + 1; i++) {
            graph.add(new ArrayList<Node>());
        }
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(s).add(new Node(e, c));
        }

        int[] dist = new int[V + 1]; // 최소 비용을 저장할 배열
        for (int i = 0; i < V + 1; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        PriorityQueue<Node> q = new PriorityQueue<Node>((o1, o2) -> Integer.compare(o1.cost, o2.cost));
        q.offer(new Node(start, 0));
        // 해당 노드를 선택한 것이나 마찬가지 이므로, dist[start] = 0으로 갱신.
        dist[start] = 0;
        while (!q.isEmpty()) {
            Node curNode = q.poll();
            if (dist[curNode.idx] < curNode.cost) {
                continue;
            }
            for (int i = 0; i < graph.get(curNode.idx).size(); i++) {
                Node nxtNode = graph.get(curNode.idx).get(i);
                if (dist[nxtNode.idx] > curNode.cost + nxtNode.cost) {
                    dist[nxtNode.idx] = curNode.cost + nxtNode.cost;
                    q.offer(new Node(nxtNode.idx, dist[nxtNode.idx]));
                }
            }
        }
        for (int i = 1; i < dist.length; i++) {
            if(dist[i] == Integer.MAX_VALUE) {
                System.out.println("INF");
            } else {
                System.out.println(dist[i]);
            }
        }
    }
}