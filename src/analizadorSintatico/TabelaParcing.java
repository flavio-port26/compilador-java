/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analizadorSintatico;

/**
 *
 * @author comp15
 */
public class TabelaParcing {

    public String verifica(int pilha1, int pilha2) {
        String nome = "";
        

        return nome;
    }
}
/*<item codigo="52,1" derivacao="PROGRAM|IDENTIFICADOR|;|BLOCO|." />
	<item codigo="53,2" derivacao="DCLROT|DCLCONST|DCLVAR|DCLPROC|CORPO" />

	<item codigo="53,3" derivacao="DCLROT|DCLCONST|DCLVAR|DCLPROC|CORPO" />
	<item codigo="53,4" derivacao="DCLROT|DCLCONST|DCLVAR|DCLPROC|CORPO" />
	<item codigo="53,5" derivacao="DCLROT|DCLCONST|DCLVAR|DCLPROC|CORPO" />
	<item codigo="53,6" derivacao="DCLROT|DCLCONST|DCLVAR|DCLPROC|CORPO" />
	<item codigo="54,2" derivacao="LABEL|LID|;" />
	<item codigo="55,25" derivacao="IDENTIFICADOR|REPIDENT" />
	<item codigo="56,46" derivacao=",|IDENTIFICADOR|REPIDENT" />
	<item codigo="57,3" derivacao="CONST|IDENTIFICADOR|=|INTEIRO|;|LDCONST" />
	<item codigo="58,25" derivacao="IDENTIFICADOR|=|INTEIRO|;|LDCONST" />
	<item codigo="59,4" derivacao="VAR|LID|:|TIPO|;|LDVAR" />
	<item codigo="60,25" derivacao="LID|:|TIPO|;|LDVAR" />
	<item codigo="61,8" derivacao="INTEGER" />
	<item codigo="61,9" derivacao="ARRAY|[|INTEIRO|..|INTEIRO|]|OF|INTEGER" />
	<item codigo="62,5" derivacao="PROCEDURE|IDENTIFICADOR|DEFPAR|;|BLOCO|;|DCLPROC" />
	<item codigo="63,36" derivacao="(|LID|:|INTEGER|)" />
	<item codigo="64,6" derivacao="BEGIN|COMANDO|REPCOMANDO|END" />
	<item codigo="65,47" derivacao=";|COMANDO|REPCOMANDO" />
	<item codigo="66,6" derivacao="CORPO" />
	<item codigo="66,11" derivacao="CALL|IDENTIFICADOR|PARAMETROS" />
	<item codigo="66,12" derivacao="GOTO|IDENTIFICADOR" />
	<item codigo="66,13" derivacao="IF|EXPRESSAO|THEN|COMANDO|ELSEPARTE" />
	<item codigo="66,16" derivacao="WHILE|EXPRESSAO|DO|COMANDO" />
	<item codigo="66,20" derivacao="READLN|(|VARIAVEL|REPVARIAVEL|)" />
	<item codigo="66,21" derivacao="WRITELN|(|ITEMSAIDA|REPITEM|)" />	
	<item codigo="66,25" derivacao="IDENTIFICADOR|RCOMID" />
	<item codigo="66,27" derivacao="FOR|IDENTIFICADOR|:=|EXPRESSAO|TO|EXPRESSAO|DO|COMANDO" />
	<item codigo="66,29" derivacao="CASE|EXPRESSAO|OF|CONDCASE|END" />
	<item codigo="67,34" derivacao="RVAR|:=|EXPRESSAO" />
	<item codigo="67,38" derivacao="RVAR|:=|EXPRESSAO" />	
	<item codigo="67,39" derivacao=":|COMANDO" />
	<item codigo="68,34" derivacao="[|EXPRESSAO|]" />
	<item codigo="69,36" derivacao="(|EXPRESSAO|REPPAR|)" />
	<item codigo="70,46" derivacao=",|EXPRESSAO|REPPAR" />
	<item codigo="71,15" derivacao="ELSE|COMANDO" />
	<item codigo="72,25" derivacao="IDENTIFICADOR|VARIAVEL1" />
	<item codigo="73,34" derivacao="[|EXPRESSAO|]" />
	<item codigo="74,46" derivacao=",|VARIAVEL|REPVARIAVEL" />
	<item codigo="75,24" derivacao="EXPRESSAO" />
	<item codigo="75,25" derivacao="EXPRESSAO" />
	<item codigo="75,26" derivacao="EXPRESSAO" />
	<item codigo="75,30" derivacao="EXPRESSAO" />
	<item codigo="75,31" derivacao="EXPRESSAO" />
	<item codigo="75,36" derivacao="EXPRESSAO" />
	<item codigo="75,48" derivacao="LITERAL" />
	<item codigo="76,46" derivacao=",|ITEMSAIDA|REPITEM" />
	<item codigo="77,24" derivacao="EXPSIMP|REPEXPSIMP" />
	<item codigo="77,25" derivacao="EXPSIMP|REPEXPSIMP" />
	<item codigo="77,26" derivacao="EXPSIMP|REPEXPSIMP" />
	<item codigo="77,30" derivacao="EXPSIMP|REPEXPSIMP" />
	<item codigo="77,31" derivacao="EXPSIMP|REPEXPSIMP" />
	<item codigo="77,36" derivacao="EXPSIMP|REPEXPSIMP" />
	<item codigo="78,40" derivacao="=|EXPSIMP" />
	<item codigo="78,41" derivacao=">|EXPSIMP" />
	<item codigo="78,42" derivacao=">=|EXPSIMP" />
	<item codigo="78,43" derivacao="&lt;|EXPSIMP" /><!-- Sinal de menor -->
	<item codigo="78,44" derivacao="&lt;=|EXPSIMP" /><!-- Sinal de menor ou igual -->
	<item codigo="78,45" derivacao="&lt;&gt;|EXPSIMP" /><!-- Sinal de diferente -->
	<item codigo="79,24" derivacao="TERMO|REPEXP" />
	<item codigo="79,25" derivacao="TERMO|REPEXP" />
	<item codigo="79,26" derivacao="TERMO|REPEXP" />
	<item codigo="79,30" derivacao="+|TERMO|REPEXP" />
	<item codigo="79,31" derivacao="-|TERMO|REPEXP" />
	<item codigo="79,36" derivacao="TERMO|REPEXP" />
	<item codigo="80,22" derivacao="OR|TERMO|REPEXP" />
	<item codigo="80,30" derivacao="+|TERMO|REPEXP" />
	<item codigo="80,31" derivacao="-|TERMO|REPEXP" />
	<item codigo="81,24" derivacao="FATOR|REPTERMO" />
	<item codigo="81,25" derivacao="FATOR|REPTERMO" />
	<item codigo="81,26" derivacao="FATOR|REPTERMO" />
	<item codigo="81,36" derivacao="FATOR|REPTERMO" />	
	<item codigo="82,23" derivacao="AND|FATOR|REPTERMO" />
	<item codigo="82,32" derivacao="*|FATOR|REPTERMO" />
	<item codigo="82,33" derivacao="/|FATOR|REPTERMO" />
	<item codigo="83,24" derivacao="NOT|FATOR" />
	<item codigo="83,25" derivacao="VARIAVEL" />
	<item codigo="83,26" derivacao="INTEIRO" />
	<item codigo="83,36" derivacao="(|EXPRESSAO|)" />
	<item codigo="84,26" derivacao="INTEIRO|RPINTEIRO|:|COMANDO|CONTCASE" />	
	<item codigo="85,47" derivacao=";|CONDCASE" />
	<item codigo="86,46" derivacao=",|INTEIRO|RPINTEIRO" />*/
