public class TabelaHash_1 extends TabelaHash{

    public TabelaHash_1 (int size) {
        super(size);
    }


    public int calculeHash(String name) {
        int value = 0;
        for (int i = 0; i < name.length(); i++) {
            value = (value * 31) + name.charAt(i);
        }
        return Math.abs(value % super.getSize());
    }

}

