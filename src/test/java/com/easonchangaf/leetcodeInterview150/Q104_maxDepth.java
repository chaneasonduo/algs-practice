package com.easonchangaf.leetcodeInterview150;

import static org.junit.Assert.assertEquals;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.jupiter.api.Test;

public class Q104_maxDepth {


    public TreeNode case1;

    public Q104_maxDepth(){
        case1 = create4LevelTree();
    }

    public class TreeNode {
           int val;
           TreeNode left;
           TreeNode right;
           TreeNode() {}
           TreeNode(int val) { this.val = val; }
            TreeNode(int val, TreeNode left, TreeNode right) {
                this.val = val;
                this.left = left;
                this.right = right;
            }
        }
    /**
     * 原创 dfs
     * @param root
     * @return
     */
    public int solution1_dfs(TreeNode root) {
        // 特殊处理
        if(root==null){
            return 0;
        }
        // 深度优先搜索
        int result = 0;
        result = dfs(root, result);
        return result;
    }


    private int dfs(TreeNode node, int height){
        if(node == null){
            return height;
        }
        height++;
        // 为什么最大值能一直传递到递归函数的最外层？
        int leftMaxHeight = dfs(node.left, height);
        int rightMaxHeight = dfs(node.right, height);
        
        return leftMaxHeight > rightMaxHeight ? leftMaxHeight : rightMaxHeight;


    }

    /**
     * leetcode官方
     * @param root
     * @return
     */
    public int solution2_dfs(TreeNode root){
        if(root == null){
            return 0;
        }
        int leftHight = solution2_dfs(root.left);
        int rightHight = solution2_dfs(root.right);
        int result = Math.max(leftHight, rightHight) + 1;
        return result;
    }

    //TODO 广度优先搜索
    public int solution3_bfs(TreeNode root){
        if(root == null){
            return 0;
        }
        int height = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            // 如何判断一层遍历完了？非常简单，得到一层的size，size>0表示一层还没遍历完
            int size = queue.size();
            while (size > 0) {
                TreeNode poll = queue.poll();
                if(poll.left!=null){
                    queue.offer(poll.left);
                }
                if(poll.right!=null){
                    queue.offer(poll.right);
                }
                size--;
            }
            height++;
        }
        
        return height;
    }

    /**
     * 构造4层二叉树
     * 结构如下：
     *       1
     *      / \
     *     2   3
     *    / \   \
     *   4   5   6
     *  / \   \   \
     * 7   8   9   10
     *  \     \
     *   11    12
     */
    public TreeNode create4LevelTree() {
        // 第4层节点
        TreeNode node11 = new TreeNode(11);
        TreeNode node12 = new TreeNode(12);
        
        // 第3层节点
        TreeNode node7 = new TreeNode(7, null, node11);
        TreeNode node8 = new TreeNode(8);
        TreeNode node9 = new TreeNode(9, null, node12);
        TreeNode node10 = new TreeNode(10);
        
        // 第2层节点
        TreeNode node4 = new TreeNode(4, node7, node8);
        TreeNode node5 = new TreeNode(5, null, node9);
        TreeNode node6 = new TreeNode(6, null, node10);
        
        // 第1层节点
        TreeNode node2 = new TreeNode(2, node4, node5);
        TreeNode node3 = new TreeNode(3, null, node6);
        
        // 根节点
        TreeNode root = new TreeNode(1, node2, node3);
        
        return root;
    }

        /**
     * 打印二叉树结构（用于可视化）
     */
    public void printTree(TreeNode root) {
        System.out.println("=== 二叉树结构 ===");
        printTreeHelper(root, "", true);
    }

    private void printTreeHelper(TreeNode node, String prefix, boolean isLeft) {
        if (node == null) {
            return;
        }
        
        System.out.println(prefix + (isLeft ? "└── " : "┌── ") + node.val);
        printTreeHelper(node.left, prefix + (isLeft ? "    " : "│   "), true);
        printTreeHelper(node.right, prefix + (isLeft ? "    " : "│   "), false);
    }

    //#region 测试

    @Test
    public void printTreeTest(){
        printTree(case1);
    }

    @Test
    public void maxDepthTest(){
        int maxDepth = solution1_dfs(case1);
        System.out.println(maxDepth);
        assertEquals(5, maxDepth);
    }

    @Test
    public void solution2_dfs_test(){
        int maxDepth = solution2_dfs(case1);
        System.out.println(maxDepth);
        assertEquals(5, maxDepth);
    }

    @Test
    public void solution3_bfs_test(){
        int maxDepth = solution3_bfs(case1);
        System.out.println(maxDepth);
        assertEquals(5, maxDepth);
    }
    //#endregion

}
