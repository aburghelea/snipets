package learning.ctci.linkedlists;

/**
 * @author aburghelea
 * @since 1/28/13 - 7:47 PM
 */
public class DigitLinkedList {
    LinkedListNode<Integer> head;

    Integer add(Integer data) {
        int carry = data / 10;
        if (head == null) {
            head = new LinkedListNode<Integer>(data % 10);
        } else {
            head = new LinkedListNode<Integer>(data % 10, head);
        }

        return carry;
    }


    @Override

    public String toString() {
        if (head == null)
            return "";
        StringBuilder sb = new StringBuilder();
        LinkedListNode<Integer> head = this.head;
        while (head.next != null) {
            sb.append(head.toString()).append(" -> ");
            head = head.next;
        }
        sb.append(head.toString()).append(";");

        return sb.toString();
    }

}

class DigitLinkedListUtils {
    public static DigitLinkedList sum(DigitLinkedList first, DigitLinkedList second) {
        LinkedListNode<Integer> firstPosition = first.head;
        LinkedListNode<Integer> secondPosition = second.head;
        DigitLinkedList result = new DigitLinkedList();
        Integer firstDigit, secondDigit, carry = 0;
        while (firstPosition != null || secondPosition != null) {
            firstDigit = getDigiValue(firstPosition);
            secondDigit = getDigiValue(secondPosition);
            carry = result.add(firstDigit + secondDigit + carry);
            firstPosition = getNextPosition(firstPosition);
            secondPosition = getNextPosition(secondPosition);
        }
        if (carry > 0)
            result.add(carry);
        if (carry >= 10)
            throw new ArithmeticException("Stack may have been implemented wrongly");

        return result;
    }

    private static Integer getDigiValue(LinkedListNode<Integer> position) {
        Integer digit;
        if (position == null)
            digit = 0;
        else
            digit = position.data;
        return digit;
    }

    private static LinkedListNode<Integer> getNextPosition(LinkedListNode<Integer> secondPosition) {
        if (secondPosition == null)
            return null;

        return secondPosition.next;
    }
}