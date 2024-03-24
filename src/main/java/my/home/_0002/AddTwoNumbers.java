package my.home._0002;

public class AddTwoNumbers {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        ListNode result = addTwoNumbers(l1, l2);
        System.out.println(result);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int razrad = 0;
        ListNode firstNode = null;
        ListNode lastNode = null;
        while (l1 != null || l2 != null) {
            int res = razrad;
            if (l1 != null) {
                res += l1.val;
            }
            if (l2 != null) {
                res += l2.val;
            }
            razrad = res >= 10 ? 1 : 0;
            if (firstNode == null) {
                firstNode = new ListNode(res % 10);
                lastNode = firstNode;
            } else {
                ListNode newNode = new ListNode(res % 10);
                lastNode.next = newNode;
                lastNode = newNode;
            }
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (razrad == 1) {
            ListNode newNode = new ListNode(1);
            lastNode.next = newNode;
        }
        return firstNode;
    }
}