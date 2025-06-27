package br.com.prover.port.input;

import br.com.prover.domain.model.PhraseAnalysis;

public interface AnalyzePhraseInputPort {
    PhraseAnalysis execute(String input);
}
