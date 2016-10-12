package leetcode.practice24;

public class Test {
  public static void main(String[] args) {
    ListNode l1 = new ListNode(1, null);
    ListNode l2 = new ListNode(2, l1);
    ListNode l3 = new ListNode(3, l2);
    ListNode l4 = new ListNode(4, l3);
    Solution1 s1 = new Solution1();
    ListNode head = s1.swapPairs(l4);
    while (head != null) {
      System.out.println(head.val);
      head = head.next;
    }
  }
}
