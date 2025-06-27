package br.com.prover.application.usecase;

import br.com.prover.domain.model.PhraseAnalysis;
import br.com.prover.domain.service.PhraseAnalyzer;
import br.com.prover.port.input.AnalyzePhraseInputPort;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class AnalyzePhraseUseCase implements AnalyzePhraseInputPort {

    @Inject
    private PhraseAnalyzer analyzer;

    @Override
    public PhraseAnalysis execute(final String input) {
        return analyzer.analyze(input);
    }
}
