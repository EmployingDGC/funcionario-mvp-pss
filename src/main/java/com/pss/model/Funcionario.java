package com.pss.model;

public class Funcionario extends Usuario {
    private double salario;

    public Funcionario(String nome, String login, String senha, double salario) {
        super(nome, login, senha);

        this.salario = salario;
    }

    public double getSalario() {
        return this.salario;
    }
}
