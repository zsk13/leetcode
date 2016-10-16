package leetcode.practice46;

import java.util.ArrayList;
import java.util.List;

public class Solution1 {
  public List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    boolean[] visited = new boolean[nums.length];
    permute_help(nums, result, visited, new ArrayList<Integer>());
    return result;
  }

  private void permute_help(int[] nums, List<List<Integer>> result, boolean[] visited,
      List<Integer> todo) {
    if (todo.size() == nums.length) {
      result.add(new ArrayList(todo)); // wrong when result.add(todo)
      return;
    }
    for (int i = 0; i < nums.length; i++) {
      if (visited[i]) {
        continue;
      }
      visited[i] = true;
      todo.add(nums[i]);
      permute_help(nums, result, visited, todo);
      visited[i] = false;
      todo.remove(new Integer(nums[i]));
    }
  }
}
