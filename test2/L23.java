public class L23 {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = new ListNode();
        ListNode p = head;

        while (true) {
            int minIndex = -1;
            for (int i = 0; i < lists.length; i++) {
                if (lists[i] == null) {
                    continue;
                }
                if (minIndex == -1) {
                    minIndex = i;
                } else if (lists[i].val <= lists[minIndex].val) {
                    minIndex = i;
                }
            }
            if (minIndex != -1) {
                p.next = lists[minIndex];
                p = p.next;
                lists[minIndex] = lists[minIndex].next;
            } else {
                break;
            }
        }
        p.next = null;

        return head.next;
    }
}
