package com.pss.model;

import com.pss.error.ObjectNotNullException;

public class Pessoa {
    private String nome;

    public Pessoa(String nome) {
        if (nome == null) {
            throw new ObjectNotNullException("Nome não pode ser nulo");
        }

        this.nome = nome.trim().toLowerCase();
    }

    public String getNome() {
        return this.nome;
    }
}
