import java.util.PriorityQueue;

public class Test {
    public static void main(String[] args) {
        PriorityQueue<Node> pq = new PriorityQueue<Node>((o1,o2) -> Integer.compare(o1.cost, o2.cost));

        pq.add(new Node(2, 1));
        pq.add(new Node(1, 2));
        pq.add(new Node(1, 4));
        pq.add(new Node(1, 3));

        while (!pq.isEmpty()) {
            Node node = pq.poll(); // 가장 우선순위가 높은 요소를 가져와 제거
            System.out.println(node.idx + "," + node.cost);
        }
    }
    static class Node {// 다음 노드의 인덱스와, 그 노드로 가는데 필요한 비용을 담고 있다.
        int idx, cost;

        Node(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }
    }
    }


