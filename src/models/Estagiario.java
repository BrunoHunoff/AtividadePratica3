package models;

import controllers.Trabalhavel;

public class Estagiario extends Funcionario implements Trabalhavel{

    private int horasEstagio;
    private String curso;
    private Efetivo supervisor;

    public Estagiario(String nome, int matricula, int horasEstagio, String curso, Efetivo supervisor) {
        super(nome, matricula);
        this.horasEstagio = horasEstagio;
        this.curso = curso;
        this.supervisor = supervisor;
    }

    public Estagiario() {}

    public int getHorasEstagio() {
        return horasEstagio;
    }

    public Estagiario setHorasEstagio(int horasEstagio) {
        this.horasEstagio = horasEstagio;
        return this;
    }

    public String getCurso() {
        return curso;
    }

    public Estagiario setCurso(String curso) {
        this.curso = curso;
        return this;
    }

    public Efetivo getSupervisor() {
        return supervisor;
    }

    public Estagiario setSupervisor(Efetivo supervisor) {
        this.supervisor = supervisor;
        return this;
    }

    @Override
    public String trabalhar() {
        return "Tenho uma dúvida";
    }

    @Override
    public String relatarProgresso() {
        return "Subi mais 20 bugs para produção :)";
    }

    @Override
    public float calcularSalario() {
        //Salário fixo para estagiários
        return 1200;
    }

    @Override
    public String toString() {
        return "Estagiário: " + super.toString() +
                "\nHoras de estágio: " + horasEstagio +
                "\nCurso: " + curso +
                "\nSupervisor: " + supervisor.getNome();
    }
}
