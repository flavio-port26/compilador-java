/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analizadorSintatico;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author comp15
 */
public class NaoTerminais {

    public int tabela(String  nome) {

        Map<String, Integer> nTerminal = new HashMap<>();
        nTerminal.put("PROGRAMA", 52);
        nTerminal.put("BLOCO", 53);
        nTerminal.put("DCLROT", 54);
        nTerminal.put("LID", 55);
        nTerminal.put("REPIDENT", 56);
        nTerminal.put("DCLCONST", 57);
        nTerminal.put("LDCONST", 58);
        nTerminal.put("DCLVAR", 59);
        nTerminal.put("LDVAR", 60);
        nTerminal.put("TIPO", 61);
        nTerminal.put("DCLPROC", 62);
        nTerminal.put("DEFPAR", 63);
        nTerminal.put("CORPO", 64);
        nTerminal.put("REPCOMANDO", 65);
        nTerminal.put("COMANDO", 66);
        nTerminal.put("RCOMID", 67);
        nTerminal.put("RVAR", 68);
        nTerminal.put("PARAMETROS", 69);
        nTerminal.put("REPPAR", 70);
        nTerminal.put("ELSEPARTE", 71);
        nTerminal.put("VARIAVEL", 72);
        nTerminal.put("VARIAVEL1", 73);
        nTerminal.put("REPVARIAVEL ", 74);
        nTerminal.put("ITEMSAIDA", 75);
        nTerminal.put("REPITEM", 76);
        nTerminal.put("EXPRESSAO", 77);
        nTerminal.put("REPEXPSIMP", 78);
        nTerminal.put("EXPSIMP", 79);
        nTerminal.put("REPEXP", 80);
        nTerminal.put("TERMO", 81);
        nTerminal.put("REPTERMO", 82);
        nTerminal.put("FATOR", 83);
        nTerminal.put("CONDCASE", 84);
        nTerminal.put("CONTCASE", 85);
        nTerminal.put("RPINTEIRO", 86);

        if (nTerminal.containsKey(nome.toUpperCase())) {
            
            return nTerminal.get(nome.toUpperCase());
        } else {
            return 87;
        }
    }
}
