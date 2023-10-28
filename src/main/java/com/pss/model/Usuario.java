package com.pss.model;

import com.pss.error.ObjectNotNullException;
import com.pss.error.PasswordLengthException;

public class Usuario extends Pessoa {
    private String login;
    private String senha;

    public Usuario(String nome, String login, String senha) {
        super(nome);
        this.setLogin(login);
        this.setSenha(senha);
    }

    public boolean equals(Usuario usuario) {
        return (
            usuario.login.equals(this.login)
            && usuario.senha.equals(this.senha)
        );
    }

    public String getLogin() {
        return this.login;
    }

    public void setLogin(String login) {
        if (login == null) {
            throw new ObjectNotNullException(
                "Login não pode ser nulo"
            );
        }

        this.login = login.trim().toLowerCase();

        if (this.login.equals("")) {
            throw new ObjectNotNullException(
                "Login não pode ser vazio"
            );
        }
    }

    public String getSenha() {
        return "***";
    }
    
    public void setSenha(String senha) {
        if (senha == null) {
            throw new ObjectNotNullException(
                "Senha não pode ser nula"
            );
        }
    
        if (senha.length() < 8) {
            throw new PasswordLengthException(
                "Senha deve conter 8 ou mais caracteres"
            );
        }
        
        this.senha = senha;
    }
}
