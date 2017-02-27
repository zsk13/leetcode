package leetcode.practice23;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution1 {
  public ListNode mergeKLists(ListNode[] lists) {
    PriorityQueue<ListNode> q = new PriorityQueue<ListNode>(new ListNodeComparator());
    if (lists.length == 0) {
      return null;
    }
    for (int i = 0; i < lists.length; i++) {
      if (lists[i] != null) {
        q.offer(lists[i]);
      }
    }

    ListNode head = q.poll();
    ListNode h = head;
    if (head == null) {
      return null;
    }
    if (head.next != null) {
      q.offer(head.next);
    }

    while (q.size() != 0) {
      ListNode temp = q.poll();
      head.next = temp;
      head = head.next;
      if (temp.next != null) {
        q.offer(temp.next);
      }
    }
    return h;
  }

  class ListNodeComparator implements Comparator<ListNode> {

    public int compare(ListNode l1, ListNode l2) {
      return l1.val - l2.val;
    }

  }
}
