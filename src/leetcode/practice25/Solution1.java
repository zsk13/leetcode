package leetcode.practice25;

public class Solution1 {
  public ListNode reverseKGroup(ListNode head, int k) {
    ListNode movehead = head;
    for (int i = 0; i < k; i++) {
      if (movehead != null) {
        movehead = movehead.next;
      } else {
        return head;
      }
    }
    ListNode nexthead = reverseKGroup(movehead, k);
    for (int i = 0; i < k; i++) {
      ListNode temp = head.next;
      head.next = nexthead;
      nexthead = head;
      head = temp;
    }
    return nexthead;
  }
}
