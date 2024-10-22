//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Reader reader = new Reader("names.csv");
        TabelaHash table_1 = new TabelaHash_1(50);

        long time = reader.addInTableHash(table_1);


        System.out.println("Relatório da Tabela Hash 1\n" +
                "------------------------------------------------\n" +
                "Tempo de inserção:\n" +
                "O tempo total para adicionar todas as chaves à Tabela Hash 1 foi de " + time + " milissegundos.\n\n" +
                "Tempo de busca:\n" +
                "O tempo necessário para buscar X nomes na Tabela Hash 1 foi de X milissegundos.\n\n" +
                "Análise de colisões:\n" +
                "O número total de colisões detectadas na Tabela Hash 1 foi de " + table_1.getNumberOfCollisions() + " colisões.\n\n" +
                "Distribuição de chaves por posição na tabela:\n" +
                "------------------------------------------------\n");

        for (int i = 0; i < table_1.getSize(); i++) {

            int distribution = table_1.verifyDistribution(i);

            if (distribution == 0) {
                System.out.println("No valor " + i + " não foi armazenada nenhuma chave, logo, não há colisões.");
            } else if (distribution == 1) {
                System.out.println("No valor " + i + " foi armazenada uma chave, logo, não há colisões.");
            } else {
                System.out.println("No valor " + i + " foram armazenadas " + distribution + " chaves, com " + (distribution - 1) + " colisão(ões).");
            }
        }


    }
}



