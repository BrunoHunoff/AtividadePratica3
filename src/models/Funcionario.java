package models;

public abstract class Funcionario {

    private String nome;
    private int matricula;


    public Funcionario() {}

    public Funcionario(String nome, int matricula) {
        this.nome = nome;
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public Funcionario setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public int getMatricula() {
        return matricula;
    }

    public Funcionario setMatricula(int matricula) {
        this.matricula = matricula;
        return this;
    }

    public abstract float calcularSalario();

    @Override
    public String toString() {
        //sem exibir horas trabalhadas e valor por hora
        return "\nNome: " + nome +
                "\nMatrícula: " + matricula +
                "\nSalário: R$" + calcularSalario();
    }
}
