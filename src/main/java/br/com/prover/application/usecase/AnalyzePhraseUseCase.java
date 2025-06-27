package br.com.prover.application.usecase;

import br.com.prover.domain.model.PhraseAnalysis;
import br.com.prover.domain.service.PhraseAnalyzer;
import br.com.prover.port.input.AnalyzePhraseInputPort;
import br.com.prover.port.output.AnalyzePhrasePersistOutputPort;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class AnalyzePhraseUseCase implements AnalyzePhraseInputPort {

    @Inject
    private PhraseAnalyzer analyzer;
    @Inject
    private AnalyzePhrasePersistOutputPort analyzePhrasePersistOutputPort;

    @Override
    public PhraseAnalysis execute(final String input) {
        final PhraseAnalysis phraseAnalysis = analyzer.analyze(input);
        analyzePhrasePersistOutputPort.save(phraseAnalysis);
        return phraseAnalysis;
    }
}
