package code.arvin.leetcode;

/**
 * <a href="https://leetcode.com/problems/median-of-two-sorted-arrays/">Median of Two Sorted Arrays</a>
 * <p>
 * Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums1 = [1,3], nums2 = [2]
 * Output: 2.00000
 * Explanation: merged array = [1,2,3] and median is 2.
 * Example 2:
 * <p>
 * Input: nums1 = [1,2], nums2 = [3,4]
 * Output: 2.50000
 * Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
 * Example 3:
 * <p>
 * Input: nums1 = [0,0], nums2 = [0,0]
 * Output: 0.00000
 * Example 4:
 * <p>
 * Input: nums1 = [], nums2 = [1]
 * Output: 1.00000
 * Example 5:
 * <p>
 * Input: nums1 = [2], nums2 = []
 * Output: 2.00000
 * <p>
 * <p>
 * Constraints:
 * <p>
 * nums1.length == m
 * nums2.length == n
 * 0 <= m <= 1000
 * 0 <= n <= 1000
 * 1 <= m + n <= 2000
 * -106 <= nums1[i], nums2[i] <= 106
 */
public class P004MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        int[] n1 = new int[]{1, 2, 3, 4};
        int[] n2 = new int[]{};
        System.out.println(findMedianSortedArrays(n1, n2));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length, len2 = nums2.length;
        if (len1 + len2 == 0) {
            return 0;
        }
        if (len1 == 0) {
            int x = len2 / 2 - (len2 % 2 == 0 ? 1 : 0);
            int y = x + (len2 % 2 == 0 ? 1 : 0);
            return ((double) nums2[x] + nums2[y]) / 2;
        }
        if (len2 == 0) {
            int x = len1 / 2 - (len1 % 2 == 0 ? 1 : 0);
            int y = x + (len1 % 2 == 0 ? 1 : 0);
            return ((double) nums1[x] + nums1[y]) / 2;
        }
        int sum = 0;
        int lenS = len1 + len2;
        int mid1 = lenS / 2 - (lenS % 2 == 0 ? 1 : 0);
        int mid2 = mid1 + (lenS % 2 == 0 ? 1 : 0);
        for (int idx1 = 0, idx2 = 0; idx1 + idx2 <= mid2; ) {
            if (idx1 + idx2 == mid1) {
                if (idx1 >= len1) {
                    sum += nums2[idx2];
                } else if (idx2 >= len2) {
                    sum += nums1[idx1];
                } else {
                    sum += Math.min(nums1[idx1], nums2[idx2]);
                }
            }
            if (idx1 + idx2 == mid2) {
                if (idx1 >= len1) {
                    sum += nums2[idx2];
                } else if (idx2 >= len2) {
                    sum += nums1[idx1];
                } else {
                    sum += Math.min(nums1[idx1], nums2[idx2]);
                }
            }
            if (idx1 >= len1) {
                idx2++;
                continue;
            }
            if (idx2 >= len2) {
                idx1++;
                continue;
            }
            if (nums1[idx1] > nums2[idx2]) {
                idx2++;
            } else {
                idx1++;
            }
        }
        return (double) sum / 2;
    }
}
