package br.com.unisales.freela.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.unisales.freela.model.Avaliacao;
import br.com.unisales.freela.model.Pedido;
import br.com.unisales.freela.repository.AvaliacaoRepository;
import br.com.unisales.freela.service.AvaliacaoService;

@RestController
@RequestMapping("/avaliacoes")
public class AvaliacaoController {

    @Autowired
    private AvaliacaoService service;

    @Autowired
    private AvaliacaoRepository repo;

    @PostMapping
    public ResponseEntity<Avaliacao> criar(@RequestBody Avaliacao avaliacao) {
        return ResponseEntity.ok(service.cadastrarAvaliacao(avaliacao));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Avaliacao> atualizar(@PathVariable Long id, @RequestBody Avaliacao avaliacao) {
        avaliacao.setId(id);
        return ResponseEntity.ok(service.atualizarAvaliacao(avaliacao));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Avaliacao> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(repo.findById(id)
            .orElseThrow(() -> new RuntimeException("Avaliação não encontrada com o ID: " + id)));
    }

    @GetMapping("/prestador/{idPrestador}")
    public ResponseEntity<List<Avaliacao>> listarPorPrestador(@PathVariable Long idPrestador) {
        return ResponseEntity.ok(repo.findByPedido_Prestador_Id(idPrestador));
    }

    @GetMapping("/nota/{nota}")
    public ResponseEntity<List<Avaliacao>> listarPorNota(@PathVariable Integer nota) {
        return ResponseEntity.ok(repo.findByNota(nota));
    }

    @GetMapping("/pedido/{idPedido}")
    public ResponseEntity<List<Avaliacao>> listarPorPedido(@PathVariable Long idPedido) {
        Pedido pedido = new Pedido();
        pedido.setId(idPedido);
        return ResponseEntity.ok(repo.findByPedido(pedido));
    }
}
