package br.com.unisales.freela.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.unisales.freela.model.Servico;
import br.com.unisales.freela.repository.ServicoRepository;

@Service
public class ServicoService {

    @Autowired
    private ServicoRepository repo;

    public Servico cadastrarServico(Servico servico) {
        return repo.save(servico);
    }

    public Servico buscarPorId(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Serviço não encontrado com o ID: " + id));
    }

    public List<Servico> listarServicos() {
        return repo.findAll();
    }

    public Servico atualizarServico(Servico servico) {
        Servico existente = repo.findById(servico.getId())
                .orElseThrow(() -> new RuntimeException("Serviço não encontrado com o ID: " + servico.getId()));

        existente.setNome(servico.getNome());
        existente.setDescricao(servico.getDescricao());
        existente.setCategoria(servico.getCategoria());
        existente.setValor(servico.getValor());
        existente.setPrestador(servico.getPrestador());

        return repo.save(existente);
    }

    public void deletarServico(Long id) {
        Servico existente = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Serviço não encontrado com o ID: " + id));
        repo.delete(existente);
    }

    public List<Servico> listarServicosPorPrestador(Long idPrestador) {
        return repo.findByIdPrestador(idPrestador);
    }

    public List<Servico> listarServicosPorCategoria(Servico.Categoria categoria) {
        return repo.findByCategoria(categoria);
    }

    public List<Servico> listarServicosPorNome(String nome) {
        return repo.findByNomeContainingIgnoreCase(nome);
    }
}
