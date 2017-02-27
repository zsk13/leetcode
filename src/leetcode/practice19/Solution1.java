package leetcode.practice19;

public class Solution1 {
  public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode h = head;
    ListNode h2 = head;
    while (n-- != 0) {
      head = head.next;
    }
    if (head == null) {
      return h.next;
    }
    while (head.next != null) {
      head = head.next;
      h2 = h2.next;
    }
    h2.next = h2.next.next;
    return h;
  }
}
