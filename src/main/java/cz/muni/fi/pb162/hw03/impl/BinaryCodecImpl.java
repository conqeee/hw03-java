package cz.muni.fi.pb162.hw03.impl;

import cz.muni.fi.pb162.hw03.BinaryCodec;
import cz.muni.fi.pb162.hw03.Encoding;
import cz.muni.fi.pb162.hw03.TreeNode;

/**
 * class represents encoding and decoding
 */
public class BinaryCodecImpl implements BinaryCodec {
    private final Encoding encoding;

    /**
     * setting the encoding attribute
     * @param encoding Encoding param
     */
    public BinaryCodecImpl(Encoding encoding){
        this.encoding = encoding;
    }

    @Override
    public String encode(String originalMessage) {
        StringBuilder result = new StringBuilder();

        for (Character character : originalMessage.toCharArray()){
            result.append(encoding.getEncodingString(character));
        }
        return result.toString();
    }

    @Override
    public String decode(String binaryMessage) {
        StringBuilder result = new StringBuilder();
        char bit;
        TreeNode actNode = encoding.getRoot();

        for (int i = 0; i < binaryMessage.length(); i++){
            bit = binaryMessage.charAt(i);
            if (actNode.getLeftChild() == null) {
                result.append(actNode.getCharacter());
                actNode = bit == '0' ? encoding.getRoot().getLeftChild() : encoding.getRoot().getRightChild();
            } else {
                actNode = bit == '0' ? actNode.getLeftChild() : actNode.getRightChild();
            }
        }
        result.append(actNode.getCharacter());
        return result.toString();
    }
}
