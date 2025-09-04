/*  Linked List Group Reverse

You are given the head of a Singly linked list. You have to reverse every k node in the linked list and return the head of the modified list.
Note: If the number of nodes is not a multiple of k then the left-out nodes at the end, should be considered as a group and must be reversed.

Examples:

Input: k = 2,
   
Output: 2 -> 1 -> 4 -> 3 -> 6 -> 5
Explanation: Linked List is reversed in a group of size k = 2.
   
Input: k = 4,
   
Output: 4 -> 3 -> 2 -> 1 -> 6 -> 5
Explanation: Linked List is reversed in a group of size k = 4.
   
Constraints:
1 ≤ size of linked list ≤ 105
0 ≤ node->data ≤ 106
1 ≤ k ≤ size of linked list  */

import java.util.*;

class Node {
    int data;
    Node next;

    Node(int key) {
        data = key;
        next = null;
    }
}

class LinkedListGroupReverse {
    public Node reverseKGroup(Node head, int k) {
        if (head == null || k <= 1)
            return head;

        List<AbstractMap.SimpleEntry<Node, Node>> v = new ArrayList<>();
        Node temp = head;
        Node first = head;
        int count = 0;

        while (temp != null) {
            count++;
            if (count == k || temp.next == null) {
                v.add(new AbstractMap.SimpleEntry<>(first, temp));
                first = temp.next;
                count = 0;
            }
            temp = temp.next;
        }

        int n = v.size();
        if (n == 0)
            return head; // no full groups

        // Reverse each group
        for (int i = 0; i < n; i++) {
            Node temp0 = null;
            Node temp1 = v.get(i).getKey();
            Node temp2 = temp1.next;
            while (temp1 != v.get(i).getValue()) {
                temp1.next = temp0;
                temp0 = temp1;
                temp1 = temp2;
                if (temp2 != null)
                    temp2 = temp2.next;
            }
            temp1.next = temp0;
        }

        // Connect groups
        for (int i = 1; i < n; i++) {
            v.get(i - 1).getKey().next = v.get(i).getValue();
        }

        v.get(n - 1).getKey().next = null;

        return v.get(0).getValue();
    }
}
