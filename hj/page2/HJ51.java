import java.util.Scanner;

class ListNode {
    int val;
    ListNode m_pNext;
};

public class HJ51 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int n = in.nextInt();
            ListNode head = new ListNode();
            ListNode p = head;
            for (int i = 0; i < n; i++) {
                ListNode node = new ListNode();
                node.val = in.nextInt();
                p.m_pNext = node;
                p = p.m_pNext;
            }
            int k = in.nextInt();

            ListNode p1 = head;
            ListNode p2 = head;

            while (k-- > 0) {
                p1 = p1.m_pNext;
            }
            while (p1 != null) {
                p1 = p1.m_pNext;
                p2 = p2.m_pNext;
            }
            System.out.println(p2.val);
        }
        in.close();
    }
}
