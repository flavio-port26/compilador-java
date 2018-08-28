
package compilador;

import java.util.Stack;


public class Compilador {

    public static void main(String args[]) {

        String texto
                = "Program testeproc1;\n"
                + "Var\n"
                + " X, y, z :integer;\n"
                + "Procedure P;\n"
                + "Var\n"
                + " A :integer;\n"
                + "Begin\n"
                + " Readln(a);\n"
                + " If a=x then\n"
                + " z:=z+x\n"
                + " Else begin\n"
                + " Z:=z-x;\n"
                + " Call p;\n"
                + " End;\n"
                + "End;\n"
                + "Begin\n"
                + " Z:=0;\n"
                + " Readln(x,y);\n"
                + " If x>y then\n"
                + " Call p\n"
                + " Else\n"
                + " Z:=z+x+y;\n"
                + " Writeln(z);\n"
                + "End. ";
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
                    if (prox.isSpaceChar(cont) == false) {
                        token.novoToken();  //Manda para o identificador o que esta no pronta quando nao tem mais texto
                        token.setCodigo(id.identReservada(pronta));
                        token.setNome(pronta);
                        token.setLinha(linha);
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
