package br.com.unisales.freela.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.unisales.freela.model.Avaliacao;
import br.com.unisales.freela.model.Pedido;

@Repository
public interface AvaliacaoRepository extends JpaRepository<Avaliacao, Long> {
    List<Avaliacao> findByPedido(Pedido pedido);
    List<Avaliacao> findByNota(Integer nota);
    List<Avaliacao> findByPedido_Prestador_Id(Long idPrestador);

}
