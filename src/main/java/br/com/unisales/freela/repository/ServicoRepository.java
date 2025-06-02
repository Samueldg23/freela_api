package br.com.unisales.freela.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.unisales.freela.model.Servico;

@Repository
public interface ServicoRepository extends JpaRepository<Servico, Long> {
    List<Servico> findByCategoria(Servico.Categoria categoria);
    List<Servico> findByNomeContainingIgnoreCase(String nome); 
    List<Servico> findByIdPrestador(Long idPrestador);
}
