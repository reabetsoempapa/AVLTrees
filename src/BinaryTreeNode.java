// Hussein's Binary Tree
// 26 March 2017
// Hussein Suleman

/**
* BinaryTreeNode object with attributes 
* 
* @author Rea
* @version 1.0 23/03/2022
*/

public class BinaryTreeNode<dataType>
{
   dataType data;
   BinaryTreeNode<dataType> left;
   BinaryTreeNode<dataType> right;
   int height;
    
   /**
   * BinaryTreeNode
   *
   * @param d
   * @param l
   * @param r
   */ 
   
   public BinaryTreeNode ( dataType d, BinaryTreeNode<dataType> l, BinaryTreeNode<dataType> r )
   {
      data = d;
      left = l;
      right = r;
      height = 0;
   }
   
   /**
   *
   * @return right node
   * @return left node 
   */
     
   BinaryTreeNode<dataType> getLeft () { return left; }
   BinaryTreeNode<dataType> getRight () { return right; }
}
