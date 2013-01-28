package learning.ctci.linkedlists;

/**
 * @author aburghelea
 * @since 1/28/13 - 7:46 PM
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