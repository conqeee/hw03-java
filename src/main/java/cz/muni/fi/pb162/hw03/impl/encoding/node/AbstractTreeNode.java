package cz.muni.fi.pb162.hw03.impl.encoding.node;

import cz.muni.fi.pb162.hw03.TreeNode;
import cz.muni.fi.pb162.hw03.impl.SymbolFrequency;

/**
 * abstract class represents stuff common for both types of nodes
 */
public abstract class AbstractTreeNode implements TreeNode {
    private SymbolFrequency node;
    private TreeNode left;
    private TreeNode right;

    /**
     * constructor sets the symbol and freq + left and right child
     * @param node symbol freq
     * @param left child
     * @param right child
     */
    public AbstractTreeNode(SymbolFrequency node, TreeNode left, TreeNode right){
        this.node=node;
        this.left=left;
        this.right=right;
    }

    /**
     * freq getter
     * @return freq
     */
    @Override
    public int getFrequency() {
        return node.getFrequency();
    }

    /**
     * symbol getter
     * @return symbol
     */
    @Override
    public Character getCharacter() {
        return node.getCharacter();
    }

    /**
     * left node / chhild
     * @return node
     */
    @Override
    public TreeNode getLeftChild() {
        return left;
    }

    /**
     * right node/ child
     * @return node
     */
    @Override
    public TreeNode getRightChild() {
        return right;
    }

    /**
     * boolean operation - if right and left child of node is null, than its leaf / true
     * @return true/false
     */
    @Override
    public boolean isLeaf() {
        return (getLeftChild()==null && getRightChild()==null);
    }

    /**
     * basically compared via freq, if its same
     * if compared leaf with nonleaf, the leaf is higher
     * if compared nonleaf with nonleaf, compader mainly via left child, than right
     * if compared leaf with leaf, compared via symbol
     * @param o second treenode
     * @return int
     */
    @Override
    public int compareTo(TreeNode o) {
        if (this.getFrequency()-o.getFrequency()==0) {
            if (this.isLeaf() && !o.isLeaf()) {
                return 1;
            }
            if (!this.isLeaf() && o.isLeaf()) {
                return -1;
            }
            if (this.isLeaf() && o.isLeaf()) {
                if (Character.compare(this.getCharacter(), o.getCharacter()) == 0) {
                    return this.getFrequency() - o.getFrequency();
                }
                return Character.compare(this.getCharacter(), o.getCharacter());
            }
            if (!this.isLeaf() && !o.isLeaf()) {
                if (this.left.compareTo(o.getLeftChild()) == 0) {
                    return this.right.compareTo(o.getRightChild());
                }
                return this.left.compareTo(o.getLeftChild());
            }
            return this.getFrequency() - o.getFrequency();
        }
        return this.getFrequency()-o.getFrequency();
    }

    /**
     * if its leaf, returns leaf + node.tostring
     * else leftchild.character -(frequency of its children)-right.character
     * @return string
     */
    @Override
    public String toString() {
        if (isLeaf()){
            final StringBuilder sb = new StringBuilder("Leaf ");
            sb.append(node.toString());
            return sb.toString();
        } else {
            final StringBuilder sb = new StringBuilder("");
            sb.append(left.getCharacter());
            sb.append("-(").append(left.getFrequency()+right.getFrequency()).append(")-").append(right.getCharacter());
            return sb.toString();
        }
    }
}
