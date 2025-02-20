# GraphDemo - Depth-First Search (DFS) Algorithm
# Asciinema: https://asciinema.org/a/704417

## Overview

This Java program demonstrates the implementation of a graph and how to traverse it using the **Depth-First Search (DFS)** algorithm. The graph is represented using an adjacency list, and DFS is performed starting from a specified node.

### How it Works

- **Graph Representation**: The graph is represented using a HashMap where:
  - The key is an integer (representing the node).
  - The value is a list of integers, where each integer in the list is a neighbor of the key node.
  
- **Depth-First Search (DFS)**: The DFS algorithm traverses the graph starting from a given node. It explores as far as possible along each branch before backtracking.

### Key Methods

1. **addEdge(int v, int w)**: 
   - Adds an edge from node `v` to node `w`. If node `v` doesn't already exist in the adjacency list, it's initialized with an empty list of neighbors.
   
2. **DFS(int start, Set<Integer> visited)**: 
   - Performs a depth-first traversal starting from the `start` node. 
   - It marks nodes as visited, prints them, and recursively visits each unvisited neighbor.

### Main Program Flow

- The `main` method creates a graph, adds some edges, and starts the DFS traversal from node 0.
- It prints the nodes visited during the traversal in the order they were reached.

## Algorithm

### Depth-First Search (DFS) Algorithm:

1. **Input**: A starting node (`start`) and a set of visited nodes (`visited`).
2. **Process**:
   - If the current node `start` has not been visited:
     - Print the current node.
     - Mark it as visited.
     - For each neighbor of the current node, perform a recursive DFS call on that neighbor.
3. **Output**: The nodes of the graph are printed in the order they are visited by the DFS algorithm.

### Example Walkthrough

1. **Graph Construction**:
   The following edges are added to the graph:
   - `0 -> 1`
   - `0 -> 2`
   - `1 -> 2`
   - `2 -> 3`

   This creates the following adjacency list:
   
2. **DFS Traversal**:
Starting from node `0`, the DFS algorithm will visit the nodes in the following order:
- Start at node `0`.
- Visit node `1`.
- Visit node `2`.
- Visit node `3`.

The output will be:


## Code

```java
import java.util.*;

class GraphDemo {
 private Map<Integer, List<Integer>> adjList = new HashMap<>();

 // Method to add an edge from node v to node w
 void addEdge(int v, int w) {
     adjList.putIfAbsent(v, new ArrayList<>());
     adjList.get(v).add(w);
 }

 // Depth First Search (DFS) method
 void DFS(int start, Set<Integer> visited) {
     if (!visited.contains(start)) {
         System.out.print(start + " ");
         visited.add(start);
         for (int neighbor : adjList.getOrDefault(start, new ArrayList<>())) {
             DFS(neighbor, visited);
         }
     }
 }

 // Main method to demonstrate DFS
 public static void main(String args[]) {
     GraphDemo g = new GraphDemo();
     
     // Adding edges to the graph
     g.addEdge(0, 1);
     g.addEdge(0, 2);
     g.addEdge(1, 2);
     g.addEdge(2, 3);

     // Starting DFS traversal from node 0
     System.out.println("DFS starting from node 0:");
     g.DFS(0, new HashSet<>());
 }
}


