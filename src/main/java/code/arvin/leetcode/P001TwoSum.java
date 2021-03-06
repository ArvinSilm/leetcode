package code.arvin.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/two-sum/">Two Sum</a>
 * <p>
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 * <p>
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * <p>
 * You can return the answer in any order.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Output: Because nums[0] + nums[1] == 9, we return [0, 1].
 * Example 2:
 * <p>
 * Input: nums = [3,2,4], target = 6
 * Output: [1,2]
 * Example 3:
 * <p>
 * Input: nums = [3,3], target = 6
 * Output: [0,1]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 2 <= nums.length <= 103
 * <p>
 * -109 <= nums[i] <= 109
 * <p>
 * -109 <= target <= 109
 * <p>
 * Only one valid answer exists.
 */
public class P001TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> tmpMap = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            if (tmpMap.containsKey(target - nums[i])) {
                return new int[]{tmpMap.get(target - nums[i]), i};
            }
            tmpMap.put(nums[i], i);
        }
        return null;
    }
}
