package my.home._0023;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MergeKSortedLists {

    public static void main(String[] args) {
        ListNode[] lists = new ListNode[]{new ListNode(1, new ListNode(4, new ListNode(5))),
                new ListNode(1, new ListNode(3, new ListNode(4))),
                new ListNode(2, new ListNode(6))};
        System.out.println(mergeKLists(lists));
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        List<Integer> numbers = new ArrayList<>();
        for (ListNode list : lists) {
            while (list != null) {
                numbers.add(list.val);
                list = list.next;
            }
        }
        Collections.sort(numbers);
        ListNode head = new ListNode(-1);
        ListNode current = head;
        for (Integer number : numbers) {
            current.next = new ListNode(number);
            current = current.next;
        }

        return head.next;
    }
}