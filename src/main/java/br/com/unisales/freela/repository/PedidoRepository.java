package br.com.unisales.freela.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.unisales.freela.model.Pedido;
import br.com.unisales.freela.model.Usuario;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    List<Pedido> findByCliente(Usuario cliente);
    List<Pedido> findByPrestador(Usuario prestador);
    List<Pedido> findByStatus(Pedido.Status status);

    List<Pedido> findByClienteId(Long idCliente);
    List<Pedido> findByPrestadorId(Long idPrestador);
}
