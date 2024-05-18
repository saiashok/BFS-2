// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*
Problem:199
 * Find the level & if the size of the result array is same as the level add element and most importantly do right & then left
 */

import java.util.*;

public class RightSideView {

    // BFS
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null)
            return result;
        queue.add(root);
        int level = 0;

        while (!queue.isEmpty()) {
            // get the size of the queue; which gives the number of elements in that level
            int numberOfNodesAtALevel = queue.size();
            for (int i = 0; i < numberOfNodesAtALevel; i++) {
                TreeNode currNode = queue.poll();
                if (result.size() == level) {
                    result.add(currNode.val);
                }
                if (currNode.right != null)
                    queue.add(currNode.right);
                if (currNode.left != null)
                    queue.add(currNode.left);
            }
            level++;

        }

        return result;
    }

    List<Integer> results = new ArrayList<>();

    // DFS - Recursion
    public List<Integer> rightSideView_dfs(TreeNode root) {
        dfs(root, 0);
        return results;
    }

    private void dfs(TreeNode root, int level) {
        if (root == null)
            return;
        if (level == results.size()) {
            results.add(root.val);
        }

        dfs(root.right, level + 1);
        dfs(root.left, level + 1);
    }
}
