package br.com.unisales.freela.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.unisales.freela.model.Pedido;
import br.com.unisales.freela.repository.PedidoRepository;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository repo;

    public Pedido cadastrarPedido(Pedido pedido) {
        return repo.save(pedido);
    }

    public Pedido buscarPedidoPorId(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado com o ID: " + id));
    }

    public List<Pedido> listarPedidos() {
        return repo.findAll();
    }

    public Pedido atualizarPedido(Pedido pedido) {
        Pedido existente = repo.findById(pedido.getId())
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado com o ID: " + pedido.getId()));

        existente.setServico(pedido.getServico());
        existente.setCliente(pedido.getCliente());
        existente.setPrestador(pedido.getPrestador());
        existente.setStatus(pedido.getStatus());
        existente.setDataConclusao(pedido.getDataConclusao());
        existente.setDataPedido(pedido.getDataPedido());
        existente.setAvaliacao(pedido.getAvaliacao());

        return repo.save(existente);
    }

    public void deletarPedido(Long id) {
        Pedido pedido = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado com o ID: " + id));
        repo.delete(pedido);
    }

    public List<Pedido> listarPedidosPorCliente(Long idCliente) {
        return repo.findByClienteId(idCliente);
    }

    public List<Pedido> listarPedidosPorPrestador(Long idPrestador) {
        return repo.findByPrestadorId(idPrestador);
    }
}
