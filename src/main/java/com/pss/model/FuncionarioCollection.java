package com.pss.model;

import java.util.ArrayList;

import com.pss.error.InstanceNotFoundException;

public class FuncionarioCollection {
    private static FuncionarioCollection instance;

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
        return instance != null;
    }

    public static final FuncionarioCollection getInstance() {
        if (!hasInstance()) {
            instance = new FuncionarioCollection();
            instance.funcionarios = new ArrayList<Funcionario>();
        }

        return instance;
    }

    public void add(Funcionario e) {
        this.throwInstanceNotFoundException();

        this.funcionarios.add(e);
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

    public ArrayList<Funcionario> getFuncionarios() {
        return this.funcionarios;
    }
}
