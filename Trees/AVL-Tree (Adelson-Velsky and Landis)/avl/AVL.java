package avl;
import java.util.*;

public class AVL{
	private Node root;
	public void insert(int val){
		root=insert(root,val);
	}
	private Node insert(Node root,int val){
		if(root==null){
			return new Node(val);
		}
		if(val<root.data){
			root.left=insert(root.left,val);
		}
		else if(val>root.data){
			root.right=insert(root.right,val);
		}
		else
			return root;

		root.height=1+Math.max(height(root.left),height(root.right));

		int diff=getDiff(root);

		
		if(diff>1&&val<root.left.data)
			return rightRotate(root);
		if(diff<-1&&val>root.right.data)
			return leftRotate(root);
		if(diff>1&&val>root.left.data){
			root.left=leftRotate(root.left);
			return rightRotate(root);
		}
		if(diff<-1&&val<root.right.data){
			root.right=rightRotate(root.right);
			return leftRotate(root);
		}

		return root;
		
	}
	public int height(){
		return height(root);
	}
	private int height(Node root){
		if(root==null)
			return 0;
		return root.height;
	}
	
	private int getDiff(Node root){
		if(root==null)
			return 0;
			return height(root.left)-height(root.right);
	}

	private Node leftRotate(Node root){
		if(root.right==null)
			return root;
		Node newR=root.right;
		Node temp;
		//if(newR!=null){
			temp=newR.left;
			newR.left=root;
		////}
		//else
		//	temp=null;
		
		root.right=temp;
		root.height=1+Math.max(height(root.left),height(root.right));
		//if(newR!=null)
		newR.height=1+Math.max(height(root.left),height(root.right));
		return newR;
	}
	private Node rightRotate(Node root){
		if(root.left==null)
			return root;
		Node newR=root.left;
		Node temp;
		//if(newR!=null){
			temp=newR.right;
			newR.right=root;
		//}
		//else
		//	temp=null;
		
		root.left=temp;
		root.height=1+Math.max(height(root.left),height(root.right));
		//if(newR!=null)
		newR.height=1+Math.max(height(root.left),height(root.right));
		return newR;
	}
	public void printInorder()
    {
    	//System.out.println(" "+root.data);
    	int count=0;
        count=printInorder(root,count);
        System.out.println();
        System.out.println("Total elements "+count);
    }
    private int printInorder(Node root,int count)
    {
        if(root==null){
            return 0;
        }
        count=1;
        count+=printInorder(root.left,count);
        //System.out.print(root.data+" ");
        count+=printInorder(root.right,count);
        return count;
    }
	private class Node{
		int data;
		Node left;
		Node right;
		int height;
		Node(int d)
		{
			this.data=d;
			this.height=1;
		}
	}
}