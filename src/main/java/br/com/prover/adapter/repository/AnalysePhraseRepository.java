package br.com.prover.adapter.repository;

import br.com.prover.adapter.mapper.PhraseMapper;
import br.com.prover.adapter.repository.entity.PhraseEntity;
import br.com.prover.domain.model.PhraseAnalysis;
import br.com.prover.port.output.AnalyzePhrasePersistOutputPort;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AnalysePhraseRepository implements AnalyzePhrasePersistOutputPort {

    @PersistenceContext
    private EntityManager em;

    @Inject
    private PhraseMapper mapper;

    @Override
    @Transactional
    public void save(PhraseAnalysis analysis) {
        PhraseEntity entity = mapper.toEntity(analysis);
        em.persist(entity);
    }
}
