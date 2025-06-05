package com.easonchangaf.leetcodeHot100;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 *
 * 示例 1：
 *
 * 输入：nums = [100,4,200,1,3,2]
 * 输出：4
 * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
 *
 * 示例 2：
 *
 * 输入：nums = [0,3,7,2,5,8,4,6,0,1]
 * 输出：9
 *
 * 提示：
 *
 *     0 <= nums.length <= 104
 *     -109 <= nums[i] <= 109
 *
 * 进阶：可以设计并实现时间复杂度为 O(n) 的解决方案吗？
 * 注意：本题与主站 128 题相同： https://leetcode-cn.com/problems/longest-consecutive-sequence/
 */
public class LCR119_LongestConsecutive {

    // 暴力解法
    public int solution0(int[] nums){

        int result = 0;
        for(int i=0; i< nums.length; i++){
            int num = nums[i];
            int nextNum = num + 1;

            // search in array
            for(int j =0; j<nums.length; j++){
                if(nextNum==nums[j]){

                }
            }
            // if found, len + 1

            // if len > result, result = len


        }

        return result;
    }

    public int solution1(int[] nums){
        Set<Integer> num_set = new HashSet<Integer>();
        for (int num : nums) {
            num_set.add(num);
        }

        int longestStreak = 0;

        for (int num : num_set) {
            if (!num_set.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                while (num_set.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }

    // 排序解法
    public int solution2(int[] nums){
        return 0;
    }

    public static void main(String[] args) {

        LCR119_LongestConsecutive alg = new LCR119_LongestConsecutive();
        int[] nums1 = new int[] {100,4,200,1,3,2};
        int r1 = alg.solution1(nums1);

        int[] nums2 = new int[]{0,3,7,2,5,8,4,6,0,1};
        int r2 = alg.solution2(nums2);

        System.out.println(r1);
        System.out.println(r2);
    }
}
