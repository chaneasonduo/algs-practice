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

    // 暴力递归
    public int solution0(int[] nums){

        int result = 0;
        for(int i=0; i< nums.length; i++){
            int num = nums[i];
            // search in array
            int len = searchInArray(nums, num, 0);
            // if found, len + 1
            if(len > result){
                result = len;
            }
            // if len > result, result = len
        }
        return result;
    }
    // 找到了返回下标，没找到返回-1
    private int searchInArray(int[] array, int target, int len){
        for(int i=0; i< array.length; i++){
            if(array[i] == target){
                len++;
                // 注意，此处要修改len的值，，不然len无法正确返回
                len = searchInArray(array, target+1, len);
                // 注意，此处一定要break，因为如果存在重复元素，如两个0，第一个递归玩计算len后，还会往后遍历，再次计算
                break;
            }
        }
        return len;
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
        int r = 0;
        System.out.println("======= case 1 =======");
        r = alg.solution0(nums1);
        System.out.println(r);
        r = alg.solution1(nums1);
        System.out.println(r);


        System.out.println("======= case 2 =======");
        int[] nums2 = new int[]{0,3,7,2,5,8,4,6,0,1};
        r = alg.solution0(nums2);
        System.out.println(r);
        r = alg.solution1(nums2);
        System.out.println(r);

        System.out.println("======= case 3 =======");
        int[] nums3 = new int[]{1,3,2,0,4,0};
        r = alg.solution0(nums3);
        System.out.println(r);
        r = alg.solution1(nums3);
        System.out.println(r);
    }
}
