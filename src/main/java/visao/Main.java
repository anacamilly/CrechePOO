package visao;

import persistencia.CriancaDao;
import persistencia.CuidadorDao;

import java.util.Scanner;

public class Main {

    static CriancaDao crianDao= new CriancaDao();
    static CuidadorDao cuidadorDao= new CuidadorDao();

    public static void main(String[] args) {
        int digito;
        Scanner teclado = new Scanner(System.in);

        do {
            System.out.println("\n");
            System.out.print("|--------------------------------------------------------|\n");
            System.out.print("|                     SISTEMA DE CRECHE                  |\n");
            System.out.print("|--------------------------------------------------------|\n");
            System.out.print("|                       MENU PRINCIPAL                   |\n"
                    + "|--------------------------------------------------------|\n"
                    + "| ESCOLHA UMA OPÇÃO ABAIXO:                              |\n"
                    + "|--------------------------------------------------------|\n"
                    + "| 1 - CRIANÇA                                            |\n"
                    + "| 2 - CUIDADOR                                           |\n"
                    + "| 3 - TURMA                                              |\n"
                    + "| 4 - EXTRA-CURRICULAR                                   |\n"
                    + "| 5 - SAIR DO SISTEMA                                    |\n"
                    + "|--------------------------------------------------------|\n");

            digito = teclado.nextInt();
            switch(digito) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
            }

        }while(digito != 5);
    }
}
