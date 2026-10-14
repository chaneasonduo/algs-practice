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

    /**
     * 递归中存在重复计算，比如，[0,3,5,2,1,4]这个序列。
     *  1. 当遍历到第一个元素，0时，计算了2, 3, 4, 5 是否存在与列表中，
     *  2. 当遍历到第二个元素，3时，还需要计算，4，5是不是存在，而第1步已经计算过了，是存在的。
     *  3. 所以，可以将存在的结果缓存在一个set中，避免重复遍历数组进行判断，减少计算。
     */
    public int solution1(int[] nums){
        Set<Integer> set = new HashSet<>();
        for(int num: nums){
            set.add(num);
        }

        int result = 0;
        for(int item: set){
            int len = 0;
            len = searchInArrayWithSet(item, len, set);

            if(len > result){
                result = len;
            }
        }

        return result;
    }

    private int searchInArrayWithSet(int target, int len, Set<Integer> set){
        if(set.contains(target)){
            len++;
            len = searchInArrayWithSet(target + 1, len, set);
        }
        return len;
    }

    /**
     * leetcode 答案
     */
    public int solutionLeetCode(int[] nums){
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

    /**
     * 学习 leetcode 的思维
     */
    public int solutionMyLeetCode(int[] nums){
        Set<Integer> set = new HashSet<Integer>();
        for(int num : nums){
            set.add(num);
        }

        int result = 0;

        for(int item: set){
            // 有比自己还小的值存在，一定不是最长
            if(set.contains(item - 1)){
                continue;
            }

            int currentNum = item;
            // 初始值应该为1
            int len = 1;
            while (set.contains(currentNum + 1)){
                len++;
                currentNum++;
            }

            if( len > result){
                result = len;
            }
        }

        return result;
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
        r = alg.solutionLeetCode(nums1);
        System.out.println(r);
        r = alg.solutionMyLeetCode(nums1);
        System.out.println(r);


        System.out.println("======= case 2 =======");
        int[] nums2 = new int[]{0,3,7,2,5,8,4,6,0,1};
        r = alg.solution0(nums2);
        System.out.println(r);
        r = alg.solution1(nums2);
        System.out.println(r);
        r = alg.solutionLeetCode(nums2);
        System.out.println(r);
        r = alg.solutionMyLeetCode(nums2);
        System.out.println(r);

        System.out.println("======= case 3 =======");
        int[] nums3 = new int[]{1,3,2,0,4,0};
        r = alg.solution0(nums3);
        System.out.println(r);
        r = alg.solution1(nums3);
        System.out.println(r);
        r = alg.solutionLeetCode(nums3);
        System.out.println(r);
        r = alg.solutionMyLeetCode(nums3);
        System.out.println(r);
    }
}
