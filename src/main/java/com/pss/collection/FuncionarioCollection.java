package com.pss.collection;

import java.util.ArrayList;

import com.pss.error.DuplicatedLoginException;
import com.pss.error.InstanceNotFoundException;
import com.pss.model.Funcionario;

public class FuncionarioCollection {
    private static FuncionarioCollection instancia;

    private ArrayList<Funcionario> funcionarios;

    private FuncionarioCollection() {}

    private final void throwInstanceNotFoundException() {
        if (!hasInstance()) {
            throw new InstanceNotFoundException(
                "Instância não existente, favor utilizar o método getInstance()"
            );
        }
    }
    
    public static boolean hasInstance() {
        return instancia != null;
    }

    public static FuncionarioCollection getInstancia() {
        if (!hasInstance()) {
            instancia = new FuncionarioCollection();
            instancia.funcionarios = new ArrayList<Funcionario>();
        }

        return instancia;
    }

    public void add(Funcionario f) {
        this.throwInstanceNotFoundException();

        if (this.get(f.getLogin()) != null) {
            throw new DuplicatedLoginException(
                String.format(
                    "Login '%s' Já existe",
                    f.getLogin()
                )
            );
        }
        
        this.funcionarios.add(f);
    }

    public void remove(int i) {
        this.funcionarios.remove(i);
    }

    public void remove(Funcionario f) {
        this.funcionarios.remove(f);
    }

    public Funcionario get(int i) {
        return this.funcionarios.get(i);
    }

    public Funcionario get(String login) {
        for (Funcionario f: this.funcionarios) {
            if (f.getLogin().equals(login)) {
                return f;
            }
        }

        return null;
    }

    public ArrayList<Funcionario> getFuncionarios() {
        return this.funcionarios;
    }
}
