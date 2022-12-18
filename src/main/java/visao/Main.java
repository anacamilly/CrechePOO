package visao;

import dominio.Crianca;
import dominio.Cuidador;
import persistencia.CriancaDao;
import persistencia.CuidadorDao;

import java.util.Scanner;

public class Main {

    static CriancaDao crianDao = new CriancaDao();
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

                                crianDao.insert(crian);

                                System.out.println("|--------------------------------------------------------|");
                                System.out.println("|            CADASTRO CONCLUÍDO COM SUCESSO              |");
                                System.out.println("|--------------------------------------------------------|");
                                break;

                            case 2:
                                System.out.println("|--------------------------------------------------------|");
                                System.out.println("|            ALTERAÇÃO DE CADASTRO DA CRIANÇA            |");
                                System.out.println("|--------------------------------------------------------|");
                                System.out.println("| DIGITE O ID DA CRIANÇA QUE DESEJA ALTERAR:             |");
                                System.out.println("|--------------------------------------------------------|");
                                int id_alterar = teclado.nextInt();

                                var crianca_busca = crianDao.buscar(id_alterar);

                                if(crianca_busca == null) {
                                    System.out.println("|--------------------------------------------------------|");
                                    System.out.println("| ATENÇÃO: ESSE ID NÃO FOI ENCONTRADO                    |");
                                    System.out.println("|--------------------------------------------------------|");
                                } else {
                                    System.out.println("|--------------------------------------------------------|");
                                    System.out.println("|       INFORMAÇÕES RELACIONADAS AO ID ESCOLHIDO         |");
                                    System.out.println("|--------------------------------------------------------|");
                                    System.out.println("| NOME:" + crianca_busca.getNome());
                                    System.out.println("| CPF: " + crianca_busca.getCpf());
                                    System.out.println("| SEXO:" + crianca_busca.getSexo());
                                    System.out.println("| DATA DE NASCIMENTO:" + crianca_busca.getDataNascimento());
                                    System.out.println("| MATRÍCULA:" + crianca_busca.getMatricula());
                                    System.out.println("|--------------------------------------------------------|");
                                    System.out.println("| O QUE PRECISA SER ALTERADO?                            |");
                                    System.out.println("|--------------------------------------------------------|");
                                    System.out.println("| 1 - NOME                                               |");
                                    System.out.println("| 2 - CPF                                                |");
                                    System.out.println("| 3 - SEXO                                               |");
                                    System.out.println("| 4 - DATA DE NASCIMENTO                                 |");
                                    System.out.println("| 5 - MATRÍCULA                                          |");
                                    System.out.println("|--------------------------------------------------------|");
                                    System.out.println("| DIGITE A OPÇÃO DESEJADA:                               |");
                                    System.out.println("|--------------------------------------------------------|");
                                    var opc = teclado.nextInt();

                                    teclado.nextLine();
                                    Crianca crianAlt = new Crianca();


                                    switch (opc) {
                                        case 1:
                                            System.out.println("|--------------------------------------------------------|");
                                            System.out.println("|                    ALTERAÇÃO DE NOME                   |");
                                            System.out.println("|--------------------------------------------------------|");
                                            System.out.println("| ALTERANDO O NOME DA CRIANÇA:" + crianca_busca.getNome());
                                            System.out.println("|--------------------------------------------------------|");
                                            System.out.println("| DIGITE O NOVO NOME DA CRIANÇA:                         |");
                                            System.out.println("|--------------------------------------------------------|");
                                            String nomeAlterado = teclado.nextLine();
                                            crianAlt.setNome(nomeAlterado);

                                            String cpfcri = crianca_busca.getCpf();
                                            crianAlt.setCpf(cpfcri);

                                            String sexocri = crianca_busca.getSexo();
                                            crianAlt.setSexo(sexocri);

                                            String nascimentocri = crianca_busca.getDataNascimento();
                                            crianAlt.setDataNascimento(nascimentocri);

                                            int matriculacri = crianca_busca.getMatricula();
                                            crianAlt.setMatricula(matriculacri);

                                            crianAlt.setId(id_alterar);

                                            crianDao.alteracao(crianAlt, id_alterar);

                                            System.out.println("|--------------------------------------------------------|");
                                            System.out.println("|                NOME ALTERADO COM SUCESSO               |");
                                            System.out.println("|--------------------------------------------------------|");
                                            break;

                                        case 2:
                                            System.out.println("|--------------------------------------------------------|");
                                            System.out.println("|                    ALTERAÇÃO DE CPF                    |");
                                            System.out.println("|--------------------------------------------------------|");
                                            System.out.println("| ALTERANDO O CPF DA CRIANÇA: " + crianca_busca.getNome());
                                            System.out.println("|--------------------------------------------------------|");
                                            System.out.println("| DIGITE O NOVO CPF DA CRIANÇA:                          |");
                                            System.out.println("|--------------------------------------------------------|");
                                            String cpfAlterado = teclado.nextLine();
                                            crianAlt.setCpf(cpfAlterado);

                                            String nomecri = crianca_busca.getNome();
                                            crianAlt.setNome(nomecri);

                                            String sexocri2 = crianca_busca.getSexo();
                                            crianAlt.setSexo(sexocri2);

                                            String nascimentocri2 = crianca_busca.getDataNascimento();
                                            crianAlt.setDataNascimento(nascimentocri2);

                                            int matriculacri2 = crianca_busca.getMatricula();
                                            crianAlt.setMatricula(matriculacri2);

                                            crianAlt.setId(id_alterar);

                                            crianDao.alteracao(crianAlt, id_alterar);
                                            System.out.println("|--------------------------------------------------------|");
                                            System.out.println("|                 CPF ALTERADO COM SUCESSO               |");
                                            System.out.println("|--------------------------------------------------------|");
                                            break;

                                        case 3:
                                            System.out.println("|--------------------------------------------------------|");
                                            System.out.println("|                   ALTERAÇÃO DE SEXO                    |");
                                            System.out.println("|--------------------------------------------------------|");
                                            System.out.println("| ALTERANDO O SEXO DA CRIANÇA: " + crianca_busca.getNome());
                                            System.out.println("|--------------------------------------------------------|");
                                            System.out.println("| DIGITE O NOVO SEXO DA CRIANÇA:                         |");
                                            System.out.println("|--------------------------------------------------------|");
                                            String sexoAlterado = teclado.nextLine();
                                            crianAlt.setSexo(sexoAlterado);

                                            String nomecri3 = crianca_busca.getNome();
                                            crianAlt.setNome(nomecri3);

                                            String cpfcri3 = crianca_busca.getCpf();
                                            crianAlt.setCpf(cpfcri3);

                                            String nascimentocri3 = crianca_busca.getDataNascimento();
                                            crianAlt.setDataNascimento(nascimentocri3);

                                            int matriculacri3 = crianca_busca.getMatricula();
                                            crianAlt.setMatricula(matriculacri3);

                                            crianAlt.setId(id_alterar);

                                            crianDao.alteracao(crianAlt, id_alterar);
                                            System.out.println("|--------------------------------------------------------|");
                                            System.out.println("|                SEXO ALTERADO COM SUCESSO               |");
                                            System.out.println("|--------------------------------------------------------|");
                                            break;

                                        case 4:
                                            System.out.println("|--------------------------------------------------------|");
                                            System.out.println("|            ALTERAÇÃO DA DATA DE NASCIMENTO             |");
                                            System.out.println("|--------------------------------------------------------|");
                                            System.out.println("| ALTERANDO A DATA DE NASCIMENTO DA CRIANÇA: " + crianca_busca.getNome());
                                            System.out.println("|--------------------------------------------------------|");
                                            System.out.println("| DIGITE A DATA DE NASCIMENTO DA CRIANÇA:                |");
                                            System.out.println("|--------------------------------------------------------|");
                                            String dataAlterada = teclado.nextLine();
                                            crianAlt.setDataNascimento(dataAlterada);

                                            String nomecri4 = crianca_busca.getNome();
                                            crianAlt.setNome(nomecri4);

                                            String cpfcri4 = crianca_busca.getCpf();
                                            crianAlt.setCpf(cpfcri4);

                                            String sexocri4 = crianca_busca.getSexo();
                                            crianAlt.setSexo(sexocri4);

                                            int matriculacri4 = crianca_busca.getMatricula();
                                            crianAlt.setMatricula(matriculacri4);

                                            crianAlt.setId(id_alterar);

                                            crianDao.alteracao(crianAlt, id_alterar);
                                            System.out.println("|--------------------------------------------------------|");
                                            System.out.println("|        DATA DE NASCIMENTO ALTERADA COM SUCESSO         |");
                                            System.out.println("|--------------------------------------------------------|");
                                            break;

                                        case 5:
                                            teclado.nextLine();
                                            System.out.println("|--------------------------------------------------------|");
                                            System.out.println("|                ALTERAÇÃO DE MATRÍCULA                  |");
                                            System.out.println("|--------------------------------------------------------|");
                                            System.out.println("| ALTERANDO A MATRÍCULA DA CRIANÇA: " + crianca_busca.getNome());
                                            System.out.println("|--------------------------------------------------------|");
                                            System.out.println("| DIGITE A NOVA MATRÍCULA DA CRIANÇA:                    |");
                                            System.out.println("|--------------------------------------------------------|");
                                            int matriculaAlterada = teclado.nextInt();
                                            crianAlt.setMatricula(matriculaAlterada);

                                            String nomecri5 = crianca_busca.getNome();
                                            crianAlt.setNome(nomecri5);

                                            String cpfcri5 = crianca_busca.getCpf();
                                            crianAlt.setCpf(cpfcri5);

                                            String sexocri5 = crianca_busca.getSexo();
                                            crianAlt.setSexo(sexocri5);

                                            String nascimentocri5 = crianca_busca.getDataNascimento();
                                            crianAlt.setDataNascimento(nascimentocri5);

                                            crianAlt.setId(id_alterar);

                                            crianDao.alteracao(crianAlt, id_alterar);
                                            System.out.println("|--------------------------------------------------------|");
                                            System.out.println("|             MATRÍCULA ALTERADA COM SUCESSO             |");
                                            System.out.println("|--------------------------------------------------------|");

                                            break;
                                    }
                                }
                                break;

