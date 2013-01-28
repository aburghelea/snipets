package learning.ctci.linkedlists;

import java.util.HashSet;

/**
 * @author aburghelea
 * @since 1/28/13 - 2:44 PM
 */

public class LinkedList<E> {
    LinkedListNode<E> head;

    void add(E data) {
        if (head == null) {
            head = new LinkedListNode<>(data);
        } else {
            head = new LinkedListNode<>(data, head);
        }
    }

    LinkedListNode<E> addAndReturn(E data) {
        add(data);
        return head;
    }

    public String toString() {
        if (head == null)
            return "";
        StringBuilder sb = new StringBuilder();
        LinkedListNode<E> head = this.head;
        while (head.next != null) {
            sb.append(head.toString()).append(" -> ");
            head = head.next;
        }
        sb.append(head.toString()).append(";");

        return sb.toString();
    }

    public void removeDuplicates() {
        HashSet<E> previousApparences = new HashSet<>();
        LinkedListNode<E> previous = null;
        LinkedListNode<E> head = this.head;
        while (head != null) {
            if (previousApparences.contains(head.data))
                previous.next = head.next;
            else {
                previousApparences.add(head.data);
                previous = head;
            }
            head = head.next;
        }
    }

    public void removeDuplicatesSlowly() {
        if (head == null || head.next == null)
            return;
        LinkedListNode<E> current = head.next;
        LinkedListNode<E> previous = head;
        while (current != null) {
            if (previousEncountered(current)) {
                previous.next = current.next;
            } else {
                previous = head;
            }
            current = current.next;
        }
    }

    private boolean previousEncountered(LinkedListNode<E> current) {
        LinkedListNode<E> head = this.head;

        while (head != null && !head.equals(current)) {
            if (head.data.equals(current.data))
                return true;

            head = head.next;
        }

        return false;
    }

    public LinkedListNode<E> nthLastElements(int size) {
        if (this.size() < size)
            return null;

        LinkedListNode<E> head = this.head, last = this.head;

        while (size > 0) {
            last = last.next;
            size--;
        }

        while (last != null) {
            last = last.next;
            head = head.next;
        }

        return head;
    }

    private int size() {
        int size = 0;
        LinkedListNode<E> head = this.head;

        while (head != null) {
            size++;
            head = head.next;
        }

        return size;
    }

    public void deleteInteriorNodesWhithoutAccessingAncestors(LinkedListNode<E> node) {
        if (node == null || node.next == null)
            return;
        node.data = node.next.data;
        node.next = node.next.next;
    }
}

