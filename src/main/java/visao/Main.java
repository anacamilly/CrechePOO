package visao;

import dominio.*;
import persistencia.*;

import java.util.List;
import java.util.Scanner;

public class Main {

    static Crianca crian = new Crianca();
    static Cuidador cuidador = new Cuidador();
    static Turma turma = new Turma();
    static Responsavel responsavel = new Responsavel();
    static ExtraCurricular extraCurricular = new ExtraCurricular();
    static CriancaDao crianDao = new CriancaDao();
    static CuidadorDao cuidadorDao= new CuidadorDao();
    static TurmaDao turmaDao= new TurmaDao();
    static ResponsavelDao responsDao = new ResponsavelDao();

    static ExtraCurricularDao extraCurricularDao = new ExtraCurricularDao();

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
                    + "| 4 - RESPONSÁVEL                                        |\n"
                    + "| 5 - EXTRACURRICULAR                                    |\n"
                    + "| 6 - SAIR DO SISTEMA                                    |\n"
                    + "|--------------------------------------------------------|\n");

            digito = teclado.nextInt();
            switch(digito) {
                case 1:
                    int digitoCrianca;
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

                        digitoCrianca = teclado.nextInt();
                        teclado.nextLine();

                        switch (digitoCrianca) {
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
                                int idAlterarCrian = teclado.nextInt();

                                var crianca_busca = crianDao.buscar(idAlterarCrian);

                                if (crianca_busca == null) {
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
                                            crian.setNome(nomeAlterado);

                                            String cpfcri = crianca_busca.getCpf();
                                            crian.setCpf(cpfcri);

                                            String sexocri = crianca_busca.getSexo();
                                            crian.setSexo(sexocri);

                                            String nascimentocri = crianca_busca.getDataNascimento();
                                            crian.setDataNascimento(nascimentocri);

                                            int matriculacri = crianca_busca.getMatricula();
                                            crian.setMatricula(matriculacri);

                                            crian.setId(idAlterarCrian);

                                            crianDao.alteracao(crian, idAlterarCrian);

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
                                            crian.setCpf(cpfAlterado);

                                            String nomecri = crianca_busca.getNome();
                                            crian.setNome(nomecri);

                                            String sexocri2 = crianca_busca.getSexo();
                                            crian.setSexo(sexocri2);

                                            String nascimentocri2 = crianca_busca.getDataNascimento();
                                            crian.setDataNascimento(nascimentocri2);

                                            int matriculacri2 = crianca_busca.getMatricula();
                                            crian.setMatricula(matriculacri2);

                                            crian.setId(idAlterarCrian);

                                            crianDao.alteracao(crian, idAlterarCrian);
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
                                            crian.setSexo(sexoAlterado);

                                            String nomecri3 = crianca_busca.getNome();
                                            crian.setNome(nomecri3);

                                            String cpfcri3 = crianca_busca.getCpf();
                                            crian.setCpf(cpfcri3);

                                            String nascimentocri3 = crianca_busca.getDataNascimento();
                                            crian.setDataNascimento(nascimentocri3);

                                            int matriculacri3 = crianca_busca.getMatricula();
                                            crian.setMatricula(matriculacri3);

                                            crian.setId(idAlterarCrian);

                                            crianDao.alteracao(crian, idAlterarCrian);
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
                                            crian.setDataNascimento(dataAlterada);

                                            String nomecri4 = crianca_busca.getNome();
                                            crian.setNome(nomecri4);

                                            String cpfcri4 = crianca_busca.getCpf();
                                            crian.setCpf(cpfcri4);

                                            String sexocri4 = crianca_busca.getSexo();
                                            crian.setSexo(sexocri4);

                                            int matriculacri4 = crianca_busca.getMatricula();
                                            crian.setMatricula(matriculacri4);

                                            crian.setId(idAlterarCrian);

                                            crianDao.alteracao(crian, idAlterarCrian);
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
                                            crian.setMatricula(matriculaAlterada);

                                            String nomecri5 = crianca_busca.getNome();
                                            crian.setNome(nomecri5);

                                            String cpfcri5 = crianca_busca.getCpf();
                                            crian.setCpf(cpfcri5);

                                            String sexocri5 = crianca_busca.getSexo();
                                            crian.setSexo(sexocri5);

                                            String nascimentocri5 = crianca_busca.getDataNascimento();
                                            crian.setDataNascimento(nascimentocri5);

                                            crian.setId(idAlterarCrian);

                                            crianDao.alteracao(crian, idAlterarCrian);
                                            System.out.println("|--------------------------------------------------------|");
                                            System.out.println("|             MATRÍCULA ALTERADA COM SUCESSO             |");
                                            System.out.println("|--------------------------------------------------------|");

                                            break;

                                        default:
                                            System.out.println("|--------------------------------------------------------|");
                                            System.out.println("|             OPÇÃO INVÁLIDA, TENTE NOVAMENTE            |");
                                            System.out.println("|--------------------------------------------------------|");


                                    }
                                }
                                break;

                            case 3:
                                System.out.println("|--------------------------------------------------------|");
                                System.out.println("|              BUSCAR CADASTRO DE CRIANÇA                |");
                                System.out.println("|--------------------------------------------------------|");
                                System.out.println("| DIGITE O ID DA CRIANÇA:                                |");
                                System.out.println("|--------------------------------------------------------|");
                                int idBuscaCrian = teclado.nextInt();
                                teclado.nextLine();

                                var crn = crianDao.buscar(idBuscaCrian);


                                if (crn != null) {
                                    System.out.println("|--------------------------------------------------------|");
                                    System.out.println("| ID: " + crn.getId());
                                    System.out.println("| NOME: " + crn.getNome());
                                    System.out.println("| CPF: " + crn.getCpf());
                                    System.out.println("| SEXO: " + crn.getSexo());
                                    System.out.println("| DATA DE NASCIMENTO: " + crn.getDataNascimento());
                                    System.out.println("| MATRÍCULA: " + crn.getMatricula());
                                    System.out.println("|--------------------------------------------------------|");
                                } else {
                                    System.out.println("|--------------------------------------------------------|");
                                    System.out.println("| ATENÇÃO: ESSE ID NÃO ENCONTRADO                        |");
                                    System.out.println("|--------------------------------------------------------|");
                                }

                                break;

                            case 4:
                                System.out.println("|--------------------------------------------------------|");
                                System.out.println("|           EXCLUSÃO DE CADASTRO DE CRIANÇA              |");
                                System.out.println("|--------------------------------------------------------|");
                                System.out.println("| DIGITE O ID DA CRIANÇA:                                |");
                                System.out.println("|--------------------------------------------------------|");
                                var idExcluirCrian = teclado.nextInt();
                                crian.setId(idExcluirCrian);

                                var verificaExc = crianDao.buscar(idExcluirCrian);

                                if (verificaExc != null) {
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

                                    switch (respEx) {
                                        case "S", "s":
                                            crianDao.exclusao(idExcluirCrian);
                                            System.out.println("|--------------------------------------------------------|");
                                            System.out.println("|             CADASTRO EXCLUÍDO COM SUCESSO              |");
                                            System.out.println("|--------------------------------------------------------|");

                                            break;
                                        case "N", "n":
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
                                System.out.println("|--------------------------------------------------------|");
                                System.out.println("|                    LISTA DE CRIANÇAS                   |");
                                System.out.println("|--------------------------------------------------------|");

                                for (Crianca crianList : crianDao.listar()) {
                                    System.out.println("| ID: " + crianList.getId());
                                    System.out.println("| NOME: " + crianList.getNome());
                                    System.out.println("| CPF: " + crianList.getCpf());
                                    System.out.println("| SEXO: " + crianList.getSexo());
                                    System.out.println("| DATA DE NASCIMENTO: " + crianList.getDataNascimento());
                                    System.out.println("| MATRÍCULA: " + crianList.getMatricula());
                                    System.out.println("|--------------------------------------------------------|");
                                }

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
                    } while (digitoCrianca != 6);

                    break;

                case 2:
                    int digitoCuidador;
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

                        switch (digitoCuidador) {
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

                            case 2:
                                System.out.println("|--------------------------------------------------------|");
                                System.out.println("|           ALTERAÇÃO DE CADASTRO DO CUIDADOR            |");
                                System.out.println("|--------------------------------------------------------|");
                                System.out.println("| DIGITE O ID DO CUIDADOR QUE DESEJA ALTERAR:            |");
                                System.out.println("|--------------------------------------------------------|");
                                int idAlterarCuidador = teclado.nextInt();

                                var cuidadorBusca = cuidadorDao.buscar(idAlterarCuidador);

                                if (cuidadorBusca == null) {
                                    System.out.println("|--------------------------------------------------------|");
                                    System.out.println("| ATENÇÃO: ESSE ID NÃO FOI ENCONTRADO                    |");
                                    System.out.println("|--------------------------------------------------------|");
                                } else {
                                    System.out.println("|--------------------------------------------------------|");
                                    System.out.println("|       INFORMAÇÕES RELACIONADAS AO ID ESCOLHIDO         |");
                                    System.out.println("|--------------------------------------------------------|");
                                    System.out.println("| NOME:" + cuidadorBusca.getNome());
                                    System.out.println("| CPF: " + cuidadorBusca.getCpf());
                                    System.out.println("| SEXO:" + cuidadorBusca.getSexo());
                                    System.out.println("| DATA DE NASCIMENTO:" + cuidadorBusca.getDataNascimento());
                                    System.out.println("| SALÁRIO:" + cuidadorBusca.getSalario());
                                    System.out.println("| TELEFONE:" + cuidadorBusca.getTelefone());
                                    System.out.println("|--------------------------------------------------------|");
                                    System.out.println("| O QUE PRECISA SER ALTERADO?                            |");
                                    System.out.println("|--------------------------------------------------------|");
                                    System.out.println("| 1 - NOME                                               |");
                                    System.out.println("| 2 - CPF                                                |");
                                    System.out.println("| 3 - SEXO                                               |");
                                    System.out.println("| 4 - DATA DE NASCIMENTO                                 |");
                                    System.out.println("| 5 - SALÁRIO                                            |");
                                    System.out.println("| 6 - TELEFONE                                            |");
                                    System.out.println("|--------------------------------------------------------|");
                                    System.out.println("| DIGITE A OPÇÃO DESEJADA:                               |");
                                    System.out.println("|--------------------------------------------------------|");
                                    var opc2 = teclado.nextInt();

                                    teclado.nextLine();

                                    switch (opc2) {
                                        case 1:
                                            System.out.println("|--------------------------------------------------------|");
                                            System.out.println("|                    ALTERAÇÃO DE NOME                   |");
                                            System.out.println("|--------------------------------------------------------|");
                                            System.out.println("| ALTERANDO O NOME DO CUIDADOR:" + cuidadorBusca.getNome());
                                            System.out.println("|--------------------------------------------------------|");
                                            System.out.println("| DIGITE O NOVO NOME DO CUIDADOR:                        |");
                                            System.out.println("|--------------------------------------------------------|");
                                            String nomeAlterado2 = teclado.nextLine();
                                            cuidador.setNome(nomeAlterado2);

                                            String cpfcuid = cuidadorBusca.getCpf();
                                            cuidador.setCpf(cpfcuid);

                                            String sexocuid = cuidadorBusca.getSexo();
                                            cuidador.setSexo(sexocuid);

                                            String nascimentocri = cuidadorBusca.getDataNascimento();
                                            cuidador.setDataNascimento(nascimentocri);

                                            float salariocuid = cuidadorBusca.getSalario();
                                            cuidador.setSalario(salariocuid);

                                            String telefonecuid = cuidadorBusca.getTelefone();
                                            cuidador.setTelefone(telefonecuid);

                                            cuidador.setId(idAlterarCuidador);

                                            cuidadorDao.alteracao(cuidador, idAlterarCuidador);

                                            System.out.println("|--------------------------------------------------------|");
                                            System.out.println("|                NOME ALTERADO COM SUCESSO               |");
                                            System.out.println("|--------------------------------------------------------|");
                                            break;

                                        case 2:
                                            System.out.println("|--------------------------------------------------------|");
                                            System.out.println("|                    ALTERAÇÃO DE CPF                    |");
                                            System.out.println("|--------------------------------------------------------|");
                                            System.out.println("| ALTERANDO O CPF DO CUIDADOR: " + cuidador.getNome());
                                            System.out.println("|--------------------------------------------------------|");
                                            System.out.println("| DIGITE O NOVO CPF DO CUIDADOR:                         |");
                                            System.out.println("|--------------------------------------------------------|");
                                            String cpfAlterado2 = teclado.nextLine();
                                            cuidador.setCpf(cpfAlterado2);

                                            String nomecuid2 = cuidadorBusca.getNome();
                                            cuidador.setNome(nomecuid2);

                                            String sexocuid2 = cuidadorBusca.getSexo();
                                            cuidador.setSexo(sexocuid2);

                                            String nascimentocuid2 = cuidadorBusca.getDataNascimento();
                                            cuidador.setDataNascimento(nascimentocuid2);

                                            float salariocuid2 = cuidadorBusca.getSalario();
                                            cuidador.setSalario(salariocuid2);

                                            String telefonecuid2 = cuidadorBusca.getTelefone();
                                            cuidador.setTelefone(telefonecuid2);


                                            cuidador.setId(idAlterarCuidador);

                                            cuidadorDao.alteracao(cuidador, idAlterarCuidador);
                                            System.out.println("|--------------------------------------------------------|");
                                            System.out.println("|                 CPF ALTERADO COM SUCESSO               |");
                                            System.out.println("|--------------------------------------------------------|");
                                            break;

                                        case 3:
                                            System.out.println("|--------------------------------------------------------|");
                                            System.out.println("|                   ALTERAÇÃO DE SEXO                    |");
                                            System.out.println("|--------------------------------------------------------|");
                                            System.out.println("| ALTERANDO O SEXO DO CUIDADOR: " + cuidadorBusca.getNome());
                                            System.out.println("|--------------------------------------------------------|");
                                            System.out.println("| DIGITE O NOVO SEXO DO CUIDADOR:                        |");
                                            System.out.println("|--------------------------------------------------------|");
                                            String sexoAlterado2 = teclado.nextLine();
                                            cuidador.setSexo(sexoAlterado2);

                                            String nomecuid3 = cuidadorBusca.getNome();
                                            cuidador.setNome(nomecuid3);

                                            String cpfcuid3 = cuidadorBusca.getCpf();
                                            cuidador.setCpf(cpfcuid3);

                                            String nascimentocuid3 = cuidadorBusca.getDataNascimento();
                                            cuidador.setDataNascimento(nascimentocuid3);

                                            float salariocuid3 = cuidadorBusca.getSalario();
                                            cuidador.setSalario(salariocuid3);
                                            ;

                                            String telefonecuid3 = cuidadorBusca.getTelefone();
                                            cuidador.setTelefone(telefonecuid3);


                                            cuidador.setId(idAlterarCuidador);

                                            cuidadorDao.alteracao(cuidador, idAlterarCuidador);

                                            System.out.println("|--------------------------------------------------------|");
                                            System.out.println("|                SEXO ALTERADO COM SUCESSO               |");
                                            System.out.println("|--------------------------------------------------------|");
                                            break;

                                        case 4:
                                            System.out.println("|--------------------------------------------------------|");
                                            System.out.println("|            ALTERAÇÃO DA DATA DE NASCIMENTO             |");
                                            System.out.println("|--------------------------------------------------------|");
                                            System.out.println("| ALTERANDO A DATA DE NASCIMENTO DO CUIDADOR: " + cuidadorBusca.getNome());
                                            System.out.println("|--------------------------------------------------------|");
                                            System.out.println("| DIGITE A DATA DE NASCIMENTO DO CUIDADOR:               |");
                                            System.out.println("|--------------------------------------------------------|");
                                            String dataAlterada2 = teclado.nextLine();
                                            cuidador.setDataNascimento(dataAlterada2);

                                            String nomecuid4 = cuidadorBusca.getNome();
                                            cuidador.setNome(nomecuid4);

                                            String cpfcuid4 = cuidadorBusca.getCpf();
                                            cuidador.setCpf(cpfcuid4);

                                            String sexocuid4 = cuidadorBusca.getSexo();
                                            cuidador.setSexo(sexocuid4);

                                            float salariocuid4 = cuidadorBusca.getSalario();
                                            cuidador.setSalario(salariocuid4);
                                            ;

                                            String telefonecuid4 = cuidadorBusca.getTelefone();
                                            cuidador.setTelefone(telefonecuid4);

                                            cuidador.setId(idAlterarCuidador);

                                            cuidadorDao.alteracao(cuidador, idAlterarCuidador);
                                            System.out.println("|--------------------------------------------------------|");
                                            System.out.println("|        DATA DE NASCIMENTO ALTERADA COM SUCESSO         |");
                                            System.out.println("|--------------------------------------------------------|");
                                            break;

                                        case 5:
                                            System.out.println("|--------------------------------------------------------|");
                                            System.out.println("|                ALTERAÇÃO DE SALÁRIO                    |");
                                            System.out.println("|--------------------------------------------------------|");
                                            System.out.println("| ALTERANDO O SALÁRIO DO CUIDADOR: " + cuidadorBusca.getNome());
                                            System.out.println("|--------------------------------------------------------|");
                                            System.out.println("| DIGITE O NOVO SALÁRIO DO CUIDADOR:                     |");
                                            System.out.println("|--------------------------------------------------------|");
                                            float salarioAlterado = teclado.nextFloat();
                                            cuidador.setSalario(salarioAlterado);

                                            String nomecuid5 = cuidadorBusca.getNome();
                                            cuidador.setNome(nomecuid5);

                                            String cpfcuid5 = cuidadorBusca.getCpf();
                                            cuidador.setCpf(cpfcuid5);

                                            String sexocuid5 = cuidadorBusca.getSexo();
                                            cuidador.setSexo(sexocuid5);

                                            String nascimentocuid5 = cuidadorBusca.getDataNascimento();
                                            cuidador.setDataNascimento(nascimentocuid5);

                                            String telefonecuid5 = cuidadorBusca.getTelefone();
                                            cuidador.setTelefone(telefonecuid5);


                                            cuidador.setId(idAlterarCuidador);

                                            cuidadorDao.alteracao(cuidador, idAlterarCuidador);
                                            System.out.println("|--------------------------------------------------------|");
                                            System.out.println("|             SALÁRIO ALTERADO COM SUCESSO               |");
                                            System.out.println("|--------------------------------------------------------|");

                                            break;

                                        case 6:
                                            System.out.println("|--------------------------------------------------------|");
                                            System.out.println("|                ALTERAÇÃO DE TELEFONE                   |");
                                            System.out.println("|--------------------------------------------------------|");
                                            System.out.println("| ALTERANDO O TELEFONE DO CUIDADOR: " + cuidadorBusca.getNome());
                                            System.out.println("|--------------------------------------------------------|");
                                            System.out.println("| DIGITE O NOVO TELEFONE DO CUIDADOR:                    |");
                                            System.out.println("|--------------------------------------------------------|");
                                            float telefoneAlterado = teclado.nextFloat();
                                            cuidador.setSalario(telefoneAlterado);

                                            String nomecuid6 = cuidadorBusca.getNome();
                                            cuidador.setNome(nomecuid6);

                                            String cpfcuid6 = cuidadorBusca.getCpf();
                                            cuidador.setCpf(cpfcuid6);

                                            String sexocuid6 = cuidadorBusca.getSexo();
                                            cuidador.setSexo(sexocuid6);

                                            String nascimentocuid6 = cuidadorBusca.getDataNascimento();
                                            cuidador.setDataNascimento(nascimentocuid6);

                                            String telefonecuid6 = cuidadorBusca.getTelefone();
                                            cuidador.setTelefone(telefonecuid6);


                                            cuidador.setId(idAlterarCuidador);

                                            cuidadorDao.alteracao(cuidador, idAlterarCuidador);
                                            System.out.println("|--------------------------------------------------------|");
                                            System.out.println("|             TELEFONE ALTERADO COM SUCESSO              |");
                                            System.out.println("|--------------------------------------------------------|");

                                            break;

                                        default:
                                            System.out.println("|--------------------------------------------------------|");
                                            System.out.println("|             OPÇÃO INVÁLIDA, TENTE NOVAMENTE            |");
                                            System.out.println("|--------------------------------------------------------|");


                                    }
                                }

                                break;

                            case 3:
                                System.out.println("|--------------------------------------------------------|");
                                System.out.println("|                    BUSCA DE CUIDADOR                   |");
                                System.out.println("|--------------------------------------------------------|");
                                System.out.println("| DIGITE O ID DO CUIDADOR:                               |");
                                System.out.println("|--------------------------------------------------------|");
                                int idBuscaCuid = teclado.nextInt();
                                teclado.nextLine();

                                var buscaCuidador = cuidadorDao.buscar(idBuscaCuid);


                                if (buscaCuidador != null) {
                                    System.out.println("|--------------------------------------------------------|");
                                    System.out.println("| ID: " + buscaCuidador.getId());
                                    System.out.println("| NOME: " + buscaCuidador.getNome());
                                    System.out.println("| CPF: " + buscaCuidador.getCpf());
                                    System.out.println("| SEXO:" + buscaCuidador.getSexo());
                                    System.out.println("| DATA DE NASCIMENTO: " + buscaCuidador.getDataNascimento());
                                    System.out.println("| SALÁRIO:" + buscaCuidador.getSalario());
                                    System.out.println("| TELEFONE:" + buscaCuidador.getTelefone());
                                    System.out.println("|--------------------------------------------------------|");
                                } else {
                                    System.out.println("|--------------------------------------------------------|");
                                    System.out.println("| ATENÇÃO: ESSE ID NÃO ENCONTRADO                        |");
                                    System.out.println("|--------------------------------------------------------|");
                                }

                                break;

                            case 4:
                                System.out.println("|--------------------------------------------------------|");
                                System.out.println("|           EXCLUSÃO DE CADASTRO DE CUIDADOR             |");
                                System.out.println("|--------------------------------------------------------|");
                                System.out.println("| DIGITE O ID DO CUIDADOR:                               |");
                                System.out.println("|--------------------------------------------------------|");
                                var idExcluir2 = teclado.nextInt();
                                cuidador.setId(idExcluir2);

                                var verificaExc2 = cuidadorDao.buscar(idExcluir2);

                                if (verificaExc2 != null) {
                                    teclado.nextLine();
                                    System.out.println("|--------------------------------------------------------|");
                                    System.out.println("|        CADASTRO DO CUIDADOR QUE SERÁ EXCLUÍDO:         |");
                                    System.out.println("|--------------------------------------------------------|");
                                    System.out.println("| ID: " + verificaExc2.getId());
                                    System.out.println("| NOME: " + verificaExc2.getNome());
                                    System.out.println("| CPF: " + verificaExc2.getCpf());
                                    System.out.println("| SEXO: " + verificaExc2.getSexo());
                                    System.out.println("| DATA DE NASCIMENTO: " + verificaExc2.getDataNascimento());
                                    System.out.println("| SALÁRIO: " + verificaExc2.getSalario());
                                    System.out.println("| TELEFONE: " + verificaExc2.getTelefone());
                                    System.out.println("|--------------------------------------------------------|");
                                    System.out.println("| ATENÇÃO: DESEJA EXCLUIR ESSE CADASTRO? DIGITE: S ou N  |");
                                    System.out.println("|--------------------------------------------------------|");
                                    var respEx2 = teclado.nextLine();

                                    switch (respEx2) {
                                        case "S", "s":
                                            cuidadorDao.exclusao(idExcluir2);
                                            System.out.println("|--------------------------------------------------------|");
                                            System.out.println("|             CADASTRO EXCLUÍDO COM SUCESSO              |");
                                            System.out.println("|--------------------------------------------------------|");

                                            break;
                                        case "N", "n":
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
                                System.out.println("|--------------------------------------------------------|");
                                System.out.println("|                   LISTA DE CUIDADORES                  |");
                                System.out.println("|--------------------------------------------------------|");

                                for (Cuidador cuidadorList : cuidadorDao.listar()) {
                                    System.out.println("| ID: " + cuidadorList.getId());
                                    System.out.println("| NOME: " + cuidadorList.getNome());
                                    System.out.println("| CPF: " + cuidadorList.getCpf());
                                    System.out.println("| SEXO: " + cuidadorList.getSexo());
                                    System.out.println("| DATA DE NASCIMENTO: " + cuidadorList.getDataNascimento());
                                    System.out.println("| SALÁRIO: " + cuidadorList.getSalario());
                                    System.out.println("| TELEFONE: " + cuidadorList.getTelefone());
                                    System.out.println("|--------------------------------------------------------|");
                                }

                                break;

                            case 6:
                                System.out.println("|--------------------------------------------------------|");
                                System.out.println("|               SAIR DO MENU DE CUIDADORES               |");
                                System.out.println("|--------------------------------------------------------|");
                                break;

                            default:
                                System.out.println("|--------------------------------------------------------|");
                                System.out.println("|             OPÇÃO INVÁLIDA, TENTE NOVAMENTE            |");
                                System.out.println("|--------------------------------------------------------|");

                        }
                    } while (digitoCuidador != 6);

                    break;

                case 3:
                    int digitoTurma;
                    do {
                        teclado.nextLine();
                        System.out.println("\n|--------------------------------------------------------|\n"
                                + "|                       MENU DA TURMA                    |\n"
                                + "|--------------------------------------------------------|\n"
                                + "| 1 - CADASTRAR                                          |\n"
                                + "| 2 - ALTERAR                                            |\n"
                                + "| 3 - BUSCAR                                             |\n"
                                + "| 4 - REMOVER                                            |\n"
                                + "| 5 - LISTAR                                             |\n"
                                + "| 6 - SAIR DO MENU DA TURMA                              |\n"
                                + "|--------------------------------------------------------|\n");

                        digitoTurma = teclado.nextInt();

                        switch (digitoTurma) {
                            case 1:
                                teclado.nextLine();
                                System.out.println("|--------------------------------------------------------|");
                                System.out.println("|                   CADASTRO DA TURMA                    |");
                                System.out.println("|--------------------------------------------------------|");
                                System.out.println("| DIGITE O CÓDIGO DA TURMA:                              |");
                                System.out.println("|--------------------------------------------------------|");
                                turma.setCodigo(teclado.nextInt());
                                teclado.nextLine();
                                System.out.println("|--------------------------------------------------------|");
                                System.out.println("| DIGITE O NOME DA TURMA:                                |");
                                System.out.println("|--------------------------------------------------------|");
                                turma.setNome(teclado.nextLine());
                                System.out.println("|--------------------------------------------------------|");
                                System.out.println("| DIGITE A QUANTIDADE DE PARTICIPANTES DA TURMA:         |");
                                System.out.println("|--------------------------------------------------------|");
                                turma.setQuantidadeAlunos(teclado.nextInt());
                                System.out.println("|--------------------------------------------------------|");

                                teclado.nextLine();

                                turmaDao.insert(turma);

                                System.out.println("|--------------------------------------------------------|");
                                System.out.println("|            CADASTRO CONCLUÍDO COM SUCESSO              |");
                                System.out.println("|--------------------------------------------------------|");
                                break;

                            case 2:
                                System.out.println("|--------------------------------------------------------|");
                                System.out.println("|             ALTERAÇÃO DE CADASTRO DA TURMA             |");
                                System.out.println("|--------------------------------------------------------|");
                                System.out.println("| DIGITE O CÓDIGO DA TURMA QUE DESEJA ALTERAR:           |");
                                System.out.println("|--------------------------------------------------------|");
                                int idAlterarTurma = teclado.nextInt();

                                var turmaBusca = turmaDao.buscar(idAlterarTurma);

                                if (turmaBusca == null) {
                                    System.out.println("|--------------------------------------------------------|");
                                    System.out.println("| ATENÇÃO: ESSE ID NÃO FOI ENCONTRADO                    |");
                                    System.out.println("|--------------------------------------------------------|");
                                } else {
                                    System.out.println("|--------------------------------------------------------|");
                                    System.out.println("|       INFORMAÇÕES RELACIONADAS AO ID ESCOLHIDO         |");
                                    System.out.println("|--------------------------------------------------------|");
                                    System.out.println("| CÓDIGO:" + turmaBusca.getCodigo());
                                    System.out.println("| NOME: " + turmaBusca.getNome());
                                    System.out.println("| QUANTIDADE DE PARTICIPANTES:" + turmaBusca.getQuantidadeAlunos());
                                    System.out.println("|--------------------------------------------------------|");
                                    System.out.println("| O QUE PRECISA SER ALTERADO?                            |");
                                    System.out.println("|--------------------------------------------------------|");
                                    System.out.println("| 1 - CÓDIGO                                             |");
                                    System.out.println("| 2 - NOME                                               |");
                                    System.out.println("| 3 - QUANTIDADE DE PARTICIPANTES                        |");
                                    System.out.println("|--------------------------------------------------------|");
                                    System.out.println("| DIGITE A OPÇÃO DESEJADA:                               |");
                                    System.out.println("|--------------------------------------------------------|");
                                    var opc3 = teclado.nextInt();

                                    teclado.nextLine();


                                    switch (opc3) {
                                        case 1:
                                            System.out.println("|--------------------------------------------------------|");
                                            System.out.println("|                 ALTERAÇÃO DE CÓDIGO                    |");
                                            System.out.println("|--------------------------------------------------------|");
                                            System.out.println("| ALTERANDO O CÓDIGO DA TURMA: " + turmaBusca.getNome());
                                            System.out.println("|--------------------------------------------------------|");
                                            System.out.println("| DIGITE O NOVO CÓDIGO DA TURMA:                         |");
                                            System.out.println("|--------------------------------------------------------|");
                                            int codigoAlterado = teclado.nextInt();
                                            turma.setCodigo(codigoAlterado);

                                            String nometurma = turmaBusca.getNome();
                                            crian.setNome(nometurma);

                                            int quantAlunostur = turmaBusca.getQuantidadeAlunos();
                                            turma.setQuantidadeAlunos(quantAlunostur);

                                            turma.setCodigo(idAlterarTurma);

                                            crianDao.alteracao(crian, idAlterarTurma);
                                            System.out.println("|--------------------------------------------------------|");
                                            System.out.println("|               CÓDIGO ALTERADO COM SUCESSO              |");
                                            System.out.println("|--------------------------------------------------------|");
                                            break;

                                        case 2:
                                            System.out.println("|--------------------------------------------------------|");
                                            System.out.println("|                    ALTERAÇÃO DE NOME                   |");
                                            System.out.println("|--------------------------------------------------------|");
                                            System.out.println("| ALTERANDO O NOME DA TURMA:" + turmaBusca.getNome());
                                            System.out.println("|--------------------------------------------------------|");
                                            System.out.println("| DIGITE O NOVO NOME DA TURMA:                           |");
                                            System.out.println("|--------------------------------------------------------|");
                                            String nomeAlterado = teclado.nextLine();
                                            turma.setNome(nomeAlterado);

                                            int codigotur2 = turmaBusca.getCodigo();
                                            turma.setCodigo(codigotur2);

                                            int quantAlunostur2 = turmaBusca.getQuantidadeAlunos();
                                            turma.setQuantidadeAlunos(quantAlunostur2);

                                            turma.setCodigo(idAlterarTurma);

                                            turmaDao.alteracao(turma, idAlterarTurma);

                                            System.out.println("|--------------------------------------------------------|");
                                            System.out.println("|                NOME ALTERADO COM SUCESSO               |");
                                            System.out.println("|--------------------------------------------------------|");
                                            break;

                                        case 3:
                                            System.out.println("|--------------------------------------------------------|");
                                            System.out.println("|       ALTERAÇÃO DE QUANTIDADE DE PARTICIPANTES         |");
                                            System.out.println("|--------------------------------------------------------|");
                                            System.out.println("| ALTERANDO A QUANTIADADE DA TURMA: " + turmaBusca.getNome());
                                            System.out.println("|--------------------------------------------------------|");
                                            System.out.println("| DIGITE A NOVA QUANTIDADE DA TURMA:                     |");
                                            System.out.println("|--------------------------------------------------------|");
                                            int qntAlterada = teclado.nextInt();
                                            turma.setQuantidadeAlunos(qntAlterada);

                                            int codigotur3 = turmaBusca.getCodigo();
                                            turma.setCodigo(codigotur3);

                                            String nometurma3 = turmaBusca.getNome();
                                            crian.setNome(nometurma3);

                                            turma.setCodigo(idAlterarTurma);

                                            turmaDao.alteracao(turma, idAlterarTurma);
                                            System.out.println("|--------------------------------------------------------|");
                                            System.out.println("|             QUANTIDADE ALTERADA COM SUCESSO            |");
                                            System.out.println("|--------------------------------------------------------|");

                                            break;
                                    }
                                }
                                break;

                            case 3:
                                System.out.println("|--------------------------------------------------------|");
                                System.out.println("|               BUSCAR CADASTRO DE TURMA                 |");
                                System.out.println("|--------------------------------------------------------|");
                                System.out.println("| DIGITE O CÓDIGO DA TURMA:                              |");
                                System.out.println("|--------------------------------------------------------|");
                                int idBuscaTurma = teclado.nextInt();
                                teclado.nextLine();

                                var buscaTurma = turmaDao.buscar(idBuscaTurma);

                                if (buscaTurma != null) {
                                    System.out.println("|--------------------------------------------------------|");
                                    System.out.println("| CÓDIGO: " + buscaTurma.getCodigo());
                                    System.out.println("| NOME: " + buscaTurma.getNome());
                                    System.out.println("| QUANTIDADE DE PARTICIPANTES: " + buscaTurma.getQuantidadeAlunos());
                                    System.out.println("|--------------------------------------------------------|");
                                } else {
                                    System.out.println("|--------------------------------------------------------|");
                                    System.out.println("| ATENÇÃO: ESSE ID NÃO ENCONTRADO                        |");
                                    System.out.println("|--------------------------------------------------------|");
                                }

                                break;
                            case 4:
                                System.out.println("|--------------------------------------------------------|");
                                System.out.println("|           EXCLUSÃO DE CADASTRO DE CUIDADOR             |");
                                System.out.println("|--------------------------------------------------------|");
                                System.out.println("| DIGITE O ID DO CUIDADOR:                               |");
                                System.out.println("|--------------------------------------------------------|");
                                var idExcluir3 = teclado.nextInt();
                                cuidador.setId(idExcluir3);

                                var verificaExc3 = turmaDao.buscar(idExcluir3);

                                if (verificaExc3 != null) {
                                    teclado.nextLine();
                                    System.out.println("|--------------------------------------------------------|");
                                    System.out.println("|          CADASTRO DA TURMA QUE SERÁ EXCLUÍDO:          |");
                                    System.out.println("|--------------------------------------------------------|");
                                    System.out.println("| CÓDIGO: " + verificaExc3.getCodigo());
                                    System.out.println("| NOME: " + verificaExc3.getNome());
                                    System.out.println("| QUANTIDADE DE PARTICIPANTES: " + verificaExc3.getQuantidadeAlunos());
                                    System.out.println("|--------------------------------------------------------|");
                                    System.out.println("| ATENÇÃO: DESEJA EXCLUIR ESSE CADASTRO? DIGITE: S ou N  |");
                                    System.out.println("|--------------------------------------------------------|");
                                    var respEx3 = teclado.nextLine();

                                    switch (respEx3) {
                                        case "S", "s":
                                            turmaDao.exclusao(idExcluir3);
                                            System.out.println("|--------------------------------------------------------|");
                                            System.out.println("|             CADASTRO EXCLUÍDO COM SUCESSO              |");
                                            System.out.println("|--------------------------------------------------------|");

                                            break;
                                        case "N", "n":
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
                                System.out.println("|--------------------------------------------------------|");
                                System.out.println("|                     LISTA DE TURMAS                    |");
                                System.out.println("|--------------------------------------------------------|");

                                for (Turma turmaList : turmaDao.listar()) {
                                    System.out.println("| CÓDIGO: " + turmaList.getCodigo());
                                    System.out.println("| NOME: " + turmaList.getNome());
                                    System.out.println("| QUANTIDADE DE PARTICIPANTES: " + turmaList.getQuantidadeAlunos());
                                    System.out.println("|--------------------------------------------------------|");
                                }

                                break;

                            case 6:
                                System.out.println("|--------------------------------------------------------|");
                                System.out.println("|                 SAIR DO MENU DE TURMA                  |");
                                System.out.println("|--------------------------------------------------------|");

                                break;
                            default:
                                System.out.println("|--------------------------------------------------------|");
                                System.out.println("|             OPÇÃO INVÁLIDA, TENTE NOVAMENTE            |");
                                System.out.println("|--------------------------------------------------------|");
                        }

                    }while(digitoTurma != 6);

                    break;

                case 4:
                    int digitoRespon;
                    do {
                        teclado.nextLine();
                        System.out.println("\n|--------------------------------------------------------|\n"
                                + "|                    MENU DE RESPONSÁVEL                 |\n"
                                + "|--------------------------------------------------------|\n"
                                + "| 1 - CADASTRAR                                          |\n"
                                + "| 2 - ALTERAR                                            |\n"
                                + "| 3 - BUSCAR                                             |\n"
                                + "| 4 - REMOVER                                            |\n"
                                + "| 5 - LISTAR                                             |\n"
                                + "| 6 - SAIR DO MENU DE RESPONSÁVEL                        |\n"
                                + "|--------------------------------------------------------|\n");

                        digitoRespon = teclado.nextInt();

                        switch (digitoRespon) {
                            case 1:
                                System.out.println("|--------------------------------------------------------|");
                                System.out.println("|                CADASTRO DE RESPONSÁVEL                 |");
                                System.out.println("|--------------------------------------------------------|");
                                System.out.println("| DIGITE O NOME DO RESPONSÁVEL:                          |");
                                System.out.println("|--------------------------------------------------------|");
                                responsavel.setNome(teclado.nextLine());
                                System.out.println("|--------------------------------------------------------|");
                                System.out.println("| DIGITE O CPF DO RESPONSÁVEL:                           |");
                                System.out.println("|--------------------------------------------------------|");
                                responsavel.setCpf(teclado.nextLine());
                                System.out.println("|--------------------------------------------------------|");
                                System.out.println("| DIGITE O SEXO DO RESPONSÁVEL:                          |");
                                System.out.println("|--------------------------------------------------------|");
                                responsavel.setSexo(teclado.nextLine());
                                System.out.println("|--------------------------------------------------------|");
                                System.out.println("| DIGITE A DATA DE NASCIMENTO DO RESPONSÁVEL:            |");
                                System.out.println("|--------------------------------------------------------|");
                                responsavel.setDataNascimento(teclado.nextLine());
                                System.out.println("|--------------------------------------------------------|");
                                System.out.println("| DIGITE O TELEFONE DO RESPONSÁVEL:                      |");
                                System.out.println("|--------------------------------------------------------|");
                                responsavel.setTelefone(teclado.nextLine());

                                responsDao.insert(responsavel);

                                System.out.println("|--------------------------------------------------------|");
                                System.out.println("|            CADASTRO CONCLUÍDO COM SUCESSO              |");
                                System.out.println("|--------------------------------------------------------|");

                                break;

                            case 2:
                                System.out.println("|--------------------------------------------------------|");
                                System.out.println("|          ALTERAÇÃO DE CADASTRO DO RESPONSÁVEL          |");
                                System.out.println("|--------------------------------------------------------|");
                                System.out.println("| DIGITE O ID DO RESPONSÁVEL QUE DESEJA ALTERAR:         |");
                                System.out.println("|--------------------------------------------------------|");
                                int idAlterarRespon = teclado.nextInt();

                                var responsBusca = responsDao.buscar(idAlterarRespon);

                                if (responsBusca == null) {
                                    System.out.println("|--------------------------------------------------------|");
                                    System.out.println("| ATENÇÃO: ESSE ID NÃO FOI ENCONTRADO                    |");
                                    System.out.println("|--------------------------------------------------------|");
                                } else {
                                    System.out.println("|--------------------------------------------------------|");
                                    System.out.println("|       INFORMAÇÕES RELACIONADAS AO ID ESCOLHIDO         |");
                                    System.out.println("|--------------------------------------------------------|");
                                    System.out.println("| NOME: " + responsBusca.getNome());
                                    System.out.println("| CPF: " + responsBusca.getCpf());
                                    System.out.println("| SEXO: " + responsBusca.getSexo());
                                    System.out.println("| DATA DE NASCIMENTO: " + responsBusca.getDataNascimento());
                                    System.out.println("| TELEFONE: " + responsBusca.getTelefone());
                                    System.out.println("|--------------------------------------------------------|");
                                    System.out.println("| O QUE PRECISA SER ALTERADO?                            |");
                                    System.out.println("|--------------------------------------------------------|");
                                    System.out.println("| 1 - NOME                                               |");
                                    System.out.println("| 2 - CPF                                                |");
                                    System.out.println("| 3 - SEXO                                               |");
                                    System.out.println("| 4 - DATA DE NASCIMENTO                                 |");
                                    System.out.println("| 5 - TELEFONE                                           |");
                                    System.out.println("|--------------------------------------------------------|");
                                    System.out.println("| DIGITE A OPÇÃO DESEJADA:                               |");
                                    System.out.println("|--------------------------------------------------------|");
                                    var opc4 = teclado.nextInt();

                                    teclado.nextLine();


                                    switch (opc4) {
                                        case 1:
                                            System.out.println("|--------------------------------------------------------|");
                                            System.out.println("|                    ALTERAÇÃO DE NOME                   |");
                                            System.out.println("|--------------------------------------------------------|");
                                            System.out.println("| ALTERANDO O NOME DO RESPONSÁVEL: " + responsBusca.getNome());
                                            System.out.println("|--------------------------------------------------------|");
                                            System.out.println("| DIGITE O NOVO NOME DO RESPONSÁVEL:                     |");
                                            System.out.println("|--------------------------------------------------------|");
                                            String nomeAlteradoR = teclado.nextLine();
                                            responsavel.setNome(nomeAlteradoR);

                                            String cpfresp = responsBusca.getCpf();
                                            responsavel.setCpf(cpfresp);

                                            String sexoresp = responsBusca.getSexo();
                                            responsavel.setSexo(sexoresp);

                                            String nascimentoresp = responsBusca.getDataNascimento();
                                            responsavel.setDataNascimento(nascimentoresp);

                                            String telefoneresp = responsBusca.getTelefone();
                                            responsavel.setTelefone(telefoneresp);

                                            responsavel.setId(idAlterarRespon);

                                            responsDao.alteracao(responsavel, idAlterarRespon);

                                            System.out.println("|--------------------------------------------------------|");
                                            System.out.println("|                NOME ALTERADO COM SUCESSO               |");
                                            System.out.println("|--------------------------------------------------------|");
                                            break;

                                        case 2:
                                            System.out.println("|--------------------------------------------------------|");
                                            System.out.println("|                    ALTERAÇÃO DE CPF                    |");
                                            System.out.println("|--------------------------------------------------------|");
                                            System.out.println("| ALTERANDO O CPF DO REPONSÁVEL: " + responsBusca.getNome());
                                            System.out.println("|--------------------------------------------------------|");
                                            System.out.println("| DIGITE O NOVO CPF DO RESPONSÁVEL:                      |");
                                            System.out.println("|--------------------------------------------------------|");
                                            String cpfAlteradoR = teclado.nextLine();
                                            responsavel.setCpf(cpfAlteradoR);

                                            String nomeresp2 = responsBusca.getNome();
                                            responsavel.setNome(nomeresp2);

                                            String sexoresp2 = responsBusca.getSexo();
                                            responsavel.setSexo(sexoresp2);

                                            String nascimentoresp2 = responsBusca.getDataNascimento();
                                            responsavel.setDataNascimento(nascimentoresp2);

                                            String telefoneresp2 = responsBusca.getTelefone();
                                            responsavel.setTelefone(telefoneresp2);

                                            responsavel.setId(idAlterarRespon);

                                            responsDao.alteracao(responsavel, idAlterarRespon);
                                            System.out.println("|--------------------------------------------------------|");
                                            System.out.println("|                 CPF ALTERADO COM SUCESSO               |");
                                            System.out.println("|--------------------------------------------------------|");
                                            break;

                                        case 3:
                                            System.out.println("|--------------------------------------------------------|");
                                            System.out.println("|                   ALTERAÇÃO DE SEXO                    |");
                                            System.out.println("|--------------------------------------------------------|");
                                            System.out.println("| ALTERANDO O SEXO DO RESPONSÁVEL: " + responsBusca.getNome());
                                            System.out.println("|--------------------------------------------------------|");
                                            System.out.println("| DIGITE O NOVO SEXO DO RESPONSÁVEL:                     |");
                                            System.out.println("|--------------------------------------------------------|");
                                            String sexoAlteradoR = teclado.nextLine();
                                            responsavel.setSexo(sexoAlteradoR);

                                            String nomeresp3 = responsBusca.getNome();
                                            responsavel.setNome(nomeresp3);

                                            String cpfresp3 = responsBusca.getCpf();
                                            responsavel.setCpf(cpfresp3);

                                            String nascimentoresp3 = responsBusca.getDataNascimento();
                                            responsavel.setDataNascimento(nascimentoresp3);

                                            String telefoneresp3 = responsBusca.getTelefone();
                                            responsavel.setTelefone(telefoneresp3);

                                            responsavel.setId(idAlterarRespon);

                                            responsDao.alteracao(responsavel, idAlterarRespon);

                                            System.out.println("|--------------------------------------------------------|");
                                            System.out.println("|                SEXO ALTERADO COM SUCESSO               |");
                                            System.out.println("|--------------------------------------------------------|");
                                            break;

                                        case 4:
                                            System.out.println("|--------------------------------------------------------|");
                                            System.out.println("|            ALTERAÇÃO DA DATA DE NASCIMENTO             |");
                                            System.out.println("|--------------------------------------------------------|");
                                            System.out.println("| ALTERANDO A DATA DE NASCIMENTO DO RESPONSÁVEL: " + responsBusca.getNome());
                                            System.out.println("|--------------------------------------------------------|");
                                            System.out.println("| DIGITE A DATA DE NASCIMENTO DO RESPONSÁVEL:            |");
                                            System.out.println("|--------------------------------------------------------|");
                                            String dataAlteradaR = teclado.nextLine();
                                            responsavel.setDataNascimento(dataAlteradaR);

                                            String nomeresp4 = responsBusca.getNome();
                                            responsavel.setNome(nomeresp4);

                                            String cpfresp4 = responsBusca.getCpf();
                                            responsavel.setCpf(cpfresp4);

                                            String sexoresp4 = responsBusca.getSexo();
                                            responsavel.setSexo(sexoresp4);

                                            String telefoneresp4 = responsBusca.getTelefone();
                                            responsavel.setTelefone(telefoneresp4);

                                            responsavel.setId(idAlterarRespon);

                                            responsDao.alteracao(responsavel, idAlterarRespon);
                                            System.out.println("|--------------------------------------------------------|");
                                            System.out.println("|        DATA DE NASCIMENTO ALTERADA COM SUCESSO         |");
                                            System.out.println("|--------------------------------------------------------|");
                                            break;

                                        case 5:
                                            teclado.nextLine();
                                            System.out.println("|--------------------------------------------------------|");
                                            System.out.println("|                ALTERAÇÃO DE TELEFONE                   |");
                                            System.out.println("|--------------------------------------------------------|");
                                            System.out.println("| ALTERANDO A MATRÍCULA DA CRIANÇA: " + responsBusca.getNome());
                                            System.out.println("|--------------------------------------------------------|");
                                            System.out.println("| DIGITE A NOVA MATRÍCULA DA CRIANÇA:                    |");
                                            System.out.println("|--------------------------------------------------------|");
                                            String telefoneAlteradoR = teclado.nextLine();
                                            responsavel.setTelefone(telefoneAlteradoR);

                                            String nomeresp5 = responsBusca.getNome();
                                            responsavel.setNome(nomeresp5);

                                            String cpfresp5 = responsBusca.getCpf();
                                            responsavel.setCpf(cpfresp5);

                                            String sexoresp5 = responsBusca.getSexo();
                                            responsavel.setSexo(sexoresp5);

                                            String nascimentoresp5 = responsBusca.getDataNascimento();
                                            responsavel.setDataNascimento(nascimentoresp5);

                                            responsavel.setId(idAlterarRespon);

                                            responsDao.alteracao(responsavel, idAlterarRespon);
                                            System.out.println("|--------------------------------------------------------|");
                                            System.out.println("|             TELEFONE ALTERADO COM SUCESSO              |");
                                            System.out.println("|--------------------------------------------------------|");

                                            break;

                                        default:
                                            System.out.println("|--------------------------------------------------------|");
                                            System.out.println("|             OPÇÃO INVÁLIDA, TENTE NOVAMENTE            |");
                                            System.out.println("|--------------------------------------------------------|");


                                    }
                                }
                                break;

                            case 3:
                                System.out.println("|--------------------------------------------------------|");
                                System.out.println("|            BUSCAR CADASTRO DE RESPONSÁVEL              |");
                                System.out.println("|--------------------------------------------------------|");
                                System.out.println("| DIGITE O ID DO RESPONSÁVEL:                            |");
                                System.out.println("|--------------------------------------------------------|");
                                int idBuscaResp = teclado.nextInt();

                                var buscaRespons = responsDao.buscar(idBuscaResp);


                                if (buscaRespons != null) {
                                    System.out.println("|--------------------------------------------------------|");
                                    System.out.println("| ID: " + buscaRespons.getId());
                                    System.out.println("| NOME: " + buscaRespons.getNome());
                                    System.out.println("| CPF: " + buscaRespons.getCpf());
                                    System.out.println("| SEXO: " + buscaRespons.getSexo());
                                    System.out.println("| DATA DE NASCIMENTO: " + buscaRespons.getDataNascimento());
                                    System.out.println("| TELEFONE: " + buscaRespons.getTelefone());
                                    System.out.println("|--------------------------------------------------------|");
                                } else {
                                    System.out.println("|--------------------------------------------------------|");
                                    System.out.println("| ATENÇÃO: ESSE ID NÃO ENCONTRADO                        |");
                                    System.out.println("|--------------------------------------------------------|");
                                }

                                break;

                            case 4:
                                System.out.println("|--------------------------------------------------------|");
                                System.out.println("|         EXCLUSÃO DE CADASTRO DE RESPONSÁVEL            |");
                                System.out.println("|--------------------------------------------------------|");
                                System.out.println("| DIGITE O ID DO RESPONSÁVEL:                            |");
                                System.out.println("|--------------------------------------------------------|");
                                var idExcluirResp = teclado.nextInt();
                                responsavel.setId(idExcluirResp);

                                var verificaExcResp = responsDao.buscar(idExcluirResp);

                                if (verificaExcResp != null) {
                                    teclado.nextLine();
                                    System.out.println("|--------------------------------------------------------|");
                                    System.out.println("|       CADASTRO DO RESPONSÁVEL QUE SERÁ EXCLUÍDO:       |");
                                    System.out.println("|--------------------------------------------------------|");
                                    System.out.println("| ID: " + verificaExcResp.getId());
                                    System.out.println("| NOME: " + verificaExcResp.getNome());
                                    System.out.println("| CPF: " + verificaExcResp.getCpf());
                                    System.out.println("| SEXO: " + verificaExcResp.getSexo());
                                    System.out.println("| DATA DE NASCIMENTO: " + verificaExcResp.getDataNascimento());
                                    System.out.println("| TELEFONE: " + verificaExcResp.getTelefone());
                                    System.out.println("|--------------------------------------------------------|");
                                    System.out.println("| ATENÇÃO: DESEJA EXCLUIR ESSE CADASTRO? DIGITE: S ou N  |");
                                    System.out.println("|--------------------------------------------------------|");
                                    var respEx = teclado.nextLine();

                                    switch (respEx) {
                                        case "S", "s":
                                            responsDao.exclusao(idExcluirResp);
                                            System.out.println("|--------------------------------------------------------|");
                                            System.out.println("|             CADASTRO EXCLUÍDO COM SUCESSO              |");
                                            System.out.println("|--------------------------------------------------------|");

                                            break;
                                        case "N", "n":
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
                                System.out.println("|--------------------------------------------------------|");
                                System.out.println("|                  LISTA DE RESPONSÁVEIS                 |");
                                System.out.println("|--------------------------------------------------------|");

                                for (Responsavel responList : responsDao.listar()) {
                                    System.out.println("| ID: " + responList.getId());
                                    System.out.println("| NOME: " + responList.getNome());
                                    System.out.println("| CPF: " + responList.getCpf());
                                    System.out.println("| SEXO: " + responList.getSexo());
                                    System.out.println("| DATA DE NASCIMENTO: " + responList.getDataNascimento());
                                    System.out.println("| TELEFONE: " + responList.getTelefone());
                                    System.out.println("|--------------------------------------------------------|");
                                }

                                break;
                            case 6:
                                System.out.println("|--------------------------------------------------------|");
                                System.out.println("|              SAIR DO MENU DE RESPONSÁVEL               |");
                                System.out.println("|--------------------------------------------------------|");
                                break;

                            default:
                                System.out.println("|--------------------------------------------------------|");
                                System.out.println("|             OPÇÃO INVÁLIDA, TENTE NOVAMENTE            |");
                                System.out.println("|--------------------------------------------------------|");
                        }
                        }while (digitoRespon != 6);

                    break;

                case 5:
                    int digitoExCurricular;
                    do {
                        teclado.nextLine();
                        System.out.println("\n|--------------------------------------------------------|\n"
                                + "|                  MENU DE EXTRACURRICULAR               |\n"
                                + "|--------------------------------------------------------|\n"
                                + "| 1 - CADASTRAR                                          |\n"
                                + "| 2 - ALTERAR                                            |\n"
                                + "| 3 - BUSCAR                                             |\n"
                                + "| 4 - REMOVER                                            |\n"
                                + "| 5 - LISTAR                                             |\n"
                                + "| 6 - SAIR DO MENU DE EXTRACURRICULAR                    |\n"
                                + "|--------------------------------------------------------|\n");

                        digitoExCurricular = teclado.nextInt();

                        switch (digitoExCurricular){
                            case 1:
                                System.out.println("|--------------------------------------------------------|");
                                System.out.println("|              CADASTRO DE EXTRACURRICULAR               |");
                                System.out.println("|--------------------------------------------------------|");
                                System.out.println("| DIGITE O CÓDIGO DA TURMA PARA A EXTRACURRICULAR:       |");
                                System.out.println("|--------------------------------------------------------|");
                                int codEx = teclado.nextInt();

                                var verificaCodEx = turmaDao.buscar(codEx);

                                if(verificaCodEx == null){
                                    System.out.println("|--------------------------------------------------------|");
                                    System.out.println("|    NÃO EXISTE TURMA COM ESSE CÓDIGO, TENTE NOVAMENTE   |");
                                    System.out.println("|--------------------------------------------------------|");
                                }else{
                                    System.out.println("|--------------------------------------------------------|");
                                    System.out.println("| DIGITE O CÓDIGO PARA EXTRACURRICULAR:                  |");
                                    System.out.println("|--------------------------------------------------------|");
                                    extraCurricular.setCod(teclado.nextInt());
                                    System.out.println("|--------------------------------------------------------|");
                                    System.out.println("| DIGITE O NOME DA EXTRACURRICULAR:                      |");
                                    System.out.println("|--------------------------------------------------------|");
                                    teclado.nextLine();
                                    extraCurricular.setNome(teclado.nextLine());
                                    System.out.println("|--------------------------------------------------------|");
                                    System.out.println("| DIGITE A MODALIDADE DA EXTRACURRICULAR:                |");
                                    System.out.println("|--------------------------------------------------------|");
                                    extraCurricular.setModalidade(teclado.nextLine());

                                    extraCurricular.setCodTurma(codEx);

                                    extraCurricularDao.insert(extraCurricular);

                                    System.out.println("|--------------------------------------------------------|");
                                    System.out.println("|            CADASTRO CONCLUÍDO COM SUCESSO              |");
                                    System.out.println("|--------------------------------------------------------|");
                                }

                                break;

                            case 2:

                                break;
                        }

                    }while (digitoExCurricular != 6);
                    break;

                case 6:
                    System.out.println("|--------------------------------------------------------|");
                    System.out.println("|                   SAINDO DO SISTEMA                    |");
                    System.out.println("|--------------------------------------------------------|");
                    break;

                default:
                    System.out.println("|--------------------------------------------------------|");
                    System.out.println("|             OPÇÃO INVÁLIDA, TENTE NOVAMENTE            |");
                    System.out.println("|--------------------------------------------------------|");

            }
            }while(digito != 6);
    }
}
