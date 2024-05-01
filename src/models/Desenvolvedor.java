package models;

//Interface 'Trabalhavel' implementada na Superclasse abstrata 'Funcionario'

public class Desenvolvedor extends Efetivo{

    private String tecnologia;
    private String senioridade;

    public Desenvolvedor() {}

    public Desenvolvedor(String nome, int matricula, float valorHora, int horasTrab, String tecnologia, String senioridade) {
        super(nome, matricula, valorHora, horasTrab);
        this.tecnologia = tecnologia;
        this.senioridade = senioridade;
    }

    public String getTecnologia() {
        return tecnologia;
    }

    public Desenvolvedor setTecnologia(String tecnologia) {
        this.tecnologia = tecnologia;
        return this;
    }

    public String getSenioridade() {
        return senioridade;
    }

    public Desenvolvedor setSenioridade(String senioridade) {
        this.senioridade = senioridade;
        return this;
    }

    @Override
    public String trabalhar() {
        return "Codando...";
    }

    @Override
    public String relatarProgresso() {
        return "Passei o dia corrigindo os bugs do estagiário";
    }

    @Override
    public String toString() {
        return "Desenvolvedor:" + super.toString() +
                "\nTecnologia: " + tecnologia +
                "\nSenioridade: " + senioridade;
    }
}
