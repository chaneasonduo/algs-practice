package com.easonchangaf.leetcodeInterview150;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class AddTwoNumbers {

    ListNode case1L1;
    ListNode case1L2;

    ListNode case2L1;
    ListNode case2L2;


    public AddTwoNumbers(){
        case1L1 = buildListNode(2, 4, 3);
        case1L2 = buildListNode(5, 6, 4);

        case2L1 = buildListNode(0);
        case2L2 = buildListNode(0);
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // todo 特殊处理
        // 进位
        int carry = 0;
        // 虚拟头节点
        ListNode dummy = new ListNode(0, null);
        ListNode current = dummy;
        while (l1!=null || l2!=null){
            int val1 = 0;
            int val2 = 0;
            int sum = 0;
            int newVal = 0;
            if(l1!=null){
                val1 = l1.val;
                l1=l1.next;
            }
            if(l2!=null){
                val2 = l2.val;
                l2 = l2.next;
            }
            sum = val1 + val2 +carry;
            newVal = sum % 10;
            carry = sum / 10;

            ListNode node = new ListNode(newVal);
            current.next = node;
            current = current.next;


            if(l1==null && l2 == null && carry > 0){
                current.next = new ListNode(carry);
            }
        }
        return dummy.next;
    }

    @Test
    public void solution1_test() {
        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        ListNode result = addTwoNumbers.addTwoNumbers(case1L1, case1L2);
        // 预期结果链表（示例值，需根据实际测试用例修改）
        ListNode expected = buildListNode(7, 0, 8); // 假设预期结果是7->0->8
        int length = 3;
        int count = 0;
        // 遍历链表比较每个节点值
        while (expected != null && result != null) {
            count++;
            System.out.println("i");
            assertEquals(expected.val, result.val);
            expected = expected.next;
            result = result.next;
        }
        assertEquals(length, count);
        // 确保两个链表都遍历完毕，长度一致
        assertNull(expected);
        assertNull(result);
    }

    public ListNode buildListNode(int... i) {
        if (i == null || i.length == 0) {
            return null;
        }

        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        for (int num : i) {
            current.next = new ListNode(num);
            current = current.next;
        }

        return dummy.next;
    }
}