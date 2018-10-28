/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analizadorSintatico;

import java.util.Stack;
import pilha.MontaToken;
import pilha.Token;

/**
 *
 * @author comp15
 */
public class AnalizadorSintatico {

    private final Stack<Token> entrada;
    private  Producao montar;
    MontaToken producao= new MontaToken();
    public AnalizadorSintatico(Stack<Token> entrada) {
        this.entrada = entrada;

    }

    public void analisar()  {
    String inicial="programa";
    producao.monta(inicial, 0);
        while (!entrada.empty()) {
     
            if (entrada.peek().getCodigo() < 52) {
                if (entrada.peek().getCodigo() == producao.pilha().peek().getCodigo()) {
                    entrada.pop();
                    producao.pilha().pop();
                } else {
                    System.out.println("erro");//erro
                }
            } else {
                
               producao=montar.derivar(entrada.peek().getCodigo(), producao.pilha().pop().getCodigo());
            }
        }
        if (!entrada.empty() || !producao.pilha().isEmpty()) {
            System.out.println("erro"); //erro
        }
        System.out.println("deutudo certo");
    }
}
