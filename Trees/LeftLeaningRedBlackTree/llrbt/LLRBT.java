package llrbt;

public class LLRBT{

    private Node root;
    private final boolean RED = true;
	private final boolean BLACK = false;
    public void insert(int val)
    {
        root=insert(root,val);
        root.color=BLACK;
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

        if(getColor(root.left)!=RED&& getColor(root.right)==RED)
            root=leftRotate(root);
        if(getColor(root.left)==RED&& getColor(root.left.left)==RED)
            root=rightRotate(root);
        if(getColor(root.left)==RED&& getColor(root.right)==RED)
            flipColor(root);
        return root;
    }

    private boolean getColor(Node root){
        return root==null?BLACK:root.color;
    }
    private void flipColor(Node root){
        root.color=RED;
        root.left.color=BLACK;
        root.right.color=BLACK;
    }
    private Node leftRotate(Node root){
        Node temp=root;
        root=root.right;
        Node temp2=root.left;
        root.left=temp;
        temp.right=temp2;
        swapColor(root,temp);
        return root;
        /*Node t = n.right;
		n.right = t.left;
		t.left = n;
		t.color = n.color;
		n.color = RED;
		return t;*/

    }
    private Node rightRotate(Node n){
        /*Node temp=root;
        root=root.left;
        Node temp2=root.right;
        root.right=temp;
        temp.left=temp2;
        swapColor(root,temp);*/
        Node t = n.left;
		n.left = t.right;
		t.right = n;
		t.color = n.color;
		n.color = RED;
		return t;
        
    }
    private void swapColor(Node a,Node b)
    {
        boolean temp=a.color;
        a.color=b.color;
        b.color=temp;
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
        private boolean color;
        Node(int val)
        {
            this.data=val;
            this.color=RED;
        }
    }
}