/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pilha;

import java.util.Stack;

/**
 *
 * @author User
 */
public class Inverter {
    private Token insere;
    private Stack<Token> nova= new Stack<>();
    public Inverter inverte(Stack<Token> velha){
        while (!velha.empty()) {  
            nova.push(velha.pop());
            }
        return this;
     }
    public Stack<Token> pilha(){
        return nova;
    }
}
