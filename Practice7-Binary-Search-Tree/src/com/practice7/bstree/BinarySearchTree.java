package com.practice7.bstree;

public class BinarySearchTree {
  
  class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;
    // TreeNode parent;
    //  We can store parent reference as well, this will be useful for solving some problems.
    public TreeNode(int data) {
      this.data = data;
    }
  }
  
  // is tail recursion
  // return the node found
  public TreeNode searchRecursively(TreeNode root, int target) {
    if (root == null) {
      return null;
    }
    if (root.data == target) {
      return root;
    }
    //      if  root == null && root.data == target,   return root ,      is also correct
    if (target < root.data) {
      return searchRecursively(root.left, target);
    } else {
      return searchRecursively(root.right, target);
    }
  }
  
  public TreeNode searchIteratively(TreeNode root, int target) {
    while (root != null && root.data != target) {  //be careful that root can be null
      if (target < root.data) {
        root = root.left;
      } else {
        root = root.right;
      }
    }
    return root;
  }
  
  //return the new root (there will be a new tree if(and only if) original root == null)
  // not tail recursion... see next insertRecursivelyA() which uses helper() to make it a tail recursion
  public TreeNode insertRecursively(TreeNode root, int value) {
    if (root == null) {
      return new TreeNode(value);
    }
    if (value == root.data) {
      //return root;
    } else if (value < root.data) {
      if (root.left == null) {
        root.left = new TreeNode(value);
        //return root;
      } else {
        insertRecursively(root.left, value);
      }
    } else {
      if (root.right == null) {
        root.right = new TreeNode(value);
        //return root;
      } else {
        insertRecursively(root.right, value);
      }
    }
    return root;
  }
  
  //  tail recursion!  (with helper())
  public TreeNode insertRecursivelyA(TreeNode root, int value) {
    if (root == null) {
      return new TreeNode(value);
    }
    helper(root, value);
    return root;
    
  }
  //attention: return value void
  public void helper(TreeNode root, int value) {  
    if (value == root.data) {
      return;
    } else if (value < root.data) {
      if (root.left == null) {
        root.left = new TreeNode(value);
        //not return root;,   so it's tail recursion!
      } else {
        insertRecursively(root.left, value);
      }
    } else {
      if (root.right == null) {
        root.right = new TreeNode(value);
      } else {
        insertRecursively(root.right, value);
      }
    }
  }
  
  // change the tail recursion of insertRecursivelyA()  to iteration
  public TreeNode insertIterativelyA(TreeNode root, int value) {
    if (root == null) {
      return new TreeNode(value);
    }
    TreeNode current = root;   // not change original root, because original root will be the return value
    // below is changed
    while (value != current.data) {   // the base case is the loop condition
      if (value < current.data) {
        if (current.left == null) {
          current.left = new TreeNode(value);
          break;          // should add "break" here, because it's not recursion
        } else {
          current = current.left;       // recursion rule
        }
      } else {
        if (current.right == null) {
          current.right = new TreeNode(value);
          break;
        } else {
          current = current.right;
        }
      }
    }
    return root;
  }
   
  // another iterative method, maintain a upper node reference,   look upward
  public TreeNode insertIterativelyB(TreeNode root, int value) {
    if (root == null) {
      return new TreeNode(value);
    }
    TreeNode upper = root;
    TreeNode current = root;
    while (current.data != value) {
      if(value < current.data) {
        current = current.left;
      } else {
        current = current.right;
      }
      if (current == null) {
        if (value < upper.data) {
          upper.left = new TreeNode(value);
          break;
        } else {
          upper.right = new TreeNode(value);
          break;
        }
      } else {
        upper = current;
      }
    }
    return root;
  }
  
  // a naive recursive method,   but has some redundant operations
  public TreeNode insertRecursivelyB(TreeNode root, int value)  {
    //A very common way when the tree structure could be changed, in this case, 
    //we return the new root after the change(remind about the same case of Linked List?).
    if (root == null) { //base case
      return new TreeNode(value);
    }
    if (value < root.data) {
      root.left = insertRecursivelyB(root.left, value);
    } else if (value > root.data) {
      root.right = insertRecursivelyB(root.right, value);
    }
    return root;    
  }
  
}
