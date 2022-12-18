package visao;

import dominio.Crianca;
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
                    int digitoAluno;
                    Crianca crian = new Crianca();
                    do {
                        teclado.nextLine();
                        System.out.println("\n|--------------------------------------------------------|\n"
                                + "|                      MENU DA CRIANÇA                   |\n"
                                + "|--------------------------------------------------------|\n"
                                + "| 1 - CADASTRAR                                          |\n"
                                + "| 2 - ALTERAR                                            |\n"
                                + "| 3 - BUSCAR                                             |\n"
                                + "| 4 - REMOVER                                            |\n"
                                + "| 5 - LISTAR                                             |\n"
                                + "| 6 - SAIR DO MENU DA CRIANÇA                            |\n"
                                + "|--------------------------------------------------------|\n");

                        digitoAluno = teclado.nextInt();
                        teclado.nextLine();

                        switch(digitoAluno) {
                            case 1:
                                System.out.println("|--------------------------------------------------------|");
                                System.out.println("|                  CADASTRO DA CRIANÇA                   |");
                                System.out.println("|--------------------------------------------------------|");
                                System.out.println("| DIGITE O NOME DA CRIANÇA:                              |");
                                System.out.println("|--------------------------------------------------------|");
                                crian.setNome(teclado.nextLine());
                                System.out.println("|--------------------------------------------------------|");
                                System.out.println("| DIGITE O CPF DA CRIANÇA:                               |");
                                System.out.println("|--------------------------------------------------------|");
                                crian.setCpf(teclado.nextLine());
                                System.out.println("|--------------------------------------------------------|");
                                System.out.println("| DIGITE O SEXO DA CRIANÇA:                              |");
                                System.out.println("|--------------------------------------------------------|");
                                crian.setSexo(teclado.nextLine());
                                System.out.println("|--------------------------------------------------------|");
                                System.out.println("| DIGITE A DATA DE NASCIMENTO DA CRIANÇA:                |");
                                System.out.println("|--------------------------------------------------------|");
                                crian.setDataNascimento(teclado.nextLine());
                                System.out.println("|--------------------------------------------------------|");
                                System.out.println("| DIGITE A MATRÍCULA DA CRIANÇA:                         |");
                                System.out.println("|--------------------------------------------------------|");
                                crian.setMatricula(teclado.nextInt());

                                teclado.nextLine();

                                break;
                            case 2:
                                break;
                        }
                    }while(digitoAluno != 6);


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

                    break;
            }while(digito != 5);
    }
}
