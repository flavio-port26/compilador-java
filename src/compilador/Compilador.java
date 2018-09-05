
package compilador;

import java.util.Stack;


public class Compilador {

    public static void main(String args[]) {

        String texto
               = "Program ";
        String pronta = "";
        Character prox = null;
        Character atual = null;
        Token token = null;
        Stack<Token> pilha = new Stack();
        Identificador id = new Identificador(texto);
        int linha = 1;
        int cont = 1;
        
        for (int i = 0; i < texto.length(); i++) {
            atual = texto.charAt(i);
            pronta += atual.toString();

            if (cont < texto.length()) {

                prox = texto.charAt(cont);

                if (atual.equals('/') && prox.equals('n')) { //Conta +1 na linha quando acha um /n
                    linha++;
                }

                if (cont == texto.length() - 1) {
                    if (Character.isSpaceChar(prox)) {
                        token = Token.novoToken();  //Manda para o identificador o que esta no pronta quando nao tem mais texto
                        token.setCodigo(id.identReservada(pronta));
                        token.setNome(pronta);
                        token.setLinha(linha);
                        System.out.println(token);
                        pilha.push(token);
                        if(pronta.equals("+")){
                            
                        }
                        else if (prox.equals(' ')) {// |Manda para o  indentificador quando acha o prox for um espaço
                            token.novoToken();
                            token.setNome(pronta);
                            token.setLinha(linha);
                            pilha.push(token);

                        }
                    }
                }

                cont++;
            }
        }
    }
}
