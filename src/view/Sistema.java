package view;

import controllers.FuncionariosController;
import models.*;

//Testar matrícula ja existem emcadastro de funcionário

public class Sistema {
    public static String nome;
    public static int matricula;

    public static float valorHora;
    public static int horasTrab;

    public static void executar() {
        int op;

        do {
            exibirMenu();
            op = Console.lerInt();
            verificarOp(op);
        } while (op!= 0);
    }

    private static void exibirMenu() {
        System.out.println("\nGerenciamento de Funcionários:");
        System.out.println("1 - Cadastrar Gerente");
        System.out.println("2 - Cadastrar Desenvolvedor");
        System.out.println("3 - Cadastrar Estagiário");
        System.out.println("4 - Remover Funcionário");
        System.out.println("5 - Buscar Funcionário");
        System.out.println("6 - Listar Gerentes");
        System.out.println("7 - Listar Desenvolvedores");
        System.out.println("8 - Listar Estagiários");
        System.out.println("9 - Listar Funcionários");
        System.out.println("0 - Encerrar");
        System.out.print("Opção: ");
    }

    private static void  verificarOp(int op) {
        switch (op) {
            case 1:
                cadastrarGerente();
                break;
            case 2:
                cadastrarDesenvolvedor();
                break;
            case 3:
                cadastrarEstagiario();
                break;
            case 4:
                removerFuncionario();
                break;
            case 5:
                buscarFuncionario();
                break;
            case 6:
                listarGerentes();
                break;
            case 7:
                listarDesenvolvedores();
                break;
            case 8:
                listarEstagiarios();
                break;
            case 9:
                listarFuncionarios();
                break;
            case 0:
                break;
            default:
                System.out.println("Opção inválida!");
                break;
        }

    }

    private static void cadastrarFuncionario() {
        System.out.print("Nome: ");
        nome = Console.lerString();
        System.out.print("Matrícula: ");
        matricula = Console.lerInt();
    }

    private static void cadastrarEfetivo() {
        cadastrarFuncionario();
        System.out.print("Valor por hora: ");
        valorHora = Console.lerFloat();
        System.out.print("Horas trabalhadas: ");
        horasTrab = Console.lerInt();
    }

    private static void cadastrarGerente() {
         float bonusAnual;
        String time;

        System.out.println("\nCadastro de Gerente:\n");
        cadastrarEfetivo();
        System.out.print("Bonus Anual: ");
        bonusAnual = Console.lerFloat();
        System.out.print("Time Gerenciado: ");
        time = Console.lerString();

        Gerente temp = new Gerente(nome, matricula, valorHora, horasTrab, bonusAnual, time);

        FuncionariosController.adicionarFuncionario(temp);
        System.out.println("Gerente cadastrado com sucesso!");
    }

    private static void cadastrarDesenvolvedor() {
        String tecnologia;
        String senioridade;

        System.out.println("\nCadastro de Desenvolvedor:\n");
        cadastrarEfetivo();
        System.out.print("Tecnologia: ");
        tecnologia = Console.lerString();
        System.out.print("Senioridade: ");
        senioridade = Console.lerString();

        Desenvolvedor temp = new Desenvolvedor(nome, matricula, valorHora, horasTrab, tecnologia, senioridade);

        FuncionariosController.adicionarFuncionario(temp);
        System.out.println("Desenvolvedor cadastrado com sucesso!");
    }

    private static void cadastrarEstagiario() {
        int horasEstagio;
        String curso;
        int matriculaSupervisor;
        Funcionario supervisor;

        System.out.println("\nCadastro de Estagiário:\n");
        cadastrarFuncionario();
        System.out.print("Horas de estágio: ");
        horasEstagio = Console.lerInt();
        System.out.print("Curso: ");
        curso = Console.lerString();
        System.out.print("Matrícula do Supervisor: ");
        matriculaSupervisor = Console.lerInt();

        supervisor = FuncionariosController.buscaFuncionario(matriculaSupervisor);

        if (supervisor == null) {
            System.out.println("Supervisor não encontrado!");
            return;
        }

        if (supervisor instanceof Estagiario) {
            System.out.println("Apenas um funcionário efetivado pode ser supervisor!");
            return;
        }

        Estagiario temp = new Estagiario(nome, matricula, horasEstagio, curso, (Efetivo) supervisor);

        FuncionariosController.adicionarFuncionario(temp);
        System.out.println("Estagiário cadastrado com sucesso!");
    }

    private static void removerFuncionario() {
        System.out.println("\nRemover funcionário:\n");

        System.out.print("Matrícula: ");
        matricula = Console.lerInt();

        if(FuncionariosController.removerFuncionario(matricula)) {
            System.out.println("Funcionário removido com sucesso!");
            return;
        }

        System.out.println("Funcionário não encontrado!");
    }

    private static void buscarFuncionario() {
        System.out.println("\nBuscar funcionário:\n");

        System.out.print("Matrícula: ");
        matricula = Console.lerInt();

        Funcionario temp = FuncionariosController.buscaFuncionario(matricula);

        if(temp == null) {
            System.out.println("Funcionário não encontrado!");
            return;
        }

        System.out.println(temp);
    }

    private static void listarGerentes() {
        if (FuncionariosController.listarGerentes().isEmpty()) {
            System.out.println("Não há gerentes cadastrados!");
            return;
        }
        for (Funcionario temp: FuncionariosController.listarGerentes()) {
            System.out.println(temp);
        }
    }

    private static void listarDesenvolvedores() {
        if (FuncionariosController.listarDesenvolvedores().isEmpty()) {
            System.out.println("\nNão há desenvolvedores cadastrados!");
            return;
        }
        for (Funcionario temp: FuncionariosController.listarDesenvolvedores()) {
            System.out.println(temp);
        }
    }

    private static void listarEstagiarios () {
        if (FuncionariosController.listarEstagiarios().isEmpty()) {
            System.out.println("\nNão há estagiários cadastrados!");
            return;
        }
        for (Funcionario temp: FuncionariosController.listarEstagiarios()) {
            System.out.println(temp);
        }
    }

    private static void listarFuncionarios() {
        if (FuncionariosController.getFuncionarios().isEmpty()) {
            System.out.println("Não há funcionários cadastrados!");
            return;
        }
        for (Funcionario temp: FuncionariosController.getFuncionarios()) {
            System.out.println(temp);
        }
    }
}