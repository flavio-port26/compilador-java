/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analizadorLexico;     

/**
 *
 * @author User
 */
public class Token {
    private String nome;
    private int codigo;


 

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    public static Token novoToken(){
        return new Token();
    }

    @Override
    public String toString() {
        return "Token: " + "nome= " + nome + ", codigo= " + codigo;
    }
}
