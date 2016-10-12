package leetcode.practice2;

public class Practice2 {
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode result = new ListNode(0);
    ListNode resultHead = result;
    int addOne = 0;
    while (l1 != null && l2 != null) {
      result.val = (l1.val + l2.val + addOne) % 10;
      addOne = (l1.val + l2.val + addOne) / 10;
      result.next = new ListNode(0);
      result = result.next;
      l1 = l1.next;
      l2 = l2.next;
    }
    if (l1 != null) {
      while (l1 != null) {
        result.val = (l1.val + addOne) % 10;
        addOne = (l1.val + addOne) / 10;
        result.next = new ListNode(0);
        result = result.next;
        l1 = l1.next;
      }
    } else if (l2 != null) {
      while (l2 != null) {
        result.val = (l2.val + addOne) % 10;
        addOne = (l2.val + addOne) / 10;
        result.next = new ListNode(0);
        result = result.next;
        l2 = l2.next;
      }
    }
    result.val = addOne;

    if (result.val == 0) {
      ListNode resultTemp = resultHead;
      while (resultTemp.next.next != null) {
        resultTemp = resultTemp.next;
      }
      resultTemp.next = null;
    }
    return resultHead;

  }
}
