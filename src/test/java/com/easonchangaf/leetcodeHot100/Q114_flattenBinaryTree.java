package com.easonchangaf.leetcodeHot100;

import com.easonchangaf.leetcodeHot100.common.TreeNode;
import org.junit.Test;

public class Q114_flattenBinaryTree {

    TreeNode case1;

    public Q114_flattenBinaryTree(){
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node6 = new TreeNode(6);

        TreeNode node2 = new TreeNode(2, node3, node4);
        TreeNode node5 = new TreeNode(3, null, node6);

        TreeNode node1 = new TreeNode(1, node2, node5);

        case1 = node1;
    }

    /**
     * 答案
     */
    public void flatten(TreeNode root) {
        TreeNode curr = root;
        while (curr != null) {
            if (curr.left != null) {
                TreeNode next = curr.left;
                TreeNode predecessor = next;
                while (predecessor.right != null) {
                    predecessor = predecessor.right;
                }
                predecessor.right = curr.right;
                curr.left = null;
                curr.right = next;
            }
            curr = curr.right;
        }
    }

    /**
     * 1. 数的节点本身按照前序遍历的顺序，排列了大小
     * 2. 以当前节点为参考点，将其左子树的最右侧叶子节点的右节点指向当前节点的右节点
     * 
     * 实质：寻找当前节点右节点的前驱节点
     */
    public void myFlatten(TreeNode root){
        TreeNode curr = root;
        while (curr!=null) {
            if(curr.left!=null){
                TreeNode next = curr.left;
                TreeNode predecessor = next;
                while(predecessor.right!=null){
                    predecessor = predecessor.right;
                }
                // 开始移动树
                curr.left = null;
                predecessor.right = curr.right;
                curr.right = next;
            }
            curr = curr.right;
        }
    }

    @Test
    public void test1(){
        Q114_flattenBinaryTree instance = new Q114_flattenBinaryTree();
        instance.flatten(case1);
    }

    @Test
    public void test2(){
        Q114_flattenBinaryTree instance = new Q114_flattenBinaryTree();
        instance.myFlatten(case1);
        TreeNode result = case1;
        TreeNode dummy = new TreeNode(0);
        dummy.right = result;

        TreeNode node = dummy;
        while(node.right!=null){
            node = node.right;
            System.out.println(node.val+ " ");
        }

    }
}
