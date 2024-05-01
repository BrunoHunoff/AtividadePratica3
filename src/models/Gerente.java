package models;

//Interface 'Trabalhavel' implementada na Superclasse abstrata 'Funcionario'

public class Gerente extends Efetivo{

    private Float bonusAnual;
    private String time;

    public Gerente() {}

    public Gerente(String nome, int matricula, float valorHora, int horasTrab, Float bonusAnual, String time) {
        super(nome, matricula, valorHora, horasTrab);
        this.bonusAnual = bonusAnual;
        this.time = time;
    }

    public Float getBonusAnual() {
        return bonusAnual;
    }

    public Gerente setBonusAnual(Float bonusAnual) {
        this.bonusAnual = bonusAnual;
        return this;
    }

    public String getTime() {
        return time;
    }

    public Gerente setTime(String time) {
        this.time = time;
        return this;
    }

    @Override
    public String trabalhar() {
        return "Supervisionando...";
    }

    @Override
    public String relatarProgresso() {
        return "Tive 200 reuniões pela manhã";
    }

    @Override
    public String toString() {
        return "\nGerente: " + super.toString() +
                "\nTime gerenciado: " + time +
                "\nBônus anual: R$" + bonusAnual;
    }
}
