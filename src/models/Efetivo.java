package models;

public abstract class Efetivo extends Funcionario{

    private float valorHora;
    private int horasTrab;

    public Efetivo() {}

    public Efetivo(String nome, int matricula, float valorHora, int horasTrab) {
        super(nome, matricula);
        this.valorHora = valorHora;
        this.horasTrab = horasTrab;
    }

    public float getValorHora() {
        return valorHora;
    }

    public Efetivo setValorHora(float valorHora) {
        this.valorHora = valorHora;
        return this;
    }

    public int getHorasTrab() {
        return horasTrab;
    }

    public Efetivo setHorasTrab(int horasTrab) {
        this.horasTrab = horasTrab;
        return this;
    }

    @Override
    public float calcularSalario() {
        return horasTrab * valorHora;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
