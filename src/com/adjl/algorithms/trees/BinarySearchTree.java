package com.adjl.algorithms.trees;

public class BinarySearchTree {

    private static enum TraversalOrder {
        INORDER, PREORDER, POSTORDER
    }

    public static BinarySearchTree root;

    public int item;
    public BinarySearchTree parent;
    public BinarySearchTree left;
    public BinarySearchTree right;

    public BinarySearchTree search(int item) {
        return search(item, root);
    }

    private BinarySearchTree search(int item, BinarySearchTree tree) {
        if (tree == null) return null;
        if (item < tree.item) {
            return search(item, tree.left);
        } else if (item > tree.item) {
            return search(item, tree.right);
        } else {
            return tree;
        }
    }

    public BinarySearchTree minimum() {
        if (root == null) return null;
        return minimum(root);
    }

    private BinarySearchTree minimum(BinarySearchTree tree) {
        if (tree.left == null) return tree;
        return minimum(tree.left);
    }

    public BinarySearchTree maximum() {
        if (root == null) return null;
        return maximum(root);
    }

    private BinarySearchTree maximum(BinarySearchTree tree) {
        if (tree.right == null) return tree;
        return maximum(tree.right);
    }

    public void traverse(TraversalOrder order) {
        switch (order) {
            case INORDER:
                traverseInorder(root);
                break;
            case PREORDER:
                traversePreorder(root);
                break;
            case POSTORDER:
                traversePostorder(root);
                break;
            default:
                break;
        }
    }

    private void traverseInorder(BinarySearchTree tree) {
        if (tree == null) return;
        traverseInorder(tree.left);
        processItem(tree.item);
        traverseInorder(tree.right);
    }

    private void traversePreorder(BinarySearchTree tree) {
        if (tree == null) return;
        processItem(tree.item);
        traversePreorder(tree.left);
        traversePreorder(tree.right);
    }

    private void traversePostorder(BinarySearchTree tree) {
        if (tree == null) return;
        traversePostorder(tree.left);
        traversePostorder(tree.right);
        processItem(tree.item);
    }

    private static void processItem(int item) {
        System.out.print(item + " ");
    }

    public void insert(int item) {
        if (root == null) {
            root = makeNode(item, null);
        } else {
            insert(item, root);
        }
    }

    private void insert(int item, BinarySearchTree tree) {
        if (item < tree.item) {
            insertLeft(item, tree);
        } else {
            insertRight(item, tree);
        }
    }

    private void insertLeft(int item, BinarySearchTree tree) {
        if (tree.left == null) {
            tree.left = makeNode(item, tree);
        } else {
            insert(item, tree.left);
        }
    }

    private void insertRight(int item, BinarySearchTree tree) {
        if (tree.right == null) {
            tree.right = makeNode(item, tree);
        } else {
            insert(item, tree.right);
        }
    }

    private static BinarySearchTree makeNode(int item, BinarySearchTree parent) {
        BinarySearchTree node = new BinarySearchTree();
        node.item = item;
        node.parent = parent;
        node.left = node.right = null;
        return node;
    }

    public void delete(int item) {
        BinarySearchTree node = search(item);
        if (root == null || node == null) return;
        if (node == root) {
            deleteRoot();
        } else {
            deleteNode(node);
        }
    }

    private void deleteRoot() {
        if (root.left == null && root.right == null) {
            root = null;
        } else if (root.left == null) {
            root = root.right;
        } else if (root.right == null) {
            root = root.left;
        } else {
            BinarySearchTree node = minimum(root.right);
            // FIXME .delete() should delete node in subtree, not whole tree
            root.right.delete(node.item);
            root.item = node.item;
        }
    }

    private void deleteNode(BinarySearchTree node) {
        if (node.left == null && node.right == null) {
            setNode(node, null);
        } else if (node.left == null) {
            setNode(node, node.right);
        } else if (node.right == null) {
            setNode(node, node.left);
        } else {
            BinarySearchTree newNode = minimum(node.right);
            // FIXME .delete() should delete node in subtree, not whole tree
            node.right.delete(newNode.item);
            node.item = newNode.item;
        }
    }

    private static void setNode(BinarySearchTree node, BinarySearchTree value) {
        if (value != null) value.parent = node.parent;
        if (node == node.parent.left) {
            node.parent.left = value;
        } else {
            node.parent.right = value;
        }
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();

        tree.insert(5);
        tree.insert(1);
        tree.insert(10);

        System.out.println(tree.search(5).item);
        System.out.println(tree.minimum().item);
        System.out.println(tree.maximum().item);

        tree.traverse(TraversalOrder.INORDER);
        System.out.println();

        tree.delete(1);
        tree.traverse(TraversalOrder.INORDER);
        System.out.println();

        tree.delete(10);
        tree.traverse(TraversalOrder.INORDER);
        System.out.println();

        tree.insert(3);
        tree.insert(2);
        tree.traverse(TraversalOrder.INORDER);
        System.out.println();

        tree.delete(3);
        tree.traverse(TraversalOrder.INORDER);
        System.out.println();

        tree.insert(6);
        tree.insert(7);
        tree.traverse(TraversalOrder.INORDER);
        System.out.println();

        tree.delete(6);
        tree.traverse(TraversalOrder.INORDER);
        System.out.println();

        tree.insert(9);
        tree.insert(8);
        tree.insert(10);
        tree.traverse(TraversalOrder.INORDER);
        System.out.println();

        tree.delete(9);
        tree.traverse(TraversalOrder.INORDER);
        System.out.println();
    }
}
