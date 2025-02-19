class LinkedListDemo {
    Node head;

    public boolean hasCycle() {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        LinkedListDemo list = new LinkedListDemo();
        list.head = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);
        Node fourth = new Node(4);

        list.head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = second;

        System.out.println("Does the linked list have a cycle? " + list.hasCycle());
    }
}
