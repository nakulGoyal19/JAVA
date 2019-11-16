import bst.*;
import avl.*;
import java.util.*;
import java.lang.*;
class Test{
    public static void main(String args[])
    {
        AVL avl = new AVL();
		BST bst = new BST();
		int range=1024-1+1;
		System.out.println("testing with random input");
		Random r = new Random();
		for (int i = 1024; i > 0; i--) {
			int key = r.nextInt();
			//System.out.println(key+" "+bst.height());
			bst.insert(key);
		    avl.insert(key);
		    //avl.printInorder();
		}
		System.out.println("height of BST is : "+bst.height());
		System.out.println("height of avl is : "+avl.height());
		//bst.printInorder();
		avl.printInorder();

		/*System.out.println("testing with sorted input");
		avl = new AVL();
		bst = new BST();
		for (int i = 10000; i > 0; i--) {
			
			bst.insert(i);
		    avl.insert(i);
		}
		System.out.println("height of BST is : "+bst.height());
		System.out.println("height of AVL is : "+avl.height());
		//bst.printInorder();
		//avl.printInorder();*/
    }
}