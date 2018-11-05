/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analizadorSemantico;

import java.lang.reflect.Array;
import java.util.Stack;
import pilha.Inverter;
import pilha.Token;

/**
 *
 * @author comp15
 */
public class AnalizadorSemantico {
    public void analiza(Stack<Token> vpilha){
        Inverter inv = new Inverter();
        Stack<Token> pilha = new Stack<>();      
        inv.inverte(vpilha);
        pilha= inv.pilha();
        int nivel=0;
        String entrada;
       Stack<Variaveis> variaveis = new Stack<>();
  
        
        while(!pilha.isEmpty()){
          if (pilha.peek().getCodigo()==1){
               Variaveis var= new Variaveis();
               var.setCategoria(var.categoria(pilha.pop().getNome()));
               var.setTipo(0);
               var.setNome(pilha.pop().getNome());
               var.setNivel(nivel);
               variaveis.push(var);
               
          }else if(pilha.peek().getCodigo()==2){
               Variaveis var= new Variaveis();
               var.setCategoria(var.categoria(pilha.pop().getNome()));
               var.setTipo(0);
               var.setNome(pilha.pop().getNome());
          }
        }
        
        
        
        
    }
}
