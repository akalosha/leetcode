package my.home._0021;

public class MergeTwoSortedLists {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        System.out.println(mergeTwoLists(l1, l2).toString());
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        boolean isFirst = true;
        ListNode res = null;
        ListNode currentNode = null;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                ListNode newNode = new ListNode(list1.val);
                list1 = list1.next;
                if (isFirst) {
                    currentNode = newNode;
                    res = currentNode;
                    isFirst = false;
                } else {
                    currentNode.next = newNode;
                    currentNode = currentNode.next;
                }
            } else {
                ListNode newNode = new ListNode(list2.val);
                list2 = list2.next;
                if (isFirst) {
                    currentNode = newNode;
                    res = currentNode;
                    isFirst = false;
                } else {
                    currentNode.next = newNode;
                    currentNode = currentNode.next;
                }
            }
        }
        ListNode lastPart = list1 != null ? list1 : list2;
        if (currentNode != null) {
            currentNode.next = lastPart;
        } else {
            return lastPart;
        }
        return res;
    }
}