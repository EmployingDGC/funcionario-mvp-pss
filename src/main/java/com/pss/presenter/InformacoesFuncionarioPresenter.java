package com.pss.presenter;

import com.pss.error.ObjectNotNullException;
import com.pss.model.Funcionario;
import com.pss.model.FuncionarioCollection;

public class InformacoesFuncionarioPresenter {
    private InformacoesFuncionarioPresenter() {}

    public final static void cadastrarFuncionario(Funcionario funcionario) {
        if (funcionario == null) {
            throw new ObjectNotNullException("Funcionário não pode ser nulo");
        }

        FuncionarioCollection.getInstance().add(funcionario);
    }

    public final static void excluirFuncionario(Funcionario funcionario) {
        if (funcionario == null) {
            throw new ObjectNotNullException("Funcionário não pode ser nulo");
        }

        FuncionarioCollection.getInstance().remove(funcionario);
    }
}
