package cz.muni.fi.pb162.hw03.impl;

/**
 * class represents symbol freq
 */
public class SymbolFrequency implements Comparable<SymbolFrequency> {
    private Character symbol;
    private int frequency;

    /**
     * constructor setting spec symbol and its freq
     * @param symbol symbol
     * @param frequency freq
     */
    public SymbolFrequency(Character symbol, int frequency){
        this.symbol = symbol;
        this.frequency = frequency;
    }

    /**
     * getter of symbol
     * @return symbol
     */
    public Character getCharacter() {
        return symbol;
    }

    /**
     * getter of freq
     * @return freq
     */
    public int getFrequency() {
        return frequency;
    }

    /**
     * FreqX'symbol'
     * @return string message
     */
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("");
        sb.append(getFrequency());
        sb.append("x'").append(symbol);
        sb.append("'");
        return sb.toString();
    }

    /**
     * equals based on frequency and symbol
     * @param o second object
     * @return true or flase
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SymbolFrequency that = (SymbolFrequency) o;

        if (frequency != that.frequency) return false;
        return symbol.equals(that.symbol);
    }

    /**
     * hash code
     * @return hash
     */
    @Override
    public int hashCode() {
        int result = symbol.hashCode();
        result = 31 * result + frequency;
        return result;
    }

    /**
     * comparing - mainly based on freq from lower to higher than from A to Z
     * @param o compared obj
     * @return int
     */
    public int compareTo(SymbolFrequency o) {
        if (this.frequency==o.frequency){
            return Character.compare(Character.toLowerCase(this.symbol),Character.toLowerCase(o.symbol));
        }
        return this.frequency-o.frequency;

    }
}
