package com.easonchangaf.leetcodeHot100;

import org.junit.Assert;
import org.junit.Test;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * 求不重复的最长子串长度
 *  1. 元素无序，要用到constain来判断
 */
public class LongestSubString {

    // 野路子双指针
    public static Integer solution1(String str){
        // 特殊情况
        if(null == str){
            return 0;
        }
        if(str.isEmpty()){
            return 0;
        }
        if(str.length() == 1){
            return 1;
        }
        char[] chars = str.toCharArray();
        Deque deque = new LinkedList();

        int p1 = 0;
        int p2 = 1;
        int len = chars.length;

        deque.add(chars[p1]);
        while(p2 < len){
            char left = chars[p1];
            char right = chars[p2];
            if(!deque.contains(right)){
                deque.add(chars[p2]);
                p2++;
            }else {
                deque.pollFirst();
                p1++;
                deque.add(chars[p2]);
                p2++;
            }
        }
        return deque.size();
    }

    // 不错实践双指针滑动窗口
    public static Integer solution2(String str){
        // 特殊情况
        if(null == str){
            return 0;
        }
        if(str.isEmpty()){
            return 0;
        }
        if(str.length() == 1){
            return 1;
        }

        char[] chars = str.toCharArray();
        Set<Character> set = new HashSet<>();
        int res = 0;
        int len = chars.length;
        for(int l = 0, r = 0; r < len; r++){
            char ch = chars[r];
            // 有重复的就移动左指针，否则就移动右指针
            while(l <= r && set.contains(ch)){
                set.remove(ch);
                l++;
            }
            set.add(ch);
        }


        return set.size();
    }

    private static boolean check(Set set, char ch){
        return set.contains(ch);
    }


    @Test
    public void case1(){
        String s = "abcae";
        Integer integer = solution1(s);
        System.out.println(integer);
        Assert.assertTrue(integer == 4);

        integer = solution2(s);
        System.out.println(integer);
        Assert.assertTrue(integer == 4);
    }

    @Test
    public void case2(){
        String s = "ab";
        Integer integer = solution1(s);
        System.out.println(integer);
        Assert.assertTrue(integer == 2);

        integer = solution2(s);
        System.out.println(integer);
        Assert.assertTrue(integer == 2);
    }

    @Test
    public void case3(){
        String s = "aa";
        Integer integer = solution1(s);
        System.out.println(integer);
        Assert.assertTrue(integer == 1);

        integer = solution2(s);
        System.out.println(integer);
        Assert.assertTrue(integer == 1);
    }

    @Test
    public void case4(){
        String s = "a";
        Integer integer = solution1(s);
        System.out.println(integer);
        Assert.assertTrue(integer == 1);

        integer = solution2(s);
        System.out.println(integer);
        Assert.assertTrue(integer == 1);
    }

    @Test
    public void case5(){
        String s = "abcdeabcaa";
        Integer integer = solution1(s);
        System.out.println(integer);
        Assert.assertTrue(integer == 5);

        integer = solution2(s);
        System.out.println(integer);
        Assert.assertTrue(integer == 5);
    }


}
