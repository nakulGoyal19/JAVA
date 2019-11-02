package bst;

public class BST{

    private Node root;

    public void insert(int val)
    {
        root=insert(root,val);
    }

    private Node insert(Node root,int val)
    {
        if(root==null)
        {
            return new Node(val);
        }
        else if(val<root.data)
        {
            root.left=insert(root.left,val);
        }
        else if(val>root.data)
        {
            root.right=insert(root.right,val);
        }
        return root;
    }

    public int height(){
        return root==null?0:height(root);
    }
    
    private int height(Node root){
        if(root==null)
            return 0;
        return 1 + Math.max(height(root.left),height(root.right));
    }

    private class Node{
        private int data;
        private Node left;
        private Node right;
        Node(int val)
        {
            this.data=val;

        }
    }
}