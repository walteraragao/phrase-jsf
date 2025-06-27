package br.com.prover.application.usecase;

import br.com.prover.domain.model.PhraseAnalysis;
import br.com.prover.domain.service.PhraseAnalyzer;
import br.com.prover.port.output.AnalyzePhrasePersistOutputPort;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;


public class AnalyzePhraseUseCaseTest {

    @Mock
    private PhraseAnalyzer analyzer;

    @InjectMocks
    private AnalyzePhraseUseCase useCase;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldAnalyzeAndPersistPhrase() {
        final String phrase = "Prover test test jsf";

        final Map<String, Integer> wordMap = new HashMap<>();
        wordMap.put("prover", 1);
        wordMap.put("test", 2);
        wordMap.put("jsf", 1);

        PhraseAnalysis expected = new PhraseAnalysis(phrase, 3, wordMap);
        when(analyzer.analyze(phrase)).thenReturn(expected);

        PhraseAnalysis result = useCase.execute(phrase);

        assertEquals(3, result.getDistinctWords());
        assertEquals(2, result.getWordOccurrences().get("test").intValue());

    }
}
