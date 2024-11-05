public class TabelaHash_2 extends TabelaHash {

    public TabelaHash_2(int size) {
        super(size);
    }

    public int calculeHash(String name) {
        int hash = 0;
        int primeNumber = 37;

        for (int i = 0; i < name.length(); i++) {
            hash += primeNumber * hash + name.charAt(i);
        }

        return Math.abs(hash % super.getSize());
    }
}