                            case 3:
                                System.out.println("|--------------------------------------------------------|");
                                System.out.println("|                     BUSCA DE CRIANÇA                   |");
                                System.out.println("|--------------------------------------------------------|");
                                System.out.println("| DIGITE O ID DA CRIANÇA:                                |");
                                System.out.println("|--------------------------------------------------------|");
                                int id_busca = teclado.nextInt();
                                teclado.nextLine();

                                var crn = crianDao.buscar(id_busca);


                                if(crn != null) {
                                    System.out.println("|--------------------------------------------------------|");
                                    System.out.println("| ID: " + crn.getId());
                                    System.out.println("| NOME: " + crn.getNome());
                                    System.out.println("| CPF: " + crn.getCpf());
                                    System.out.println("| SEXO: " + crn.getSexo());
                                    System.out.println("| DATA DE NASCIMENTO: " + crn.getDataNascimento());
                                    System.out.println("| MATRÍCULA: " + crn.getMatricula());
                                    System.out.println("|--------------------------------------------------------|");
                                }else {
                                    System.out.println("|--------------------------------------------------------|");
                                    System.out.println("| ATENÇÃO: ESSE ID NÃO ENCONTRADO                        |");
                                    System.out.println("|--------------------------------------------------------|");
                                }

                                break;

