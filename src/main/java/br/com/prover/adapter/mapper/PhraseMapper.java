package br.com.prover.adapter.mapper;

import br.com.prover.adapter.repository.entity.PhraseEntity;
import br.com.prover.domain.model.PhraseAnalysis;
import com.google.gson.Gson;

import javax.enterprise.context.ApplicationScoped;


@ApplicationScoped
public class PhraseMapper {

    private final Gson gson = new Gson();

    public PhraseEntity toEntity(final PhraseAnalysis analysis) {
        final PhraseEntity entity = new PhraseEntity();
        entity.setOriginalPhrase(analysis.getOriginalPhrase());
        entity.setDistinctWordCount(analysis.getDistinctWords());
        final String json = gson.toJson(analysis.getWordOccurrences());
        entity.setWordOccurrencesJson(json);
        return entity;
    }
}
