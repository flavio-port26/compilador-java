/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pilha;

import java.util.Stack;

/**
 *
 * @author comp15
 */
public class MontaPilha {

    private String nome;
    private final Stack<Token> pilha = new Stack();
    private Token token;
    Verificador id = new Verificador();

    public void monta(String nome) {
        this.nome = nome;

        token = Token.novoToken();

        token.setCodigo(id.identReservada(nome));
        token.setNome(nome);
        pilha.push(token);
    }

    public Stack<Token> pilha() {
        return pilha;
    }

}
