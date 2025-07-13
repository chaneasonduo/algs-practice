package com.easonchangaf.leetcodeHot100;

import org.junit.Test;

import com.easonchangaf.leetcodeHot100.Q108_sortedArrayToB.TreeNode;

public class Q108_sortedArrayToB {

    private int[] case1 = {0, 1, 2, 3, 4, 5, 6};

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public TreeNode sortedArrayToBST(int[] nums) {

        // TODO特殊处理
        TreeNode rootNode = dfs(nums, 0, nums.length - 1);
        // begin
        return rootNode;

    }

    public TreeNode dfs(int[] nums, int leftIndex, int rightIndex) {
        // 递归结束条件
        // why 为什么是大于
        if (leftIndex > rightIndex) {
            return null;
        }
        // 取中间的保持平衡
        // why 为什么取中间？
        int middleIndex = leftIndex + (rightIndex - leftIndex) / 2;

        TreeNode node = new TreeNode(nums[middleIndex]);
        node.left = dfs(nums, leftIndex, middleIndex - 1);
        node.right = dfs(nums, middleIndex + 1, rightIndex);
        return node;

    }

    @Test
    public void solution1_test(){
        TreeNode root = sortedArrayToBST(case1);
        System.out.println(root);
    }

}