package br.com.unisales.freela.service;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.unisales.freela.model.Avaliacao;
import br.com.unisales.freela.repository.AvaliacaoRepository;

@Service
public class AvaliacaoService {

    @Autowired
    private AvaliacaoRepository repo;

    public Avaliacao cadastrarAvaliacao(Avaliacao avaliacao) {
        avaliacao.setDataAvaliacao(LocalDateTime.now());
        return repo.save(avaliacao);
    }

    public Avaliacao atualizarAvaliacao(Avaliacao avaliacao) {
        Avaliacao existente = repo.findById(avaliacao.getId())
            .orElseThrow(() -> new RuntimeException("Avaliação não encontrada com o ID: " + avaliacao.getId()));

        existente.setComentario(avaliacao.getComentario());
        existente.setNota(avaliacao.getNota());
        existente.setDataAvaliacao(LocalDateTime.now());
        existente.setPedido(avaliacao.getPedido());

        return repo.save(existente);
    }
}
