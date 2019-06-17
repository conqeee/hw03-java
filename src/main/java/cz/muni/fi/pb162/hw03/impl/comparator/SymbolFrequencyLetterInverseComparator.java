package cz.muni.fi.pb162.hw03.impl.comparator;

import cz.muni.fi.pb162.hw03.impl.SymbolFrequency;

import java.util.Comparator;

/**
 * class for comparing mainly via freq, than inversed via character
 */
public class SymbolFrequencyLetterInverseComparator implements Comparator<SymbolFrequency>{
    @Override
    public int compare(SymbolFrequency o1, SymbolFrequency o2) {
       if (o1.getFrequency()==o2.getFrequency()){
            return -(Character.compare(Character.toLowerCase(o1.getCharacter()),
                    Character.toLowerCase(o2.getCharacter())));
        }
        return o1.compareTo(o2);
    }
}
