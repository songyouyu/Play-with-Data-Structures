/**
 * leetcode 203
 * @author youyusong
 * @date 2018/9/19
 */
public class Solution1 {

    public ListNode removeElements(ListNode head, int val) {

        // 考虑头节点就是需要删除的节点的情况
        while (head != null && head.val == val) {
            ListNode delNode = head;
            head = delNode.next;
            delNode.next = null;
        }

        if (head == null) {
            return null;
        }

        ListNode prev = head;
        while (prev.next != null) {
            if (prev.next.val == val) {
                ListNode delNode = prev.next;
                prev.next = delNode.next;
                delNode.next = null;
            } else {
                prev = prev.next;
            }
        }

        return head;
    }
}
