package br.ufjf.dcc193.trabalho2.service;

import org.springframework.stereotype.Service;

import br.ufjf.dcc193.trabalho2.model.Avaliador;


@Service
public class LoginService {
    private static Avaliador usuaAvaliador = null;

    public LoginService(){

    }

    public void login(Avaliador avaliadorEmail)
    {
        usuaAvaliador = avaliadorEmail;

    }

    public Avaliador getAvaliador(){
        return usuaAvaliador;
    }

    public void logout() {
        usuaAvaliador = null;
    }

    
}