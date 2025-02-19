import java.util.*;

class GraphDemo {
    private Map<Integer, List<Integer>> adjList = new HashMap<>();

    void addEdge(int v, int w) {
        adjList.putIfAbsent(v, new ArrayList<>());
        adjList.get(v).add(w);
    }

    void DFS(int start, Set<Integer> visited) {
        if (!visited.contains(start)) {
            System.out.print(start + " ");
            visited.add(start);
            for (int neighbor : adjList.getOrDefault(start, new ArrayList<>())) {
                DFS(neighbor, visited);
            }
        }
    }

    public static void main(String args[]) {
        GraphDemo g = new GraphDemo();
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 3);

        System.out.println("DFS starting from node 0:");
        g.DFS(0, new HashSet<>());
    }
}
