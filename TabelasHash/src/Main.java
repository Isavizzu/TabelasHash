import java.awt.print.*;
import java.util.Scanner;

public class Main {

    public static long searchTime(TabelaHash table) {
        long time1 = table.search("Zea");
        long time2 = table.search("Zelda");
        long time3 = table.search("Zelma");
        return time1 + time2 + time3;
    }

    public static void main(String[] args) {

        Reader reader = new Reader("names.csv");
        TabelaHash table_1 = new TabelaHash_1(5000);
        TabelaHash table_2 = new TabelaHash_2(5000);

        long time = reader.addInTableHash(table_1);
        long timeHash2 = reader.addInTableHash(table_2);

        String report = "Relatório da Tabela Hash 1\n" +
                "------------------------------------------------\n" +
                "Tempo de inserção:\n" +
                "O tempo total para adicionar todas as chaves à Tabela Hash 1 foi de " + time + " milissegundos.\n\n" +
                "Tempo de busca:\n" +
                "O tempo necessário para buscar 3 nomes na Tabela Hash 1 foi de " + searchTime(table_1) + " nanossegundos.\n\n" +
                "Análise de colisões:\n" +
                "O número total de colisões detectadas na Tabela Hash 1 foi de " + table_1.getNumberOfCollisions() + " colisões.\n\n" +
                "Distribuição de chaves por posição na tabela:\n" +
                "------------------------------------------------\n";

        String report2 = "------------------------------------------------\n" +
                "Relatório da Tabela Hash 2\n" +
                "------------------------------------------------\n" +
                "Tempo de inserção:\n" +
                "O tempo total para adicionar todas as chaves à Tabela Hash 2 foi de " + timeHash2 + " milissegundos.\n\n" +
                "Tempo de busca:\n" +
                "O tempo necessário para buscar 3 nomes na Tabela Hash 2 foi de " + searchTime(table_2) + " nanossegundos.\n\n" +
                "Análise de colisões:\n" +
                "O número total de colisões detectadas na Tabela Hash 2 foi de " + table_2.getNumberOfCollisions() + " colisões.\n\n" +
                "Distribuição de chaves por posição na tabela:\n" +
                "------------------------------------------------\n";

        int[][] biggest = table_1.getBiggest();
        String report_biggest = "Os 10 valores com os maiores números de colisões na Tabela Hash 1 são:\n";

        int[] topPositions = biggest[0];
        int[] topValues = biggest[1];

        for (int i = 0; i < 10; i++) {
            report_biggest += (i + 1) + " - Valor " + topPositions[i] + " com " + (topValues[i] - 1) + " colisões\n";
        }

        int[][] biggest2 = table_2.getBiggest();
        String report_biggest2 = "Os 10 valores com os maiores números de colisões na Tabela Hash 2 são:\n";

        int[] topPositions2 = biggest2[0];
        int[] topValues2 = biggest2[1];

        for (int i = 0; i < 10; i++) {
            report_biggest2 += (i + 1) + " - Valor " + topPositions2[i] + " com " + (topValues2[i] - 1) + " colisões\n";
        }

        int[][] smallest = table_1.getSmallest();
        String report_smallest = "Os 5 valores com os menores números de colisões na Tabela Hash 1 são:\n";

        int[] minPositions = smallest[0];
        int[] minValues = smallest[1];

        for (int i = 0; i < 5; i++) {
            report_smallest += (i + 1) + " - Valor " + minPositions[i] + " com " + (minValues[i] - 1) + " colisões\n";
        }

        int[][] smallest2 = table_2.getSmallest();
        String report_smallest2 = "Os 5 valores com os menores números de colisões na Tabela Hash 2 são:\n";

        int[] minPositions2 = smallest2[0];
        int[] minValues2 = smallest2[1];

        for (int i = 0; i < 5; i++) {
            report_smallest2 += (i + 1) + " - Valor " + minPositions2[i] + " com " + (minValues2[i] - 1) + " colisões\n";
        }

        System.out.println(report);
        System.out.println(report_biggest);
        System.out.println(report_smallest);

        System.out.println(report2);
        System.out.println(report_biggest2);
        System.out.println(report_smallest2);

        String finalReport = report + report_biggest + report_smallest + report2 + report_biggest2 + report_smallest2;

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
