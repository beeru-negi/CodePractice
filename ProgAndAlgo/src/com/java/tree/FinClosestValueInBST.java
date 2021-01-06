package src.com.java.tree;

/** Find Closest value in BST tree for a given target value. IE: if a a integer target is given than we have to find which node in tree is 
  closest to this given target integer**/
public class FinClosestValueInBST {
	public static int findClosestValueInBst(BST tree, int target) {
	    // Write your code here.
			
			if(tree == null)
			{
				return -1;
			}
			
			if( tree.left ==  null && tree.right == null)
			{
				return tree.value;
			}
			
	   return findValue(tree, target, 0, -1);
	  }
		
		public static int findValue( BST tree, int target, int mdiff, int cval)
		{
			int diff =0;
			if(tree == null)
			{
				return cval;
			}
			if(tree.value == target)
			{
				return tree.value;
			}
			diff = Math.abs(tree.value - target);
			if(mdiff ==0 || mdiff > diff)
			{
					mdiff = diff;
					cval = tree.value;
			}
			if( target < tree.value)
			{
				return findValue( tree.left, target, mdiff, cval);
			} else {			
				return findValue( tree.right, target, mdiff, cval);
			}
		}

	  static class BST {
	    public int value;
	    public BST left;
	    public BST right;

	    public BST(int value) {
	      this.value = value;
	    }
	  }

}
