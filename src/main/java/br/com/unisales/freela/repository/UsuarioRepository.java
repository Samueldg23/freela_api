package br.com.unisales.freela.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.unisales.freela.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findByEmailAndSenha(String email, String senha);
    Optional<Usuario> findByEmail(String email);
    List<Usuario> findByTipoUsuario(Usuario.TipoUsuario tipoUsuario);
}
