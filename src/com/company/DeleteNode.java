package com.company;

public class DeleteNode {

    static class CircularLinkedList {
        class Node {

            int value;
            Node next;

            public Node(int value) {
                this.value = value;
            }
        }

        Node head = null;
        Node tail = null;

        void add(int data) {
            Node node = new Node(data);

            if (head == null) {
                head = node;
                tail = node;
                node.next = head;
            } else {
                tail.next = node;
                tail = node;
                tail.next = head;
            }
        }

        public void display() {
            Node current = head;
            if (head == null) {
                System.out.println("List is empty");
            } else {
                System.out.println("Nodes of the circular linked list: ");
                do {
                    //Prints each node by incrementing pointer.
                    System.out.print(" " + current.value);
                    current = current.next;
                } while (current != head);
                System.out.println();
            }
        }

        public static void main(String[] args) {
            CircularLinkedList circularLinkedList = new CircularLinkedList();
            circularLinkedList.add(1);
            circularLinkedList.add(2);
            circularLinkedList.add(3);
            circularLinkedList.add(4);
            circularLinkedList.add(5);
            circularLinkedList.display();
        }

        static void deletNode(Node head, int target) {
            Node curr = head;

            do {

            } while (curr != head);
        }

    }

}
