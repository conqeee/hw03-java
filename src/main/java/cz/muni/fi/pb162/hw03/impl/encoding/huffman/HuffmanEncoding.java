package cz.muni.fi.pb162.hw03.impl.encoding.huffman;

import cz.muni.fi.pb162.hw03.Encoding;
import cz.muni.fi.pb162.hw03.HuffmanAlgorithm;
import cz.muni.fi.pb162.hw03.TreeNode;
import cz.muni.fi.pb162.hw03.impl.encoding.node.InnerTreeNode;
import cz.muni.fi.pb162.hw03.impl.SymbolFrequency;

import java.util.Map;
import java.util.HashMap;
import java.util.NavigableSet;
import java.util.Set;

/**
 * class represents huffman encoding
 */
public class HuffmanEncoding implements Encoding, HuffmanAlgorithm {
    private TreeNode root;
    private Map<Character,String> map = new HashMap<>();

    /**
     * setting root
     * and making a map using a collection converter method
     * @param table FrequencyTable class attribute
     */
    public HuffmanEncoding(FrequencyTable table){
        Map<TreeNode,String> treeNodeMap = new HashMap<>();
        this.root = frequencyTableToTree(table.createTable());
        createCodeTree(treeNodeMap,getRoot(),"");
        map = CollectionConverter.nodeMapToEncodingMap(treeNodeMap);
    }

    /**
     * Codes char into its binary representation.
     * @param encodingChar input character
     * @return string
     */
    @Override
    public String getEncodingString(char encodingChar) {
        return map.get(encodingChar);
    }

    /**
     * root getter
     * @return root node
     */
    @Override
    public TreeNode getRoot() {
        return root;
    }

    @Override
    public TreeNode frequencyTableToTree(Set<SymbolFrequency> characterFrequencies) {
        NavigableSet<TreeNode> nodes = CollectionConverter.charSetToLeafNodeSet(characterFrequencies);
        while (nodes.size()>1){
            TreeNode left = nodes.pollFirst();
            TreeNode right = nodes.pollFirst();
            nodes.add(new InnerTreeNode(left,right));
        }
        return nodes.pollFirst();

    }
x
    @Override
    public void createCodeTree(Map<TreeNode, String> map, TreeNode node, String encodingString) {
        if (node.isLeaf()){
            map.put(node,encodingString);
        } else {
            createCodeTree(map,node.getLeftChild(),encodingString+"0");
            createCodeTree(map,node.getRightChild(),encodingString+"1");
        }

    }
}
