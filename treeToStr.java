public class treeToStr {
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x){
            val=x;
        }
    }
    public static String ans(TreeNode root){
        StringBuilder sb=new StringBuilder();
        dfs(root,sb);
        return sb.toString();
    }
    public static void dfs(TreeNode t,StringBuilder res){
        if(t==null){
            return;
        }
        
        res.append(String.valueOf(t.val));

        if(t.left==null && t.right==null){
            return;
        }

        res.append('(');
        dfs(t.left,res);
        res.append(')');

        if(t.right!=null){
            res.append('(');
            dfs(t.right,res);
            res.append(')');
        }
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(3);
        root.left.left=new TreeNode(4);
        

        treeToStr tree=new treeToStr();
        String res=treeToStr.ans(root);

        System.out.println(res);



    }
}
