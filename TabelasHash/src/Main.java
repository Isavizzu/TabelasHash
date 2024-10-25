import java.awt.*;
import java.awt.print.*;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        Reader reader = new Reader("names.csv");
        TabelaHash table_1 = new TabelaHash_1(50);
        //TabelaHash table_2 = new TabelaHash_2();

        long time = reader.addInTableHash(table_1);

        //long timeHash2 = reader.addInTableHash(table_2);

        String report = "Relatório da Tabela Hash 1\n" +
        "------------------------------------------------\n" +
        "Tempo de inserção:\n" +
        "O tempo total para adicionar todas as chaves à Tabela Hash 1 foi de " + time + " milissegundos.\n\n" +
        "Tempo de busca:\n" +
        "O tempo necessário para buscar X nomes na Tabela Hash 1 foi de X milissegundos.\n\n" +
        "Análise de colisões:\n" +
        "O número total de colisões detectadas na Tabela Hash 1 foi de " + table_1.getNumberOfCollisions() + " colisões.\n\n" +
        "Distribuição de chaves por posição na tabela:\n" +
        "------------------------------------------------\n";

        String report2 = "Relatório da Tabela Hash 2\n" +
        "------------------------------------------------\n" +
        "Tempo de inserção:\n" +
        "O tempo total para adicionar todas as chaves à Tabela Hash 1 foi de " + time + " milissegundos.\n\n" +
        "Tempo de busca:\n" +
        "O tempo necessário para buscar X nomes na Tabela Hash 1 foi de X milissegundos.\n\n" +
        "Análise de colisões:\n" +
        "O número total de colisões detectadas na Tabela Hash 1 foi de " + table_1.getNumberOfCollisions() + " colisões.\n\n" +
        "Distribuição de chaves por posição na tabela:\n" +
        "------------------------------------------------\n";



        System.out.println(report);

        String keyDistribution = "";

        for (int i = 0; i < table_1.getSize(); i++) {

            int distribution = table_1.verifyDistribution(i);

            if (distribution == 0) {
                String display = "No valor " + i + " não foi armazenada nenhuma chave, logo, não há colisões.\n";
                keyDistribution += display;
                System.out.println(display);
            } else if (distribution == 1) {
                String display = "No valor " + i + " foi armazenada uma chave, logo, não há colisões.\n";
                keyDistribution += display;
                System.out.println(display);
            } else {
                String display = "No valor " + i + " foram armazenadas " + distribution + " chaves, com " + (distribution - 1) + " colisão(ões).\n";
                keyDistribution += display;
                System.out.println(display);
            }
        }

        report += keyDistribution;

        PrinterJob job = PrinterJob.getPrinterJob();
        job.setPrintable(new GerarPDF(report, report2));

        boolean doPrint = job.printDialog();
        if (doPrint) {
            try {
                job.print();
            } catch (PrinterException e) {
                e.printStackTrace();
            }
        }


    }
}