                            case 4:
                                System.out.println("|--------------------------------------------------------|");
                                System.out.println("|                EXCLUSÃO DE CRIANÇA                     |");
                                System.out.println("|--------------------------------------------------------|");
                                System.out.println("| DIGITE O ID DA CRIANÇA:                                |");
                                System.out.println("|--------------------------------------------------------|");
                                var id_excluir = teclado.nextInt();
                                Crianca crianca = new Crianca();
                                crianca.setId(id_excluir);

                                var verificaExc = crianDao.buscar(id_excluir);

                                if(verificaExc != null) {
                                    teclado.nextLine();
                                    System.out.println("|--------------------------------------------------------|");
                                    System.out.println("|         CADASTRO DA CRIANÇA QUE SERÁ EXCLUÍDO:         |");
                                    System.out.println("|--------------------------------------------------------|");
                                    System.out.println("| ID: " + verificaExc.getId());
                                    System.out.println("| NOME: " + verificaExc.getNome());
                                    System.out.println("| CPF: " + verificaExc.getCpf());
                                    System.out.println("| SEXO: " + verificaExc.getSexo());
                                    System.out.println("| DATA DE NASCIMENTO: " + verificaExc.getDataNascimento());
                                    System.out.println("| MATRÍCULA: " + verificaExc.getMatricula());
                                    System.out.println("|--------------------------------------------------------|");
                                    System.out.println("| ATENÇÃO: DESEJA EXCLUIR ESSE CADASTRO? DIGITE: S ou N  |");
                                    System.out.println("|--------------------------------------------------------|");
                                    var respEx = teclado.nextLine();

                                    switch (respEx){
                                        case "S":
                                            crianDao.remove(crianca);
                                            System.out.println("|--------------------------------------------------------|");
                                            System.out.println("|             CADASTRO EXCLUÍDO COM SUCESSO              |");
                                            System.out.println("|--------------------------------------------------------|");

                                            break;
                                        case "N":
                                            System.out.println("|--------------------------------------------------------|");
                                            System.out.println("|       O CADASTRO NÃO SERÁ EXCLUÍDO - VOTE AO MENU      |");
                                            System.out.println("|--------------------------------------------------------|");
                                            break;
                                        default:
                                            System.out.println("|--------------------------------------------------------|");
                                            System.out.println("|             OPÇÃO INVÁLIDA, TENTE NOVAMENTE            |");
                                            System.out.println("|--------------------------------------------------------|");
                                    }

                                }
                                break;

