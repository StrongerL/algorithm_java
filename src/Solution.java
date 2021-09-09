//给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。 
//
// 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。 
//
// 
//
// 示例 1: 
//
// 
//输入: [3,2,1,5,6,4] 和 k = 2
//输出: 5
// 
//
// 示例 2: 
//
// 
//输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
//输出: 4 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= nums.length <= 104 
// -104 <= nums[i] <= 104 
// 
// Related Topics 数组 分治 快速选择 排序 堆（优先队列） 
// 👍 1235 👎 0

//leetcode submit region begin(Prohibit modification and deletion)


class TreeNode {
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

public class Solution {

    int ans = 0;
    int targetSum;

    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        this.targetSum = targetSum;
        dfs(root, 0);
        return ans;
    }

    private void dfs(TreeNode node, int sum) {
        if (node == null) {
            return;
        }
        if (sum + node.val == targetSum) {
            ans++;
        }
        dfs(node.left, sum + node.val);
        dfs(node.right, sum + node.val);
        dfs(node.left, 0);
        dfs(node.right, 0);
    }


    public static void main(String[] args) {

        Solution s = new Solution();

        TreeNode t5 = new TreeNode(5);
        TreeNode t4 = new TreeNode(4, null, t5);
        TreeNode t3 = new TreeNode(3, null, t4);
        TreeNode t2 = new TreeNode(2, null, t3);
        TreeNode t1 = new TreeNode(1, null, t2);

        System.out.println(s.pathSum(t1, 3));

    }

}

