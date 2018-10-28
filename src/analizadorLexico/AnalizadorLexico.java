package analizadorLexico;

import pilha.MontaToken;


public class AnalizadorLexico {

    private MontaToken criaToken = new MontaToken();

    public void analizar(String texto) {

        Character prox;
        Character atual;
        int contLinha = 1;
        String aux = "";
        String inteiro = "";
        for (int i = 0; i < texto.length(); i++) {

            if (Character.isWhitespace(texto.charAt(i))) { // espaço em branco

                if (!aux.equals("")) {
                    criaToken.monta(aux.trim(), contLinha);
                    aux = "";
                }
                if (texto.charAt(i) == '\n') {
                    contLinha++;
                }
            } else {
                atual = texto.charAt(i);

                if (Character.isDigit(atual)) { // inteiro

                    if (!aux.equals("")) {
                        aux += atual.toString();

                    } else {

                        while (atual.isDigit(atual)) {
                            inteiro += atual;
                            i++;
                            atual = texto.charAt(i);
                        }
                        criaToken.monta(inteiro, contLinha);
                        inteiro = "";
                        i--;
                    }
                } else if (atual == ':') { //  :=

                    if (!aux.equals("")) {
                        criaToken.monta(aux.trim(), contLinha);
                        aux = "";
                    }
                    prox = texto.charAt(i + 1);
                    if (prox == '=') {
                        aux = atual.toString().trim() + prox.toString().trim();
                        criaToken.monta(aux.trim(), contLinha);
                        i++;
                        aux = "";
                    } else {

                        criaToken.monta(atual.toString().trim(), contLinha);
                    }
                } else if (atual == ',' || atual == ';' || atual == ')' || atual == '[' || atual == ']') {// especiais
                    if (!aux.equals("")) {
                        criaToken.monta(aux.trim(), contLinha);
                        aux = "";
                    }
                    criaToken.monta(atual.toString().trim(), contLinha);

                } else if (atual == '<' || atual == '>') { //relacionais
                    if (!aux.equals("")) {
                        criaToken.monta(aux.trim(), contLinha);
                        aux = "";
                    }
                    prox = texto.charAt(i + 1);
                    if (prox == '=') {
                        aux = atual.toString().trim() + prox.toString().trim();
                        criaToken.monta(aux.trim(), contLinha);
                        i++;

                    } else {

                        criaToken.monta(atual.toString().trim(), contLinha);
                    }
                } else if (atual == '+' || atual == '-' || atual == '*' || atual == '/' || atual == '=') {   //aritimeticos

                    if (!aux.equals("")) {
                        criaToken.monta(aux.trim(), contLinha);
                        aux = "";
                    }
                    prox = texto.charAt(i + 1);
                    if (atual == '-' && Character.isDigit(prox)) {
                        inteiro = atual.toString();
                       
                    } else {

                        criaToken.monta(atual.toString().trim(), contLinha);
                    }
                } else if (atual == '.') {      //   ..
                    if (!aux.equals("")) {
                        criaToken.monta(aux.trim(), contLinha);
                        aux = "";
                    }
                    prox = texto.charAt(i + 1);
                    if (prox == '.') {
                        aux = atual.toString().trim() + prox.toString().trim();
                        criaToken.monta(aux.trim(), contLinha);
                        aux = "";
                        i++;

                    } else {

                        criaToken.monta(atual.toString().trim(), contLinha);
                    }
                } else if (atual.toString().trim().equals("'")) {        // literais
                    if (!aux.equals("")) {
                        criaToken.monta(aux.trim(), contLinha);
                        aux = "";
                    }
                    while (!atual.toString().trim().equals("'")) {

                        i++;
                        atual = texto.charAt(i);
                    }
                    criaToken.monta("literal", contLinha);

                    i--;
                } else if (atual == '(') { //comentarios
                    if (!aux.equals("")) {
                        criaToken.monta(aux.trim(), contLinha);
                        aux = "";
                    }

                    prox = texto.charAt(i + 1);
                    if (prox == '*') {
                        int cont = i;
                        for (; i < texto.length(); i++) {
                            atual = texto.charAt(i);
                            cont++;
                            prox = texto.charAt(cont);
                            if (texto.charAt(i) == '\n') {
                                contLinha++;
                            }
                            if (atual == '*' && prox == ')') {
                                i++;
                                break;
                            }

                        }

                    } else {

                        criaToken.monta(atual.toString().trim(), contLinha);
                    }
                } else if(i==texto.length()-1){
                    if(!aux.equals("")){
                        aux+=atual.toString();
                       criaToken.monta(aux.trim(), contLinha);
                        aux = ""; 
                    }
                    
                }else {
                    aux += atual.toString().trim();

                }

            }
        }

    }

    public MontaToken pegaPilha() {
        return this.criaToken;
    }
}