                            case 5:
                                break;

                            case 6:
                                System.out.println("|--------------------------------------------------------|");
                                System.out.println("|                SAIR DO MENU DE CRIANÇA                 |");
                                System.out.println("|--------------------------------------------------------|");
                                break;

                            default:
                                System.out.println("|--------------------------------------------------------|");
                                System.out.println("|             OPÇÃO INVÁLIDA, TENTE NOVAMENTE            |");
                                System.out.println("|--------------------------------------------------------|");

                        }
                    }while(digitoAluno != 6);

                    break;

                case 2:
                    int digitoCuidador;
                    Cuidador cuidador = new Cuidador();
                    do {
                        teclado.nextLine();
                        System.out.println("\n|--------------------------------------------------------|\n"
                                + "|                     MENU DE CUIDADOR                   |\n"
                                + "|--------------------------------------------------------|\n"
                                + "| 1 - CADASTRAR                                          |\n"
                                + "| 2 - ALTERAR                                            |\n"
                                + "| 3 - BUSCAR                                             |\n"
                                + "| 4 - REMOVER                                            |\n"
                                + "| 5 - LISTAR                                             |\n"
                                + "| 6 - SAIR DO MENU DE CUIDADOR                           |\n"
                                + "|--------------------------------------------------------|\n");

                        digitoCuidador = teclado.nextInt();
                        teclado.nextLine();

                        switch(digitoCuidador) {
                            case 1:
                                System.out.println("|--------------------------------------------------------|");
                                System.out.println("|                 CADASTRO DE CUIDADOR                   |");
                                System.out.println("|--------------------------------------------------------|");
                                System.out.println("| DIGITE O NOME DO CUIDADOR:                             |");
                                System.out.println("|--------------------------------------------------------|");
                                cuidador.setNome(teclado.nextLine());
                                System.out.println("|--------------------------------------------------------|");
                                System.out.println("| DIGITE O CPF DO CUIDADOR:                              |");
                                System.out.println("|--------------------------------------------------------|");
                                cuidador.setCpf(teclado.nextLine());
                                System.out.println("|--------------------------------------------------------|");
                                System.out.println("| DIGITE O SEXO DO CUIDADOR:                             |");
                                System.out.println("|--------------------------------------------------------|");
                                cuidador.setSexo(teclado.nextLine());
                                System.out.println("|--------------------------------------------------------|");
                                System.out.println("| DIGITE A DATA DE NASCIMENTO DO CUIDADOR:               |");
                                System.out.println("|--------------------------------------------------------|");
                                cuidador.setDataNascimento(teclado.nextLine());
                                System.out.println("|--------------------------------------------------------|");
                                System.out.println("| DIGITE O VALOR DO SALARIO DO CUIDADOR:                 |");
                                System.out.println("|--------------------------------------------------------|");
                                cuidador.setSalario(teclado.nextFloat());
                                System.out.println("|--------------------------------------------------------|");
                                System.out.println("| DIGITE O TELEFONE DO CUIDADOR:                         |");
                                System.out.println("|--------------------------------------------------------|");
                                teclado.nextLine();
                                cuidador.setTelefone(teclado.nextLine());


                                cuidadorDao.insert(cuidador);

                                System.out.println("|--------------------------------------------------------|");
                                System.out.println("|            CADASTRO CONCLUÍDO COM SUCESSO              |");
                                System.out.println("|--------------------------------------------------------|");

                                break;
                        }

                        }while(digitoCuidador != 6);

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
