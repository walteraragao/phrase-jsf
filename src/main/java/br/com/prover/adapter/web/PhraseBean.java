package br.com.prover.adapter.web;

import br.com.prover.domain.model.PhraseAnalysis;
import br.com.prover.port.input.AnalyzePhraseInputPort;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;


@Named("phraseBean")
@ViewScoped
public class PhraseBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String input;
    private PhraseAnalysis result;

    @Inject
    private AnalyzePhraseInputPort useCase;

    public void analyze() {
        result = useCase.execute(input);
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public PhraseAnalysis getResult() {
        return result;
    }

    public void setResult(PhraseAnalysis result) {
        this.result = result;
    }
}
