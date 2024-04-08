package my.home._0019;

public class RemoveNthNodeFromEndofList {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1, new ListNode(2));
        int n = 2;
        System.out.println(removeNthFromEnd(l1, n).toString());
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode currentNode = head;
        ListNode previousNode = null;
        int count = 0;
        while (currentNode != null) {
            count = count + 1;
            if (count > n) {
                previousNode = previousNode == null ? head : previousNode.next;
            }
            currentNode = currentNode.next;
        }
        if (previousNode != null) {
            previousNode.next = previousNode.next.next;
        } else {
            head = head.next;
        }
        return head;
    }
}