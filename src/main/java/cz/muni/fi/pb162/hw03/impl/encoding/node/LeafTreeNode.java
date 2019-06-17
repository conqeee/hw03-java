package cz.muni.fi.pb162.hw03.impl.encoding.node;


import cz.muni.fi.pb162.hw03.TreeNode;
import cz.muni.fi.pb162.hw03.impl.SymbolFrequency;

/**
 * class representing leafs
 */
public class LeafTreeNode extends AbstractTreeNode {
    /**
     * constructor for creating a leaf - both children are null
     * @param symbolFrequency some symbolfrequency
     */
    public LeafTreeNode(SymbolFrequency symbolFrequency){
        super(symbolFrequency,null, null);
    }

    @Override
    public int hashCode() {
        int result = getCharacter().hashCode();
        result = 31 * result + getFrequency();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TreeNode that = (TreeNode) o;

        if (this.getFrequency() != that.getFrequency()) return false;
        return this.getCharacter().equals(that.getCharacter());
    }
}
