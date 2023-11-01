package com.pss.model;

import com.pss.error.NegativeValueException;
import com.pss.error.ObjectNotNullException;
import com.pss.error.ZeroValueException;

public class Funcionario extends Usuario {
    private String cargo;
    private double salario;

    public Funcionario(String nome, String login, String senha, String cargo, double salario) {
        super(nome, login, senha);
        this.setSalario(salario);
        this.setCargo(cargo);
    }

    public boolean equals(Funcionario f) {
        return (
            super.equals(f)
            && this.salario == f.salario
            && this.cargo.equals(f.cargo)
        );
    }

    public double getSalario() {
        return this.salario;
    }

    public void setSalario(double salario) {
        if (salario < 0) {
            throw new NegativeValueException("Salário não pode ser negativo");
        }

        if (salario == 0) {
            throw new ZeroValueException("Salário não pode ser zero");
        }

        this.salario = salario;
    }

    public String getCargo() {
        return this.cargo;
    }

    public void setCargo(String cargo) {
        if (cargo == null) {
            throw new ObjectNotNullException("Cargo não pode ser nulo");
        }

        this.cargo = cargo.trim().toLowerCase();

        if (this.cargo.equals("")) {
            throw new ObjectNotNullException("Cargo não pode ser vazio");
        }
    }
    
    public Funcionario copy() {
        return new Funcionario(
            this.getNome(),
            this.getLogin(),
            this.getSenha(false),
            this.cargo,
            this.salario
        );
    }

    public void update(Funcionario f) {
        this.setNome(f.getNome());
        this.setLogin(f.getLogin());
        this.setSenha(f.getSenha(false));
        this.setCargo(f.getCargo());
        this.setSalario(f.getSalario());
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
