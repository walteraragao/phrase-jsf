package br.com.prover.port.output;

import br.com.prover.domain.model.PhraseAnalysis;

public interface AnalyzePhrasePersistOutputPort {
    void save(PhraseAnalysis analysis);
}
