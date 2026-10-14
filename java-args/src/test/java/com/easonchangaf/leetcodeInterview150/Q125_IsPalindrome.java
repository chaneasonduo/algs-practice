package com.easonchangaf.leetcodeInterview150;

import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

/**
 * https://leetcode.cn/problems/valid-palindrome/?envType=study-plan-v2&envId=top-interview-150
 *
 * 如果在将所有大写字符转换为小写字符、并移除所有非字母数字字符之后，短语正着读和反着读都一样。则可以认为该短语是一个 回文串 。
 *
 * 字母和数字都属于字母数字字符。
 *
 * 给你一个字符串 s，如果它是 回文串 ，返回 true ；否则，返回 false 。
 *
 *
 *
 * 示例 1：
 *
 * 输入: s = "A man, a plan, a canal: Panama"
 * 输出：true
 * 解释："amanaplanacanalpanama" 是回文串。
 *
 * 示例 2：
 *
 * 输入：s = "race a car"
 * 输出：false
 * 解释："raceacar" 不是回文串。
 *
 * 示例 3：
 *
 * 输入：s = " "
 * 输出：true
 * 解释：在移除非字母数字字符之后，s 是一个空字符串 "" 。
 * 由于空字符串正着反着读都一样，所以是回文串。
 *
 *
 *
 * 提示：
 *
 *     1 <= s.length <= 2 * 105
 *     s 仅由可打印的 ASCII 字符组成
 */
// TODO
public class Q125_IsPalindrome {

    String case1 = "A man, a plan, a canal: Panama";
    String case2 = "race a car";
    String case3 = " ";


    /**
     * 1. 去掉非字母的字符
     * 2. 比较回文串
     *
     * 直接翻转原字符串，比较新串和旧串是否一致
     *
     * 用到了一个数组，一个栈，空间复杂度o(n)
     * 遍历一次数组，时间复杂度o(n)
     * @param str
     * @return
     */
    public boolean solution_1(String str){
        if(str==null){
            return false;
        }
        if(str.equals(" ")){
            return true;
        }
        str = str.toLowerCase();
        char[] chars = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack();
        for(int i = chars.length -1 ; i>=0; i--){
            char c = chars[i];
            if(Character.isLetterOrDigit(c)){
                sb.append(c);
                stack.push(c);
            }
        }
        StringBuilder sbRev = new StringBuilder();
        while (!stack.isEmpty()){
            sbRev.append(stack.pop());
        }
        return sb.toString().equals(sbRev.toString());
    }


    /**
     * 双指针解法
     *
     * 一个指针从头开始，一个指针从尾巴开始，双向奔赴移动。如果一个时刻值不等，则为false
     */
    public boolean solution_2(String str){
        if(str==null){
            return false;
        }
        if(str.equals(" ")){
            return true;
        }
        char[] chars = str.toLowerCase().toCharArray();

        int left = 0;
        int right = chars.length - 1;
        while (true){
            if(left == right){
                break;
            }
            if(left > right){
                break;
            }

            while (true){
                if(Character.isLetterOrDigit(chars[left])){
                    break;
                }
                left++;
            }
            while (true){
                if(Character.isLetterOrDigit(chars[right])){
                    break;
                }
                right--;
            }

            if(chars[left]!=chars[right]){
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    @Test
    public void test_solution_1(){
        Q125_IsPalindrome obj = new Q125_IsPalindrome();
        boolean r1 = obj.solution_1(case1);
        Assert.assertEquals( true, r1);

        boolean r2 = obj.solution_1(case2);
        Assert.assertEquals(false, r2);

        boolean r3 = obj.solution_1(case3);
        Assert.assertEquals(true, r3);

    }

    @Test
    public void test_solution_2(){
        Q125_IsPalindrome obj = new Q125_IsPalindrome();
        boolean r1 = obj.solution_2(case1);
        Assert.assertEquals( true, r1);

        boolean r2 = obj.solution_2(case2);
        Assert.assertEquals(false, r2);

        boolean r3 = obj.solution_2(case3);
        Assert.assertEquals(true, r3);

    }




}
