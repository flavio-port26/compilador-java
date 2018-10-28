package analizadorSintatico;

import pilha.MontaToken;

public class Producao {

    TabelaProducao tabela = new TabelaProducao();
    MontaToken derivacao = new MontaToken();

    public MontaToken derivar(int entrada, int producao) {
        String prod = tabela
                .getDerivacao(entrada, producao);
        if (prod == null) {
            //throw new ErroSintatico(token);
        }
        adicionarProducoes(separarEmProducoes(prod));
        return derivacao;
    }

    private String[] separarEmProducoes(String derivacao) {
        return derivacao.split("\\|");
    }

    private void adicionarProducoes(String[] producoesArray) {
        for (int i = producoesArray.length - 1; 0 <= i; i--) {
            if (!producoesArray[i].equals("NULL")) {
                derivacao.monta(producoesArray[i], 0);
            }

        }
    }
}
