package br.com.prover.domain.model;

import lombok.AllArgsConstructor;

import java.util.Map;

@AllArgsConstructor
public class PhraseAnalysis {

    private final String originalPhrase;
    private int distinctWords;
    private Map<String, Integer> wordOccurrences;

    public String getOriginalPhrase() {
        return originalPhrase;
    }

    public Map<String, Integer> getWordOccurrences() {
        return wordOccurrences;
    }

    public void setWordOccurrences(Map<String, Integer> wordOccurrences) {
        this.wordOccurrences = wordOccurrences;
    }

    public int getDistinctWords() {
        return distinctWords;
    }

    public void setDistinctWords(int distinctWords) {
        this.distinctWords = distinctWords;
    }
}
