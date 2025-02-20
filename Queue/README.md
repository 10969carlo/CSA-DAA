# QueueDemo - Breadth-First Search (BFS) Algorithm
# Asciinema: https://asciinema.org/a/704420
## Overview

This Java program demonstrates the **Breadth-First Search (BFS)** algorithm applied to a graph represented as an adjacency list. BFS is a traversal algorithm that explores all the neighbors of a node before moving to the next level of neighbors. It is typically implemented using a queue to maintain the list of nodes to visit.

### Key Methods

1. **addEdge(int v, int w)**:
   - Adds an edge from node `v` to node `w` in the graph. This creates a directed edge from `v` to `w`.

2. **BFS(int start)**:
   - Performs a **Breadth-First Search (BFS)** starting from the node `start`.
   - It uses a queue to keep track of the nodes to visit, and a `visited` array to prevent revisiting nodes.

3. **main(String[] args)**:
   - Initializes a graph, adds edges, and starts the BFS traversal from node 2.

## Algorithm

### Breadth-First Search (BFS) Algorithm:

1. **Input**: A starting node (`start`).
2. **Process**:
   - Initialize a `visited[]` array to mark nodes as visited.
   - Use a queue to explore each node level by level:
     - Mark the starting node as visited and enqueue it.
     - While the queue is not empty, dequeue a node and print it.
     - For each unvisited neighbor of the current node, mark it as visited and enqueue it.
3. **Output**: The nodes of the graph are printed in the order they are visited during the BFS traversal.

### Example Walkthrough

1. **Graph Construction**:
   The following edges are added to the graph:
   - `0 -> 1`
   - `0 -> 2`
   - `1 -> 2`
   - `2 -> 0`
   - `2 -> 3`
   - `3 -> 3`

   The adjacency list representation of the graph is:

2. **BFS Traversal**:
Starting from node `2`, the BFS algorithm will visit the nodes in the following order:
- Start at node `2`, visit `2`.
- Visit node `0` (neighbor of `2`), visit node `3` (neighbor of `2`).
- Visit node `1` (neighbor of `0`).

The output will be:

## Code

```java
import java.util.*;

class QueueDemo {
 private int V;
 private LinkedList<Integer> adj[];

 // Constructor to initialize graph with V vertices
 QueueDemo(int v) {
     V = v;
     adj = new LinkedList[v];
     for (int i = 0; i < v; ++i)
         adj[i] = new LinkedList<>();
 }

 // Method to add an edge from vertex v to vertex w
 void addEdge(int v, int w) {
     adj[v].add(w);
 }

 // Breadth-First Search (BFS) method
 void BFS(int start) {
     boolean visited[] = new boolean[V];
     Queue<Integer> queue = new LinkedList<>();

     // Mark the starting node as visited and enqueue it
     visited[start] = true;
     queue.add(start);

     // Traverse the graph
     while (!queue.isEmpty()) {
         int node = queue.poll();  // Dequeue a node
         System.out.print(node + " ");  // Print the visited node

         // Visit all unvisited neighbors and enqueue them
         for (int neighbor : adj[node]) {
             if (!visited[neighbor]) {
                 visited[neighbor] = true;
                 queue.add(neighbor);
             }
         }
     }
 }

 // Main method to demonstrate BFS
 public static void main(String args[]) {
     QueueDemo q = new QueueDemo(4);
     
     // Adding edges to the graph
     q.addEdge(0, 1);
     q.addEdge(0, 2);
     q.addEdge(1, 2);
     q.addEdge(2, 0);
     q.addEdge(2, 3);
     q.addEdge(3, 3);

     // Starting BFS traversal from node 2
     System.out.println("BFS starting from node 2:");
     q.BFS(2);
 }
}
