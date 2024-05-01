package controllers;

import models.Desenvolvedor;
import models.Estagiario;
import models.Funcionario;
import models.Gerente;

import java.util.ArrayList;
import java.util.List;

public class FuncionariosController {

    private static List<Funcionario> listaFuncionarios = new ArrayList<>();

    public static void adicionarFuncionario(Funcionario temp) {
        listaFuncionarios.add(temp);
    }

    public static boolean removerFuncionario(int mat) {
        for (Funcionario funcionario: listaFuncionarios) {
            if (funcionario.getMatricula() == mat) {
                listaFuncionarios.remove(funcionario);
                return true;
            }
        }
        return false;
    }

    public static Funcionario buscaFuncionario(int mat) {
        for (Funcionario funcionario: listaFuncionarios) {
            if (funcionario.getMatricula() == mat) {
                return funcionario;
            }
        }
        return null;
    }

    public static List<Funcionario> getFuncionarios() {
        return listaFuncionarios;
    }

    public static ArrayList<Funcionario> listarGerentes() {
        ArrayList<Funcionario> temp = new ArrayList<>();
        for (Funcionario funcionario: listaFuncionarios) {
            if (funcionario instanceof Gerente) {
                temp.add(funcionario);
            }
        }
        return temp;
    }

    public static ArrayList<Funcionario> listarDesenvolvedores() {
        ArrayList<Funcionario> temp = new ArrayList<>();
        for (Funcionario funcionario: listaFuncionarios) {
            if (funcionario instanceof Desenvolvedor) {
                temp.add(funcionario);
            }
        }
        return temp;
    }

    public static ArrayList<Funcionario> listarEstagiarios() {
        ArrayList<Funcionario> temp = new ArrayList<>();
        for (Funcionario funcionario: listaFuncionarios) {
            if (funcionario instanceof Estagiario) {
                temp.add(funcionario);
            }
        }
        return temp;
    }
}
