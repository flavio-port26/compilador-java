package analizadorLexico;

import java.util.Stack;

public class Compilador {

    public Stack<Token> analizar(String texto) {

        texto = texto.replaceAll("/n", " ");
        Character prox;
        Character atual;
        Token token;
        Stack<Token> pilha = new Stack();
        Identificador id = new Identificador();
        String monta = "";

        int aux = 0;
        Reservadas reservada = new Reservadas();

        for (int i = 0; i < texto.length(); i++) {

            atual = texto.charAt(i);
            monta += atual.toString();
            if (aux != texto.length() - 1) {
                aux++;
            }

            prox = texto.charAt(aux);
            if (atual.toString().equals(" ")) { //ignora espaço

            } else if (reservada.aritimeticos(monta.trim())) {// reservada aritimetico

                token = Token.novoToken();
                token.setCodigo(id.identReservada(monta.trim()));
                token.setNome(monta.trim());
                pilha.push(token);
                monta = "";
            } else if (atual.toString().equals(reservada.especiais("'"))) {    //literal erro

                while (!atual.toString().equals("'")) {
                    i++;
                    atual = texto.charAt(i);
                    monta = atual.toString();
                }
                i++;
                aux = i + 1;
                token = Token.novoToken();
                token.setCodigo(id.identReservada("literal"));
                token.setNome(monta);
                pilha.push(token);
                monta = "";

            } else if (reservada.especiais(monta.trim())) { // reservada especial
                if (prox.toString().trim().equals("=")) {
                    monta += prox.toString();
                    token = Token.novoToken();
                    token.setCodigo(id.identReservada(monta.trim()));
                    token.setNome(monta.trim());
                    pilha.push(token);
                    monta = "";
                    i++;
                    aux++;
                } else {
                    token = Token.novoToken();
                    token.setCodigo(id.identReservada(monta.trim()));
                    token.setNome(monta.trim());
                    pilha.push(token);
                    monta = "";
                }

            } else if (reservada.relacionais(atual.toString())) { // reservada relacional
                if (reservada.relacionais(prox.toString())) {
                    System.out.println("4");

                    i++;

                    monta = atual.toString() + prox.toString();
                    token = Token.novoToken();
                    token.setCodigo(id.identReservada(monta.trim()));
                    token.setNome(monta.trim());
                    pilha.push(token);
                    monta = "";
                } else {

                    token = Token.novoToken();
                    token.setCodigo(id.identReservada(monta.trim()));
                    token.setNome(monta.trim());
                    pilha.push(token);
                    monta = "";
                }

            } else if (prox.toString().equals(" ") // se po proximo for reservada
                    || reservada.aritimeticos(prox.toString())
                    || reservada.especiais(prox.toString())
                    || reservada.relacionais(prox.toString())
                    || reservada.aritimeticos(prox.toString())) {
                if (reservada.passaInteiro(monta.trim())) { // se é inteiro
                    System.out.println("6");

                    token = Token.novoToken();
                    token.setNome(monta.trim());
                    token.setCodigo(id.identReservada("inteiro"));
                    pilha.push(token);
                    monta = "";
                } else {

                    token = Token.novoToken();

                    token.setCodigo(id.identReservada(monta.trim()));
                    token.setNome(monta.trim());
                    pilha.push(token);
                    monta = "";
                }

            } else if (aux == texto.length() - 1) { // se é o ultimo caracter

                monta += prox.toString();
                token = Token.novoToken();
                token.setCodigo(id.identReservada(monta.trim()));
                token.setNome(monta.trim());
                pilha.push(token);
                break;

            }

        }
        for(int i=0;i<pilha.size();i++){
            if(pilha.get(i).getNome().trim().equals("")){
                pilha.remove(i);
            }
        }
        return pilha;
    }
}
