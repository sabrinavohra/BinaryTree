import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * An Integer Binary Search Tree
 * @author: Your Name Here
 * @version: Date
 */

public class BST {
    private BSTNode root;

    public BSTNode getRoot() {
        return this.root;
    }

    public void setRoot(BSTNode root) {
        this.root = root;
    }

    /**
     * Sets up a binary search tree
     * with some default values
     */
    public void setupTestData() {
        this.root = new BSTNode(10);
        this.root.setLeft(new BSTNode(5));
        this.root.setRight(new BSTNode((15)));
        this.root.getLeft().setLeft(new BSTNode(3));
        this.root.getLeft().setRight(new BSTNode(9));
    }

    /**
     * Prints the provided ArrayList of nodes
     * in the form node1-node2-node3
     * @param nodes ArrayList of BSTNodes
     */
    public static void printNodes(ArrayList<BSTNode> nodes) {
        for(int i=0; i<nodes.size()-1; i++) {
            System.out.print(nodes.get(i) + "-");
        }
        System.out.println(nodes.get(nodes.size()-1));
    }

    /**
     * A function that searches for a value in the tree
     * @param val integer value to search for
     * @return true if val is in the tree, false otherwise
     */
    public boolean search(int val) {
        // TODO: Complete the search function
        // Calls recursive method starting at the root and searching for the given value
        if(searchNode(val, root)) {
            return true;
        }
        // Returns depending on recursive method
        return false;
    }

    // Recursive method to search for a certain node
    public boolean searchNode(int val, BSTNode currentNode) {
        // Base case
        // Returns if the value hasn't been found
        if(currentNode == null) {
            return false;
        }
        // Will return true if the current node being searched is equal to the value being looked for
        if (currentNode.getVal() == val) {
            return true;
        }
        // Looks to the left of the current node being searched if the value is less than the value of the current node
        if(val < currentNode.getVal()) {
            // Calls method again but on the node to the left of the current node being searched
            return searchNode(val, currentNode.getLeft());
        }
        // Looks to the right of the current node being searched if the value is greater than the value of the current node
        if(val > currentNode.getVal()) {
            // Calls method again but on the node to the right of the current node being searched
            return searchNode(val, currentNode.getRight());
        }
        // Returns false if end of method is reached
        return false;
    }

    /**
     * @return ArrayList of BSTNodes in inorder
     */
    public ArrayList<BSTNode> getInorder() {
        // TODO: Complete inorder traversal
        ArrayList<BSTNode> nodes = new ArrayList<>();
        return toGetInOrder(root, nodes);
    }

    public ArrayList<BSTNode> toGetInOrder(BSTNode currentNode, ArrayList<BSTNode> nodes) {
        if(currentNode == null) {
            return nodes;
        }
        toGetInOrder(currentNode.getLeft(), nodes);
        nodes.add(currentNode);
        toGetInOrder(currentNode.getRight(), nodes);
        return nodes;
    }

    /**
     * @return ArrayList of BSTNodes in preorder
     */
    public ArrayList<BSTNode> getPreorder() {
        // TODO: Complete preorder traversal
        ArrayList<BSTNode> nodes = new ArrayList<>();
        return toGetPreorder(root, nodes);
    }

    public ArrayList<BSTNode> toGetPreorder(BSTNode currentNode, ArrayList<BSTNode> nodes) {
        if(currentNode == null) {
            return nodes;
        }
        nodes.add(currentNode);
        toGetPreorder(currentNode.getLeft(), nodes);
        toGetPreorder(currentNode.getRight(), nodes);
        return nodes;
    }

    /**
     * @return ArrayList of BSTNodes in postorder
     */
    public ArrayList<BSTNode> getPostorder() {
        // TODO: Complete postorder traversal
        ArrayList<BSTNode> nodes = new ArrayList<>();
        return toGetPostorder(root, nodes);
    }

    public ArrayList<BSTNode> toGetPostorder(BSTNode currentNode, ArrayList<BSTNode> nodes) {
        if(currentNode == null) {
            return nodes;
        }
        toGetPostorder(currentNode.getLeft(), nodes);
        toGetPostorder(currentNode.getRight(), nodes);
        nodes.add(currentNode);
        return nodes;
    }

    /**
     * Inserts the given integer value to the tree
     * if it does not already exist. Modifies the
     * root instance variable to be the root of the new modified tree.
     * @param val The value ot insert
     */
    public void insert(int val) {
        // TODO: Complete insert
        toInsert(val, root);
    }

    public void toInsert(int val, BSTNode currentNode) {
        BSTNode leftNode = currentNode.getLeft();
        BSTNode rightNode = currentNode.getRight();
        if(val > currentNode.getVal()) {
            if(rightNode == null) {
                currentNode.setRight(new BSTNode(val));
                return;
            }
            toInsert(val, rightNode);
        }
        if(val < currentNode.getVal()) {
            if(leftNode == null) {
                currentNode.setLeft(new BSTNode(val));
                return;
            }
            toInsert(val, leftNode);
        }
    }


    /**
     * Determines if the current BST is
     * a valid BST.
     * @return true if valid false otherwise
     */
    public boolean isValidBST() {
        // TODO: Optional Challenge!
        return false;
    }

    public static void main(String[] args) {
        // Tree to help you test your code
        BST tree = new BST();
        tree.setupTestData();

        System.out.println("\nSearching for 15 in the tree");
        System.out.println(tree.search(15));

        System.out.println("\nSearching for 22 in the tree");
        System.out.println(tree.search(22));

        System.out.println("\nPreorder traversal of binary tree is");
        ArrayList<BSTNode> sol = tree.getPreorder();
        printNodes(sol);

        System.out.println("\nInorder traversal of binary tree is");
        sol = tree.getInorder();
        printNodes(sol);

        System.out.println("\nPostorder traversal of binary tree is");
        sol = tree.getPostorder();
        printNodes(sol);

        tree.insert(8);
        System.out.println("\nInorder traversal of binary tree is");
        sol = tree.getInorder();
        printNodes(sol);
    }
}
