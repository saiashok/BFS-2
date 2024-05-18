// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes. i was not able to frame the problem nicely.

/*
 * Problem#993
 * 
 * Cousins: are children at same level but not belonging to the same parent.
 * Using BFS go at each level-> for each element check if they have the same parent if yes they are not cousins.
 * If no add all elements to a HashSet and if we have both x & y at the same level they are cousins. 
 * 
 */

import java.util.*;

public class CousinsInBinaryTree {

    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null)
            return false;
        int level = 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int numOfElmenetsInLevel = queue.size();
            Set<Integer> elementsInSameLevel = new HashSet<>();
            for (int i = 0; i < numOfElmenetsInLevel; i++) {
                TreeNode currNode = queue.poll();
                elementsInSameLevel.add(currNode.val);
                if (currNode.left != null & currNode.right != null) { // silbilings not cousins same parent node
                                                                      // (currentNode)
                    if (currNode.left.val == x && currNode.right.val == y)
                        return false;
                    if (currNode.left.val == y && currNode.right.val == x)
                        return false;
                }
                if (currNode.left != null)
                    queue.add(currNode.left);
                if (currNode.right != null)
                    queue.add(currNode.right);
            }

            if (elementsInSameLevel.contains(x) && elementsInSameLevel.contains(y))
                return true;
            if (elementsInSameLevel.contains(x) || elementsInSameLevel.contains(y))
                return false;

            level++;

        }

        return false;
    }
}
