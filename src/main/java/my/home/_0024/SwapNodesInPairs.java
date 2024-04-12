package my.home._0024;

public class SwapNodesInPairs {

    public static void main(String[] args) {
        ListNode node = new ListNode(1, new ListNode(2, new ListNode(3)));
        System.out.println(swapPairs(node));
    }

    public static ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        ListNode newHead = head.next;
        ListNode current = head;
        while (current != null) {
            ListNode first = current;
            ListNode second = current.next;
            ListNode third = second != null ? second.next : null;
            if (second != null) second.next = first;
            first.next = third != null ? third.next : null;
            current = third;
            if (first.next == null && current != null) {
                first.next = current;
                break;
            }
        }
        return newHead;
    }
}