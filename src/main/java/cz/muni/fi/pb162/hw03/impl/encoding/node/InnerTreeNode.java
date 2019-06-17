package cz.muni.fi.pb162.hw03.impl.encoding.node;

import cz.muni.fi.pb162.hw03.TreeNode;
import cz.muni.fi.pb162.hw03.impl.SymbolFrequency;

/**
 * class represents nonleafs
 */
public class InnerTreeNode extends AbstractTreeNode {
    /**
     * constructor sets empty char as a symbol and frequency of both of children and sets left and right child
     * @param left left child
     * @param right right child
     */
    public InnerTreeNode(TreeNode left, TreeNode right){
        super(new SymbolFrequency(EMPTY_CHAR,right.getFrequency()+left.getFrequency()),left,right);
    }

    @Override
    public int hashCode() {
        int result = getLeftChild().hashCode();
        result = 31 * result + getRightChild().hashCode();
        return result;
    }

    /**
     * two nonleafs are equals when their left and right child is the same
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TreeNode that = (TreeNode) o;

        return (this.getLeftChild().equals(that.getLeftChild()) && this.getRightChild().equals(that.getRightChild()));
    }
}
