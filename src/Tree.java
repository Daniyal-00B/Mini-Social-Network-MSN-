public class Tree {

    public TreeNode root;

    public void add(User newData) {
        TreeNode newPtr = new TreeNode(), prePtr = new TreeNode();
        TreeNode ptr = root;
        String name = newData.getFullName();
        newPtr.data = newData;

        if (root==null) {
            root = newPtr;
            return;
        }

        while (ptr!=null) {
            prePtr = ptr;
            if (name.compareToIgnoreCase(ptr.data.getFullName()) < 0) ptr = ptr.left;
            else ptr = ptr.right;
        }
        if (name.compareToIgnoreCase(prePtr.data.getFullName()) < 0) prePtr.left = newPtr;
        else prePtr.right = newPtr;
    }

    public String search(TreeNode root, String name) {
        TreeNode ptr = root;
        if (ptr==null) {
            return null;
        }
        if (ptr.data.getFullName().equalsIgnoreCase(name)) {
            return ("\n✅ User Found" + "\nName: " + ptr.data.getFullName() + "\nID: " + ptr.data.getID());
        }
        if (name.compareToIgnoreCase(ptr.data.getFullName()) < 0) return search(ptr.left, name);
        else return search(ptr.right, name);
    }

    //Inorder Traversal of BST
    public void sort(TreeNode node) {
        if (node!=null) {
            sort(node.left);
            System.out.println(node.data.getFullName());
            sort(node.right);
        }
    }
}
