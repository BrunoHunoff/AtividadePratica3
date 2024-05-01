package models;

import controllers.Trabalhavel;

//Optei por chamar a interface 'Trabalhável' na superclasse pois todas as subclasses implementarão a função

//Essa abordagem foi necessária para poder chamar os métodos 'trabalhar'e 'relatarProgresso' dentro de loops
//forEach com o tipo (Funcionario)

public abstract class Funcionario implements Trabalhavel {

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
