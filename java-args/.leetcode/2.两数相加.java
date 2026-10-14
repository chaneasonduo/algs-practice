/*
 * @lc app=leetcode.cn id=2 lang=java
 *
 * [2] 两数相加
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // todo 特殊处理

        int add = 0;
        ListNode headNode = null;
        ListNode newNode = null;
        do{
            int val1 = 0;
            int val2 = 0;
            // 新的值
            int newVal = 0;
            // 进位的值
            int sum = 0;
            if(l1!=null){
                val1 = l1.val;
            }
            if(l2!=null){
                val2 = l2.val;
            }
            sum = val1 + val2 + add;
            if(sum>=10){
                newVal = sum / 10;
                add = sum % 10;
            }
            // 组装节点
            if(newNode==null){
                newNode =new ListNode(newVal, null);
                headNode = newNode;
            }else{
                newNode.next = new ListNode(newVal, null);
                newNode = newNode.next;
            }
        }while(l1.next!=null || l2.next!=null);

        return headNode;
    }
}
// @lc code=end

