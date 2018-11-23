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
public class MontaToken {

    private String nome;
    private final Stack<Token> pilha = new Stack();
    private Token token;
    private final Verificador id = new Verificador();

    public void montaLexico(String nome, int linha) {
        this.nome = nome;

        token = Token.novoToken();
        token.setLinha(linha);
        token.setCodigo(id.identReservada(nome));
        token.setNome(nome);
        pilha.push(token);
    }

    public void montaInteiro(String nome, int linha) {
        this.nome = nome;

        token = Token.novoToken();
        token.setLinha(linha);
        token.setCodigo(id.identReservada("inteiro"));
        token.setNome(nome);
        pilha.push(token);
    }

    public Stack<Token> pilha() {
        return pilha;
    }

}
