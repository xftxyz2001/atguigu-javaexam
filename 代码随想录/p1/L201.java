import java.util.ArrayList;

public class L201 {

    ArrayList<Integer> list = new ArrayList<>();
    int modeCount = 0;
    int count = 0;
    Integer preVal = null;

    public int[] findMode(TreeNode root) {

        findMode0(root);
        if (count > modeCount) {
            // modeCount = count;
            list.clear();
            list.add(preVal);
        } else if (count == modeCount) {
            list.add(preVal);
        }
        int[] result = new int[list.size()];
        int index = 0;
        for (Integer i : list) {
            result[index++] = i;
        }
        return result;
    }

    private void findMode0(TreeNode root) {
        if (root == null) {
            return;
        }
        findMode0(root.left);

        if (preVal == null || preVal.compareTo(root.val) == 0) {
            count++;
        } else {
            if (count > modeCount) {
                modeCount = count;
                list.clear();
                list.add(preVal);
            } else if (count == modeCount) {
                list.add(preVal);
            }
            count = 1;
        }
        preVal = root.val;

        findMode0(root.right);
    }
}
