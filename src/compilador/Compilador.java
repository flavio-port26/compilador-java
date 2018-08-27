/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compilador;

import java.util.Stack;

/**
 *
 * @author User
 */
public class Compilador {

    public static void main(String args[]) {

        String nome = "oloko fala program";
        String pronta = "";
        Character prox = null;
        Character atual = null;
        Stack<String> pilha = new Stack();

        int cont = 1;

        for (int i = 0; i < nome.length(); i++) {
            atual = nome.charAt(i);
            pronta += atual.toString();

            if (cont < nome.length()) {
                System.out.println(prox = nome.charAt(cont));     //tratamento do exeption
                prox = nome.charAt(cont);

                if (prox.equals(' ')) {

                    pilha.push(pronta);           //tratamento do espaço
                    pronta = "";
                    
                }
                if (cont == nome.length() - 1) {
                    if (prox.isSpaceChar(cont) == false) {
                        pronta += prox;                 //tratamento ultimo caracter
                        pilha.push(pronta);
                        
                    }
                }
                   cont++;
                
            }

        Classificador c =new Classificador(pilha);
            
            
            
            
            
              
       /* 
         while (! pilha . isEmpty ()) 
    {
    System.out.println(pilha . peek());
}
        */
         

    }
    }

}
