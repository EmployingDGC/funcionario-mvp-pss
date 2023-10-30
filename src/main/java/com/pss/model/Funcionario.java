package com.pss.model;

public class Funcionario extends Usuario {
    private String cargo;
    private double salario;

    public Funcionario(String nome, String login, String senha, String cargo, double salario) {
        super(nome, login, senha);

        this.salario = salario;
        this.cargo = cargo.trim().toLowerCase();
    }

    public double getSalario() {
        return this.salario;
    }

    public String getCargo() {
        return this.cargo;
    }

    @Override
    public String toString() {
        return (
            super.toString() + "\n"
            + "Cargo: " + this.cargo + "\n"
            + "Salário: " + Double.toString(this.salario)
        );
    }
}
