package learning.ctci.linkedlists;

import java.util.HashSet;
import java.util.Hashtable;

/**
 * @author aburghelea
 * @since 1/28/13 - 2:44 PM
 */

class LinkedListNode<E> {
    E data;
    LinkedListNode<E> next;

    LinkedListNode(E data) {
        this.data = data;
    }

    public LinkedListNode(E data, LinkedListNode<E> next) {
        this.data = data;
        this.next = next;
    }

    @Override
    public String toString() {
        return data.toString();
    }
}

class LinkedList<E> {
    LinkedListNode<E> head;

    void add(E data) {
        if (head == null) {
            head = new LinkedListNode<>(data);
        } else {
            head = new LinkedListNode<>(data, head);
        }
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

    public void removeDuplicates(){
        HashSet<E> previousApparences = new HashSet<>();
        LinkedListNode<E> previous = null;
        LinkedListNode<E> head = this.head;
        while(head != null){
            if (previousApparences.contains(head.data))
                previous.next = head.next;
            else {
                previousApparences.add(head.data);
                previous = head;
            }
            head = head.next;
        }

    }
}

