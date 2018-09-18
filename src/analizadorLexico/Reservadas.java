/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analizadorLexico;

/**
 *
 * @author comp16
 */
public class Reservadas {

    public Boolean passaInteiro(String token) {
        try {
            Integer.parseInt(token);
            return true;
        } catch (NumberFormatException e) {
        }
        return false;
    }

    public Boolean relacionais(String token) {
         return token.equals("=") || token.equals("<") || token.equals(">");
    }

    public Boolean especiais(String token) {
          return token.equals(",")
                || token.equals(";")
                || token.equals(".")
                || token.equals("(")
                || token.equals(")")
                || token.equals(":")
                || token.equals("..")
                || token.equals("[")
                || token.equals("]")
                || token.equals("_")
                || token.equals("'");
}
    public Boolean aritimeticos(String token){
        return token.equals("+") || token.equals("-") || token.equals("/")|| token.equals("*");
    }
    
        public Boolean comentario(String atual, String prox){
        if(atual.equals("(")&& prox.equals("*")){
            return true;
        }
        else return false;
    }

}