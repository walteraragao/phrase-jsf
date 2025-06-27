package br.com.prover.domain.service;

import br.com.prover.domain.model.PhraseAnalysis;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;


public class PhraseAnalyzerTest {

    private final PhraseAnalyzer analyzer = new PhraseAnalyzer();

    @Test
    public void shouldReturnEmptyAnalysisWhenInputIsNull() {
        PhraseAnalysis result = analyzer.analyze(null);
        assertNotNull(result);
        assertEquals(0, result.getDistinctWords());
        assertTrue(result.getWordOccurrences().isEmpty());
    }

    @Test
    public void shouldReturnEmptyAnalysisWhenInputIsEmpty() {
        PhraseAnalysis result = analyzer.analyze("   ");
        assertNotNull(result);
        assertEquals(0, result.getDistinctWords());
        assertTrue(result.getWordOccurrences().isEmpty());
    }

    @Test
    public void shouldAnalyzePhraseCorrectly() {
        String phrase = "Prover Java test JSF test Java";
        PhraseAnalysis result = analyzer.analyze(phrase);

        assertEquals(4, result.getDistinctWords());
        assertEquals(Integer.valueOf(2), result.getWordOccurrences().get("java"));
        assertEquals(Integer.valueOf(2), result.getWordOccurrences().get("test"));
        assertEquals(Integer.valueOf(1), result.getWordOccurrences().get("jsf"));
        assertEquals(Integer.valueOf(1), result.getWordOccurrences().get("prover"));
    }

    @Test
    public void shouldHandleSpecialCharactersAndNormalizeCase() {
        String phrase = "JSF, jsf! JSF? jsf.";
        PhraseAnalysis result = analyzer.analyze(phrase);

        assertEquals(1, result.getDistinctWords());
        assertEquals(Integer.valueOf(4), result.getWordOccurrences().get("jsf"));
    }
}