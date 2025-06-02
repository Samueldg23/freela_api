package br.com.unisales.freela.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.unisales.freela.model.Servico;
import br.com.unisales.freela.service.ServicoService;

@RestController
@RequestMapping("/servicos")
@CrossOrigin
public class ServicoController {

    @Autowired
    private ServicoService service;

    @PostMapping
    public ResponseEntity<Servico> cadastrarServico(@RequestBody Servico servico) {
        Servico novo = service.cadastrarServico(servico);
        return ResponseEntity.status(201).body(novo);
    }

    @GetMapping
    public List<Servico> listarTodos() {
        return service.listarServicos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Servico> buscarPorId(@PathVariable Long id) {
        Servico servico = service.buscarPorId(id);
        return ResponseEntity.ok(servico);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Servico> atualizar(@PathVariable Long id, @RequestBody Servico atualizado) {
        atualizado.setId(id);
        Servico servico = service.atualizarServico(atualizado);
        return ResponseEntity.ok(servico);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletarServico(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/prestador/{idPrestador}")
    public List<Servico> listarPorPrestador(@PathVariable Long idPrestador) {
        return service.listarServicosPorPrestador(idPrestador);
    }

    @GetMapping("/categoria/{categoria}")
    public List<Servico> listarPorCategoria(@PathVariable Servico.Categoria categoria) {
        return service.listarServicosPorCategoria(categoria);
    }

    @GetMapping("/buscar")
    public List<Servico> buscarPorNome(@RequestParam String nome) {
        return service.listarServicosPorNome(nome);
    }
}
