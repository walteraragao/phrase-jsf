package br.com.prover.adapter.repository.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "phrase_analysis")
public class PhraseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    @Column(nullable = false)
    private String originalPhrase;

    @Column(nullable = false)
    private int distinctWordCount;

    @Lob
    @Column(nullable = false)
    private String wordOccurrencesJson;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOriginalPhrase() {
        return originalPhrase;
    }

    public void setOriginalPhrase(String originalPhrase) {
        this.originalPhrase = originalPhrase;
    }

    public int getDistinctWordCount() {
        return distinctWordCount;
    }

    public void setDistinctWordCount(int distinctWordCount) {
        this.distinctWordCount = distinctWordCount;
    }

    public String getWordOccurrencesJson() {
        return wordOccurrencesJson;
    }

    public void setWordOccurrencesJson(String wordOccurrencesJson) {
        this.wordOccurrencesJson = wordOccurrencesJson;
    }
}
