package leetcode.practice47;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution1 {
  public List<List<Integer>> permuteUnique(int[] nums) {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    boolean[] visited = new boolean[nums.length];
    Arrays.sort(nums);
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
      while (i > 0 && i < nums.length && nums[i] == nums[i - 1] && !visited[i - 1])
        i++;
      if (i == nums.length) {
        return;
      }

      if (visited[i]) {
        continue;
      }

      visited[i] = true;
      todo.add(nums[i]);
      permute_help(nums, result, visited, todo);
      visited[i] = false;
      todo.remove(todo.size() - 1);
    }
  }
}
