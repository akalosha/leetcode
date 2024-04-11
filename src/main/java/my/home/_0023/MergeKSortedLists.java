package my.home._0023;

public class MergeKSortedLists {

    public static void main(String[] args) {
        ListNode[] lists = new ListNode[]{new ListNode(1, new ListNode(4, new ListNode(5))),
                new ListNode(1, new ListNode(3, new ListNode(4))),
                new ListNode(2, new ListNode(6))};
        System.out.println(mergeKLists(lists));
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        ListNode head = new ListNode(-1);
        ListNode currentNode = head;
        int minNodeIndex = -1;
        boolean shouldContinue = true;
        while (shouldContinue) {
            if (minNodeIndex != -1) {
                currentNode.next = lists[minNodeIndex];
                currentNode = currentNode.next;
                lists[minNodeIndex] = lists[minNodeIndex].next;
            }
            shouldContinue = false;
            minNodeIndex = -1;
            for (int i = 0; i < lists.length; i++) {
                if (lists[i] == null) {
                    continue;
                }
                if (minNodeIndex == -1 || lists[i].val < lists[minNodeIndex].val) {
                    minNodeIndex = i;
                    shouldContinue = true;
                }
            }
        }
        return head.next;
    }
}