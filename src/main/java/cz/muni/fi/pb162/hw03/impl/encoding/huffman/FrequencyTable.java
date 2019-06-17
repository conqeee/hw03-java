package cz.muni.fi.pb162.hw03.impl.encoding.huffman;

import cz.muni.fi.pb162.hw03.impl.SymbolFrequency;

import java.util.Set;
import java.util.Map;
import java.util.SortedSet;
import java.util.HashMap;
import java.util.TreeSet;

/**
 * class representing the message and transforming that into freq. table
 */
public class FrequencyTable {
    private String message;

    /**
     * constructor for setting the message
     * @param message something
     */
    public FrequencyTable(String message){
        this.message=message;
    }

    /**
     * creating a table/set filled with SymbolFrequency attributes using a map and sorted set
     * @return set with SymbolFreq
     */
    public Set<SymbolFrequency> createTable(){
        Map<Character,Integer> table = new HashMap<>();
        SortedSet<SymbolFrequency> symbolFrequencySet = new TreeSet<>();
        for (int i = 0; i<message.length(); i++){
            if (table.containsKey(message.charAt(i))){
                table.put(message.charAt(i),table.get(message.charAt(i))+1);
            } else table.put(message.charAt(i), 1);
        }
        for (Character chars : table.keySet()){
            symbolFrequencySet.add(new SymbolFrequency(chars, table.get(chars)));
        }
        return symbolFrequencySet;
    }
}
