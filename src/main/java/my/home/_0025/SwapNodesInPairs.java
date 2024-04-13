package my.home._0025;

import java.util.ArrayList;
import java.util.List;

public class SwapNodesInPairs {

    public static void main(String[] args) {
        ListNode node = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        System.out.println(reverseKGroup(node, 2));
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        List<List<ListNode>> node = new ArrayList<>();

        ListNode currentNode = head;
        List<ListNode> tempList = new ArrayList<>();
        while (currentNode != null) {
            tempList.add(currentNode);
            if (tempList.size() == k) {
                node.add(tempList);
                tempList = new ArrayList<>();
            }
            currentNode = currentNode.next;
        }
        if (!tempList.isEmpty()) {
            node.add(tempList);
        }
        ListNode newHead = new ListNode(-1);
        currentNode = newHead;
        for (List<ListNode> listNodes : node) {
            if (listNodes.size() < k) {
                currentNode.next = listNodes.get(0);
                break;
            }
            for (int i = listNodes.size() - 1; i >= 0; i--) {
                currentNode.next = listNodes.get(i);
                currentNode = currentNode.next;
                currentNode.next = null;
            }
        }
        return newHead.next;
    }
}