import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * An Integer Binary Search Tree
 * @author: Sabrina Vohra
 * @version: 4/4/24
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
        // Creates ArrayList to add into during recursive method
        ArrayList<BSTNode> nodes = new ArrayList<>();
        // Calls recursive method to get nodes in order
        return toGetInOrder(root, nodes);
    }

    // Recursive method to get nodes in order
    public ArrayList<BSTNode> toGetInOrder(BSTNode currentNode, ArrayList<BSTNode> nodes) {
        // Base case for if the node currently being searched is null / if the list is complete
        if(currentNode == null) {
            return nodes;
        }
        // Calls recursive method on lefter nodes
        toGetInOrder(currentNode.getLeft(), nodes);
        // Adds node to ArrayList
        nodes.add(currentNode);
        // Calls recursive method on righter nodes
        toGetInOrder(currentNode.getRight(), nodes);
        // Returns ArrayList of nodes after nodes have been added
        return nodes;
    }

    /**
     * @return ArrayList of BSTNodes in preorder
     */
    public ArrayList<BSTNode> getPreorder() {
        // Creates ArrayList to store nodes while in recursive method
        ArrayList<BSTNode> nodes = new ArrayList<>();
        // Calls recursive method to put nodes in preorder
        return toGetPreorder(root, nodes);
    }

    // Recursive method to put nodes in preorder order
    public ArrayList<BSTNode> toGetPreorder(BSTNode currentNode, ArrayList<BSTNode> nodes) {
        // Returns ArrayList if the current node is not filled
        if(currentNode == null) {
            return nodes;
        }
        // Adds current node to the ArrayList before adding rest of nodes (hence: PREorder)
        nodes.add(currentNode);
        // Calls method on lefter nodes
        toGetPreorder(currentNode.getLeft(), nodes);
        // Calls method on righter nodes
        toGetPreorder(currentNode.getRight(), nodes);
        // Returns ArrayList of nodes after calling methods
        return nodes;
    }

    /**
     * @return ArrayList of BSTNodes in postorder
     */
    public ArrayList<BSTNode> getPostorder() {
        // Creates ArrayList to store nodes while in recursive method
        ArrayList<BSTNode> nodes = new ArrayList<>();
        // Calls recursive method to put nodes in postorder
        return toGetPostorder(root, nodes);
    }

    // Recursive method to put nodes in postorder
    public ArrayList<BSTNode> toGetPostorder(BSTNode currentNode, ArrayList<BSTNode> nodes) {
        // Returns ArrayList of nodes if the current node is null
        if(currentNode == null) {
            return nodes;
        }
        // Calls recursive method for lefter nodes
        toGetPostorder(currentNode.getLeft(), nodes);
        // Calls recursive method for righter nodes
        toGetPostorder(currentNode.getRight(), nodes);
        // Adds node to ArrayList after calling recursive method (hence: POSTorder)
        nodes.add(currentNode);
        // Returns ArrayList of nodes after calling recursive methods and adding to ArrayList
        return nodes;
    }

    /**
     * Inserts the given integer value to the tree
     * if it does not already exist. Modifies the
     * root instance variable to be the root of the new modified tree.
     * @param val The value ot insert
     */
    public void insert(int val) {
        // Calls recursive method to insert values into the tree
        toInsert(val, root);
    }

    // Recursive method to insert values into the tree
    public void toInsert(int val, BSTNode currentNode) {
        // Variables for left and right nodes in relation to the current node
        BSTNode leftNode = currentNode.getLeft();
        BSTNode rightNode = currentNode.getRight();
        // Checks if value is greater than the value of the current node
        if(val > currentNode.getVal()) {
            // Checks to make sure the node to the right of the current node is not valid (so it can add a new node)
            if(rightNode == null) {
                // If it is null, it sets a node to the right to be the value
                currentNode.setRight(new BSTNode(val));
                // Returns and exits the method
                return;
            }
            // If the node is not null, calls the recursive method with righter node
            toInsert(val, rightNode);
        }
        // Checks if value is less than the value of the current node
        if(val < currentNode.getVal()) {
            // Checks to make sure the node to the left of the current node is not valid (so it can add a new node)
            if(leftNode == null) {
                // If it is null, it sets a node to the left to be the value
                currentNode.setLeft(new BSTNode(val));
                // Returns and exits the method
                return;
            }
            // If the node is not null, calls the recursive method with lefter node
            toInsert(val, leftNode);
        }
    }


    /**
     * Determines if the current BST is
     * a valid BST.
     * @return true if valid false otherwise
     */
    public boolean isValidBST() {
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
