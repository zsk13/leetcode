package leetcode.practice24;

public class Solution1 {
  public ListNode swapPairs(ListNode head) {
    if (head == null) {
      return null;
    }
    ListNode temp1 = head;
    ListNode temp2 = head.next;
    if (temp2 == null) {
      head = temp1;
    } else {
      head = temp2;
    }
    ListNode temp;
    ListNode tempBefore = null;
    while (temp1 != null && temp2 != null) {
      if (tempBefore != null) {
        tempBefore.next = temp2;
      }
      tempBefore = temp1;
      temp = temp2.next;
      temp1.next = temp2.next;
      temp2.next = temp1;
      temp1 = temp;
      if (temp1 == null) {
        temp2 = null;
      } else {
        temp2 = temp1.next;
      }
    }
    return head;
  }
}
