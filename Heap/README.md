# LinkedListDemo - Cycle Detection in Linked List
# Asciinema: https://asciinema.org/a/704414
## Overview

This Java program demonstrates the detection of a cycle in a linked list using Floyd's Cycle-Finding Algorithm (also known as the Tortoise and Hare Algorithm). It checks whether a linked list contains a cycle by using two pointers: a slow pointer and a fast pointer.

### How it Works

- **Cycle Detection**: 
  - The algorithm uses two pointers that traverse the list at different speeds:
    - The **slow pointer** moves one node at a time.
    - The **fast pointer** moves two nodes at a time.
  - If the linked list has a cycle, the fast pointer will eventually catch up to the slow pointer.
  - If the fast pointer reaches the end of the list (i.e., the next pointer is `null`), then the list does not have a cycle.

### Key Methods

1. **hasCycle()**:
   - Detects whether the linked list contains a cycle by moving two pointers (slow and fast) through the list.
   - If the slow and fast pointers meet, a cycle exists; otherwise, there is no cycle.

2. **main(String[] args)**:
   - Demonstrates the cycle detection by creating a linked list with a cycle and prints whether the list contains a cycle.

## Algorithm

### Cycle Detection Algorithm:

1. **Input**: The head node of a linked list.
2. **Process**:
   - Initialize two pointers: slow and fast, both pointing to the head.
   - Traverse the list with the following steps:
     - Move the slow pointer one step at a time.
     - Move the fast pointer two steps at a time.
     - If the slow and fast pointers meet, return `true` (cycle detected).
     - If the fast pointer reaches the end (i.e., `null`), return `false` (no cycle).
3. **Output**: Returns `true` if a cycle is detected, `false` otherwise.

### Example Walkthrough

1. **List Construction**:
   The following nodes are added to the linked list:
   - `1 -> 2 -> 3 -> 4 -> (cycle to 2)`
   
   The linked list structure looks like:

2. **Cycle Detection**:
- The slow pointer starts at node `1` and moves one node at a time.
- The fast pointer starts at node `1` and moves two nodes at a time.
- Eventually, both pointers will meet at node `2`, confirming a cycle.

The output will be:

## Code

```java
class Node {
 int data;
 Node next;

 Node(int data) {
     this.data = data;
     this.next = null;
 }
}

class LinkedListDemo {
 Node head;

 // Method to detect cycle in the linked list using Floyd's Cycle-Finding Algorithm
 public boolean hasCycle() {
     Node slow = head;
     Node fast = head;

     while (fast != null && fast.next != null) {
         slow = slow.next;             // Move slow pointer by 1 step
         fast = fast.next.next;        // Move fast pointer by 2 steps

         if (slow == fast) {           // Cycle detected
             return true;
         }
     }
     return false;                      // No cycle
 }

 // Main method to test the cycle detection
 public static void main(String[] args) {
     LinkedListDemo list = new LinkedListDemo();
     
     // Creating nodes for the linked list
     list.head = new Node(1);
     Node second = new Node(2);
     Node third = new Node(3);
     Node fourth = new Node(4);

     // Connecting nodes
     list.head.next = second;
     second.next = third;
     third.next = fourth;
     fourth.next = second; // Creates a cycle by linking fourth node to second node

     // Checking if the linked list has a cycle
     System.out.println("Does the linked list have a cycle? " + list.hasCycle());
 }
}
