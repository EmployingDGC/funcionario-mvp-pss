package com.pss;

import com.pss.model.Funcionario;
import com.pss.model.FuncionarioCollection;
import com.pss.view.PrincipalView;

/**
 * Hello world!
 */
public final class App {
    /**
     * Says hello to the world.
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        FuncionarioCollection funcionarios = FuncionarioCollection.getInstance();

        funcionarios.add(
            new Funcionario(
                "Davi Guizani",
                "dguizani",
                "12345678",
                1000.0
            )
        );

        funcionarios.add(
            new Funcionario(
                "Jeniffer",
                "koi",
                "12345678",
                1000.0
            )
        );

        funcionarios.add(
            new Funcionario(
                "Guilherme",
                "gui",
                "12345678",
                1000.0
            )
        );

        PrincipalView principalView = new PrincipalView();
        principalView.setVisible(true);
    }
}
