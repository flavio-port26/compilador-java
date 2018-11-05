/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analizadorSintatico;

import pilha.MontaPilha;
import pilha.Token;
import java.util.Stack;

/**
 *
 * @author comp15
 */
public class Derivacao {

    TabelaParcing tabela = new TabelaParcing();
    int pilha2;

    MontaPilha pilha = new MontaPilha();

    public Derivacao(MontaPilha pilha, int pilha2) {
        this.pilha = pilha;
        this.pilha2 = pilha2;
    }

    public MontaPilha derivar() {
        String derivacao = tabela
                .getDerivacao(pilha.pilha().peek().getCodigo(), pilha2);
        if (derivacao == null) {
            System.out.println("Erro");
        }
        if (derivacao.equals("NULL")) {
            return pilha;
        }
        adicionarProducoes(separarEmProducoes(derivacao));
        return pilha;
    }

    private String[] separarEmProducoes(String derivacao) {
        return derivacao.split("\\|");
    }

    private void adicionarProducoes(String[] producoesArray) {
        for (int i = producoesArray.length - 1; 0 <= i; i--) {
            pilha.monta(producoesArray[i]);
        }
    }
}
