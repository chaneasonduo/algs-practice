package com.easonchangaf.leetcodeHot100;
import static org.junit.Assert.assertEquals;

import java.util.Deque;
import java.util.LinkedList;

import org.junit.Test;

public class Good {
    public boolean isValid(String s) {
        char[] chars = s.toCharArray();
        Deque<Character> stack = new LinkedList<>();
        for(char c : chars){
            if(!isRight(c)){
                stack.push(c);
                continue;
            }
            char right = c;
            if(stack.isEmpty()){
                return false;
            }
            char left = stack.pop();
            switch(right){
                case ')':
                    if(left!='(') return false;
                    break;
                case '}':
                    if(left!='{') return false;
                    break;
                case ']':
                    if(left!='[') return false;
                    break;
                default:
                    return false;
            }
        }
        return true;
    }

    public boolean isRight(char c){
        if(c == ')' || c == ']' || c == '}'){
            return true;
        }
        return false;
    }

    @Test
    public void test2(){
        String s = "()";
        Good good = new Good();
        boolean valid = good.isValid(s);
        assertEquals(valid, true);
    }
}
