import java.awt.*;
import java.awt.print.*;
import java.util.Scanner;

import javax.swing.*;

public class Main {

    public static long searchTime(TabelaHash table){
        long time1 = table.search("James Brown");
        long time2 = table.search("David White");
        long time3 = table.search("Barbara Johnson");
        return time1 + time2 + time3;
    }
    public static void main(String[] args) {

        Reader reader = new Reader("names.csv");
        TabelaHash table_1 = new TabelaHash_1(50);
        TabelaHash table_2 = new TabelaHash_2(50);

        long time = reader.addInTableHash(table_1);

        long timeHash2 = reader.addInTableHash(table_2);


        String report = "Relatório da Tabela Hash 1\n" +
        "------------------------------------------------\n" +
        "Tempo de inserção:\n" +
        "O tempo total para adicionar todas as chaves à Tabela Hash 1 foi de " + time + " milissegundos.\n\n" +
        "Tempo de busca:\n" +
        "O tempo necessário para buscar 3 nomes na Tabela Hash 1 foi de "+ searchTime(table_1) +" milissegundos.\n\n" +
        "Análise de colisões:\n" +
        "O número total de colisões detectadas na Tabela Hash 1 foi de " + table_1.getNumberOfCollisions() + " colisões.\n\n" +
        "Distribuição de chaves por posição na tabela:\n" +
        "------------------------------------------------\n";

        String report2 = "------------------------------------------------\n"+
        "Relatório da Tabela Hash 2\n" +
        "------------------------------------------------\n" +
        "Tempo de inserção:\n" +
        "O tempo total para adicionar todas as chaves à Tabela Hash 1 foi de " + timeHash2 + " milissegundos.\n\n" +
        "Tempo de busca:\n" +
        "O tempo necessário para buscar 3 nomes na Tabela Hash 1 foi de "+ searchTime(table_2) +" milissegundos.\n\n" +
        "Análise de colisões:\n" +
        "O número total de colisões detectadas na Tabela Hash 1 foi de " + table_2.getNumberOfCollisions() + " colisões.\n\n" +
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

        String keyDistribution2 = "";

        System.out.println(report2);

        for (int i = 0; i < table_2.getSize(); i++) {
            int distribution = table_2.verifyDistribution(i);

            if (distribution == 0) {
                String display = "No valor " + i + " não foi armazenada nenhuma chave, logo, não há colisões.\n";
                keyDistribution2 += display;
                System.out.println(display);
            } else if (distribution == 1) {
                String display = "No valor " + i + " foi armazenada uma chave, logo, não há colisões.\n";
                keyDistribution2 += display;
                System.out.println(display);
            } else {
                String display = "No valor " + i + " foram armazenadas " + distribution + " chaves, com " + (distribution - 1) + " colisão(ões).\n";
                keyDistribution2 += display;
                System.out.println(display);
            }
        }

        report2 += keyDistribution2;
        
        String finalReport =  report + report2;

        Scanner scan = new Scanner(System.in);
        System.out.println("Você deseja salvar o relatório?");
        System.out.println("1 - Sim");
        System.out.println("2 - Não");
        int choice = scan.nextInt();

        switch (choice) {
            case 1:
                PrinterJob job = PrinterJob.getPrinterJob();
                job.setPrintable(new GerarPDF(finalReport));

                boolean doPrint = job.printDialog();
                if (doPrint) {
                    try {
                        job.print();
                    } catch (PrinterException e) {
                        e.printStackTrace();
                    }
                }
                break;

            case 2:
                System.out.println("Programa encerrado.");
                break;
        
            default:
                System.out.println("Opção inválida.");
                break;
        }
    }
}



