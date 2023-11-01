package com.pss.model;

import com.pss.error.ObjectNotNullException;

public class Pessoa {
    private String nome;

    public Pessoa(String nome) {
        this.setNome(nome);
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        if (nome == null) {
            throw new ObjectNotNullException("Nome não pode ser nulo");
        }

        this.nome = nome.trim().toLowerCase();

        if (this.nome.equals("")) {
            throw new ObjectNotNullException("Nome não pode ser vazio");
        }
    }

    public boolean equals(Pessoa p) {
        return (
            p != null
            && this.nome.equals(p.nome)
        );
    }

    @Override
    public String toString() {
        return (
            "Nome: " + this.nome
        );
    }
}
