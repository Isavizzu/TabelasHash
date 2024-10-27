public class TabelaHash_2 extends TabelaHash {

    public TabelaHash_2(int size) {
        super(size);
    }

    public int calculeHash(String chave) {
        int valor = 0;
        for (int i = 0; i < chave.length(); i++) {
            valor = (valor << 5) - valor + chave.charAt(i);
        }
        return Math.abs(valor % super.getSize()); // Garante índice dentro dos limites
    }
}