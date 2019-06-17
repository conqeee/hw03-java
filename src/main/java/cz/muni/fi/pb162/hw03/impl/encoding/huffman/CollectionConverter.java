package cz.muni.fi.pb162.hw03.impl.encoding.huffman;
import cz.muni.fi.pb162.hw03.TreeNode;
import cz.muni.fi.pb162.hw03.impl.encoding.node.LeafTreeNode;
import cz.muni.fi.pb162.hw03.impl.SymbolFrequency;

import java.util.NavigableSet;
import java.util.Map;
import java.util.TreeSet;
import java.util.Set;
import java.util.HashMap;

/**
 * class for methods usefull for converting collections
 */
public class CollectionConverter {
    /**
     * from table to forrest
     * @param charSet set of symbolfrequencies
     * @return set of treenodes
     */
    public static NavigableSet<TreeNode> charSetToLeafNodeSet(Set<SymbolFrequency> charSet){
        NavigableSet<TreeNode> forrest = new TreeSet<>();

        for (SymbolFrequency chars : charSet){
            forrest.add(new LeafTreeNode(chars));
        }
        return forrest;
    }

    /**
     * from map of Treenode and its binary rep. to  symbols and rep.
     * @param nodeStringMap TreeNode, String
     * @return map of symbol and its representation
     */
    public static Map<Character, String> nodeMapToEncodingMap(Map<TreeNode, String> nodeStringMap){
        Map<Character, String> encodingMap = new HashMap<>();
        for (TreeNode keys : nodeStringMap.keySet()){
            encodingMap.put(keys.getCharacter(),nodeStringMap.get(keys));
        }
        return encodingMap;
    }
}
