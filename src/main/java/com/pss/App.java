package com.pss;

import com.pss.collection.FuncionarioCollection;
import com.pss.model.Funcionario;
import com.pss.presenter.PrincipalPresenter;

/**
 * Hello world!
 */
public final class App {
    /**
     * Says hello to the world.
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        FuncionarioCollection funcionarios = FuncionarioCollection.getInstancia();

        funcionarios.add(
            new Funcionario(
                "Davi Guizani",
                "dguizani",
                "12345678",
                "Analista de Dados",
                1000.0
            )
        );

        funcionarios.add(
            new Funcionario(
                "Jeniffer",
                "koi",
                "12345678",
                "Streamer",
                1000.0
            )
        );

        funcionarios.add(
            new Funcionario(
                "Guilherme",
                "gui",
                "12345678",
                "Analista de Negócios",
                1000.0
            )
        );

        PrincipalPresenter principalView = new PrincipalPresenter();
        principalView.getJanela().setVisible(true);
    }
}
