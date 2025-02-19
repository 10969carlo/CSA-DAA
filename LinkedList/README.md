# LinkedListDemo - Cycle Detection in Linked List

## Overview

This Java program demonstrates how to detect a cycle in a linked list using **Floyd's Cycle-Finding Algorithm** (also called the **Tortoise and Hare Algorithm**). The algorithm uses two pointers to traverse the linked list: one moves one step at a time (slow pointer), while the other moves two steps at a time (fast pointer). If there is a cycle, the two pointers will eventually meet.

### Key Methods

1. **hasCycle()**:
   - This method detects if the linked list contains a cycle using two pointers: a slow pointer and a fast pointer.
   - If the slow and fast pointers meet, the list contains a cycle; otherwise, it does not.

2. **main(String[] args)**:
   - This method creates a linked list with a cycle and demonstrates the `hasCycle()` method by checking if the list has a cycle.

## Algorithm

### Cycle Detection Algorithm:

1. **Input**: The head node of a linked list.
2. **Process**:
   - Initialize two pointers: `slow` and `fast`, both pointing to the head node.
   - Traverse the list as follows:
     - Move the `slow` pointer by one node at a time.
     - Move the `fast` pointer by two nodes at a time.
     - If the `slow` and `fast` pointers meet at any point, a cycle is present in the linked list.
     - If the `fast` pointer reaches the end of the list (i.e., `null`), the linked list does not contain a cycle.
3. **Output**: The method returns `true` if a cycle is detected, and `false` if there is no cycle.

### Example Walkthrough

1. **List Construction**:
   The linked list is constructed as follows:
   - `1 -> 2 -> 3 -> 4 -> (cycle to 2)`
   
   The list has a cycle, as node 4 points back to node 2.

2. **Cycle Detection**:
   - The slow pointer starts at node 1 and moves one node at a time.
   - The fast pointer starts at node 1 and moves two nodes at a time.
   - Eventually, both pointers will meet at node 2, confirming the presence of a cycle.

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
