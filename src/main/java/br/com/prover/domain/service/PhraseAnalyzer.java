package br.com.prover.domain.service;

import br.com.prover.domain.model.PhraseAnalysis;

import javax.enterprise.context.ApplicationScoped;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@ApplicationScoped
public class PhraseAnalyzer {

    public PhraseAnalysis analyze(final String phraseInput) {

        if (phraseInput == null || phraseInput.trim().isEmpty()) {
            return new PhraseAnalysis(phraseInput, 0, new HashMap<>());
        }

        /*
         * Minha idéia:
         * 1) Dividir a frase usando qualquer caractere não alfanumérico como separador (espaço, vírgula, ponto, etc.)
         * 2) Remove palavras vazias que poderiam surgir, ex: espaços duplos ou símbolos consecutivos.
         * 3) Optei por usar um método funcional onde: A própria palavra será a chave, valor inicial é 1 (primeira ocorrência) e por ultimo, soma se a palavra já existir (repetida)
         */

        final Map<String, Integer> wordMap = Arrays.stream(phraseInput.toLowerCase().split("\\W+"))
                .filter(word -> !word.trim().isEmpty())
                .collect(Collectors.toMap(
                        Function.identity(),
                        w -> 1,
                        Integer::sum
                ));

        return new PhraseAnalysis(phraseInput, wordMap.size(), wordMap);
    }

}
