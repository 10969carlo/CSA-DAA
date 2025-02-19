import java.util.*;

class QueueDemo {
    private int V;
    private LinkedList<Integer> adj[];

    QueueDemo(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList<>();
    }

    void addEdge(int v, int w) {
        adj[v].add(w);
    }

    void BFS(int start) {
        boolean visited[] = new boolean[V];
        Queue<Integer> queue = new LinkedList<>();

        visited[start] = true;
        queue.add(start);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.print(node + " ");

            for (int neighbor : adj[node]) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
    }

    public static void main(String args[]) {
        QueueDemo q = new QueueDemo(4);
        q.addEdge(0, 1);
        q.addEdge(0, 2);
        q.addEdge(1, 2);
        q.addEdge(2, 0);
        q.addEdge(2, 3);
        q.addEdge(3, 3);

        System.out.println("BFS starting from node 2:");
        q.BFS(2);
    }
}
