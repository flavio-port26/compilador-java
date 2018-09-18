/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analizadorSintatico;

import analizadorLexico.Token;
import java.util.Stack;

/**
 *
 * @author comp15
 */
public class Analizador {
    public void analiza(Stack<Token> terminais){
        String nome="program";
        nTerminal nt = new nTerminal();
        Stack<nTerminal> pilhaSintatica= new Stack();
        NaoTerminais identificador= new NaoTerminais();
        
        nt.setCod(identificador.tabela(nome));
        nt.setNome(nome);
        pilhaSintatica.push(nt);
        
        
    }
}
